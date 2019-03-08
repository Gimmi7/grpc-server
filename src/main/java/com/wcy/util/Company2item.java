package com.wcy.util;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.wcy.scenario.Company;

public class Company2item {
    public static Item company2item(Company company){
        Item item=new Item()
                .withPrimaryKey("name", company.getName())
                .withString("storedIn", company.getStoredIn());
        return item;
    }
}
