package com.wcy.dao;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.wcy.scenario.CompanyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service
public class DynamodbDao {
    @Autowired
    DynamoDB dynamoDB;

    public Object batchWriteItem(Set<Item> items){
        TableWriteItems tableWriteItems=new TableWriteItems("Company").withItemsToPut(items);
        BatchWriteItemOutcome outcome=dynamoDB.batchWriteItem(tableWriteItems);
        return outcome.getBatchWriteItemResult().getConsumedCapacity();
    }

    public Iterator<Item> queryItem(CompanyName companyName){
        Table table=dynamoDB.getTable("Company");
        QuerySpec spec=new QuerySpec().withHashKey("name",companyName.getCompanyName());
        ItemCollection<QueryOutcome> outcomeItemCollection=table.query(spec);
        return outcomeItemCollection.iterator();
    }
}
