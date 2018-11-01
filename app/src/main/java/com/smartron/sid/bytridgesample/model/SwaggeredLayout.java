package com.smartron.sid.bytridgesample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SwaggeredLayout {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("kids_url")
    @Expose
    private String kidsUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKidsUrl() {
        return kidsUrl;
    }

    public void setKidsUrl(String kidsUrl) {
        this.kidsUrl = kidsUrl;
    }

}