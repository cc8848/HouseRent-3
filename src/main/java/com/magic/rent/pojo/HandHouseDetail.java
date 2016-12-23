package com.magic.rent.pojo;

import java.io.Serializable;

public class HandHouseDetail extends HandHousePrice implements Serializable {

    private static final long serialVersionUID = 1207987731565226615L;

    private String title;

    private String houseDetails;

    private String ownerMentality;

    private String supportingFacility;

    private String professionalService;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHouseDetails() {
        return houseDetails;
    }

    public void setHouseDetails(String houseDetails) {
        this.houseDetails = houseDetails == null ? null : houseDetails.trim();
    }

    public String getOwnerMentality() {
        return ownerMentality;
    }

    public void setOwnerMentality(String ownerMentality) {
        this.ownerMentality = ownerMentality == null ? null : ownerMentality.trim();
    }

    public String getSupportingFacility() {
        return supportingFacility;
    }

    public void setSupportingFacility(String supportingFacility) {
        this.supportingFacility = supportingFacility == null ? null : supportingFacility.trim();
    }

    public String getProfessionalService() {
        return professionalService;
    }

    public void setProfessionalService(String professionalService) {
        this.professionalService = professionalService == null ? null : professionalService.trim();
    }

    @Override
    public String toString() {
        return "HandHouseDetail{" +
                "title='" + title + '\'' +
                ", houseDetails='" + houseDetails + '\'' +
                ", ownerMentality='" + ownerMentality + '\'' +
                ", supportingFacility='" + supportingFacility + '\'' +
                ", professionalService='" + professionalService + '\'' +
                '}';
    }
}