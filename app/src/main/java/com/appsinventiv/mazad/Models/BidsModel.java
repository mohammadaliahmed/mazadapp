package com.appsinventiv.mazad.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BidsModel {
    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("amount")
    @Expose
    Integer amount;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("image")
    @Expose
    String image;

    public BidsModel(Integer id, Integer amount, String name, String image) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
