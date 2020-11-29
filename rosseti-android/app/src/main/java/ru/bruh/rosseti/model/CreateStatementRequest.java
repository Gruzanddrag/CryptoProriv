package ru.bruh.rosseti.model;

import com.google.gson.annotations.SerializedName;

public class CreateStatementRequest {

    @SerializedName("name")
    public String name;
    @SerializedName("projectDescription")
    public String projectDescription;
    @SerializedName("economicEffect")
    public String economicEffect;
    @SerializedName("status")
    public Integer status = 0;
    @SerializedName("createdAt")
    public Integer createdAt = 0;
    @SerializedName("updatedAt")
    public Integer updatedAt = 0;
    @SerializedName("generatingSaving")
    public Boolean generatingSaving;
    @SerializedName("newness")
    public String newness;
    @SerializedName("upvotes")
    public Integer upvotes = 0;
    @SerializedName("limitationsDescription")
    public String limitationsDescription;
    @SerializedName("disadvantageDescription")
    public String disadvantageDescription = "";
    @SerializedName("advantagesDescription")
    public String advantagesDescription;

}