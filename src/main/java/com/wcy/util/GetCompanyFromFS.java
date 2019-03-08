package com.wcy.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcy.domain.CompanyDTO;
import com.wcy.scenario.Company;

import java.io.IOException;
import java.io.InputStream;

public class GetCompanyFromFS {

    public Company get(String companyName) throws IOException {
        InputStream input=this.getClass().getResourceAsStream("/company/"+companyName+".json");
        ObjectMapper mapper=new ObjectMapper();
        CompanyDTO companyDTO=mapper.readValue(input, CompanyDTO.class);
        Company company=Company.newBuilder().setName(companyDTO.getName()).setStoredIn(companyDTO.getStoredIn()).build();

        return company;
    }
}
