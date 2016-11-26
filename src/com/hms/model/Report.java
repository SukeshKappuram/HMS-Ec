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
public class Report extends DomainObject{
    private int Id;
    private int appintmentId;
    private String description;
    private String fileName;

    public Report() {
    }

    public Report(int Id, int appintmentId, String description, String fileName) {
        this.Id = Id;
        this.appintmentId = appintmentId;
        this.description = description;
        this.fileName = fileName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getAppintmentId() {
        return appintmentId;
    }

    public void setAppintmentId(int appintmentId) {
        this.appintmentId = appintmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
}
