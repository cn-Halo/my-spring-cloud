package com.thoughtmechanix.licenses.model;

import lombok.Data;

@Data
public class License {


    private String id;
    private String organizationId;
    private String productName;
    private String licenseType;


    public License(String id, String organizationId, String productName, String licenseType) {
        this.id = id;
        this.organizationId = organizationId;
        this.productName = organizationId;
        this.licenseType = licenseType;


    }

}
