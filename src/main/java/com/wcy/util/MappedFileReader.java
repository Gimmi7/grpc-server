package com.wcy.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFileReader {

    private FileInputStream fileIn;
    private MappedByteBuffer mappedBuf;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public MappedFileReader(String fileName, int arraySize) throws IOException {
        this.fileIn=new FileInputStream(fileName);
        FileChannel fileChannel=fileIn.getChannel();
        this.fileLength=fileChannel.size();
        this.mappedBuf=fileChannel.map(FileChannel.MapMode.READ_ONLY,0,fileLength);
        this.arraySize=arraySize;
    }

    public int read(){
        int limit=mappedBuf.limit();
        int position=mappedBuf.position();
        if (position==limit){
            return -1;
        }
        if (limit-position>arraySize){
            array=new byte[arraySize];
            mappedBuf.get(array);
            return arraySize;
        }else {
            array=new byte[limit-position];
            mappedBuf.get(array);
            return limit-position;
        }
    }

    public void close() throws IOException {
        fileIn.close();
        array=null;
    }

    public byte[] getArray(){
        return array;
    }

    public long getFileLength(){
        return fileLength;
    }
}
