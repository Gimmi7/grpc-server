package com.wcy.service;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.google.protobuf.ByteString;
import com.wcy.dao.DynamodbDao;
import com.wcy.scenario.*;
import com.wcy.util.Company2item;
import com.wcy.util.GetCompanyFromFS;
import com.wcy.util.MappedFileReader;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class ScenarioService extends ScenarioGrpc.ScenarioImplBase {
    @Autowired
    DynamodbDao dao;

    @Override
    public StreamObserver<Person> cheekIn(StreamObserver<Empty> responseObserver) {
        try {
            String path= ResourceUtils.getURL("classpath:").getPath();
            File file=new File(path+"/checked_in_people.txt");
            FileWriter fw=new FileWriter(file,true);
            PrintWriter pw=new PrintWriter(fw);

            return new StreamObserver<Person>() {
                @Override
                public void onNext(Person person) {
                    pw.println(person.getName());
                    System.out.println(person.getName());
                        pw.flush();
                }

                @Override
                public void onError(Throwable throwable) {
                    System.err.println("cheekIn error");
                }

                @Override
                public void onCompleted() {
                    try {
                        fw.flush();
                        pw.close();
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void chunker(Empty request, StreamObserver<Chunk> responseObserver) {
        try {
            MappedFileReader reader=new MappedFileReader("/root/视频/origin.mp4", 1048576);
            while (reader.read()!=-1){
                byte[] array=reader.getArray();
                Chunk chunk=Chunk.newBuilder().setChunk(ByteString.copyFrom(array)).build();
                responseObserver.onNext(chunk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getCompanies(CompanyName request, StreamObserver<Company> responseObserver) {

        new Thread(){
            @Override
            public void run() {
                try {
                    Company company=new GetCompanyFromFS().get(request.getCompanyName());
                    sleep(5000);
                    responseObserver.onNext(company);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

                Iterator<Item> iterator=dao.queryItem(request);
                Item item=iterator.next();
                Company company=Company.newBuilder()
                        .setName(item.getString("name")).setStoredIn(item.getString("storedIn")).build();
                responseObserver.onNext(company);
    }

    @Override
    public StreamObserver<Company> batchWriteCompanies(StreamObserver<Empty> responseObserver) {
        Set<Item> itemSet=new HashSet<>();
        return new StreamObserver<Company>() {
            @Override
            public void onNext(Company company) {

                Item item= Company2item.company2item(company);
                itemSet.add(item);
            }

            @Override
            public void onError(Throwable throwable) {

                System.err.println("batchWriteCompanies error");
            }

            @Override
            public void onCompleted() {

                dao.batchWriteItem(itemSet);
                System.out.println("batch write some items!!");
            }
        };
    }

    @Override
    public StreamObserver<Sentence> translate(StreamObserver<Sentence> responseObserver) {

        return new StreamObserver<Sentence>() {
            @Override
            public void onNext(Sentence sentence) {
                String str=sentence.getSentence();
                char c=str.charAt(0);
                String strEn;
                switch (c){
                    case '你': strEn="hello";
                    break;
                    case '今': strEn="Today is Wednesday";
                    break;
                    case '再': strEn="byebye";
                    break;
                    default: strEn="can not match!";
                }
                Sentence returnSentence= Sentence.newBuilder().setSentence(strEn).build();
                responseObserver.onNext(returnSentence);
            }

            @Override
            public void onError(Throwable throwable) {

                System.err.println("translate error");
            }

            @Override
            public void onCompleted() {

                System.out.println("translate completed");
            }
        };
    }
}
