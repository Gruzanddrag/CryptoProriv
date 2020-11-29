package ru.bruh.rosseti.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StatementModel implements Serializable {

    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("author")
    public Author author;
    @SerializedName("projectDescription")
    public String projectDescription;
    @SerializedName("category")
    public Category category;
    @SerializedName("economicEffect")
    public String economicEffect;
    @SerializedName("status")
    public Status status;
    @SerializedName("createdAt")
    public Long createdAt;
    @SerializedName("updatedAt")
    public Long updatedAt;
    @SerializedName("generatingSaving")
    public Boolean generatingSaving;
    @SerializedName("newness")
    public String newness;
    @SerializedName("upvotes")
    public Integer upvotes;
    @SerializedName("advantagesDescription")
    public String advantagesDescription;

    public class Category {

        @SerializedName("id")
        public Integer id;
        @SerializedName("name")
        public String name;

    }

    public class Status {

        @SerializedName("status")
        public Integer status;
        @SerializedName("statusName")
        public String statusName;

    }

    public class Author {

        @SerializedName("id")
        public Integer id;
        @SerializedName("surname")
        public String surname;
        @SerializedName("name")
        public String name;
        @SerializedName("fIO")
        public String fIO;

    }

}
