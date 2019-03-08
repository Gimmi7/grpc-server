package com.wcy.domain;

public class CompanyDTO {
    private String name;
    private String storedIn;

    public CompanyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoredIn() {
        return storedIn;
    }

    public void setStoredIn(String storedIn) {
        this.storedIn = storedIn;
    }
}
