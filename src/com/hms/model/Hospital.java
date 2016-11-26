/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.model;

/**
 *
 * @author iamsu
 */
public class Hospital extends DomainObject{
    private int Id;
    private String hospitalName;
    private String zipcode;

    public Hospital(int Id, String hospitalName, String zipcode) {
        this.Id = Id;
        this.hospitalName = hospitalName;
        this.zipcode = zipcode;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
}
