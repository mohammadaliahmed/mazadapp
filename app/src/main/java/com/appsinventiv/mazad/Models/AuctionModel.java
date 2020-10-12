package com.appsinventiv.mazad.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuctionModel implements Serializable {

    @SerializedName("images")
    @Expose
    String images;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("date")
    @Expose
    String date;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("endDate")
    @Expose
    String endDate;
    @SerializedName("url")
    @Expose
    String url;

    public AuctionModel(String images, String name, String date, String status, String endDate, String url) {
        this.images = images;
        this.name = name;
        this.date = date;
        this.status = status;
        this.endDate = endDate;
        this.url = url;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
