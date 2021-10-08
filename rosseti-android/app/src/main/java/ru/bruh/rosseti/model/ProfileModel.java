package ru.bruh.rosseti.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileModel {

    @SerializedName("roles")
    public List<String> roles = null;
    @SerializedName("statements")
    public List<Statement> statements = null;
    @SerializedName("surname")
    public String surname;
    @SerializedName("name")
    public String name;
    @SerializedName("userProfile")
    public UserProfile userProfile;

    public class UserProfile {

        @SerializedName("rating")
        public Integer rating;
        @SerializedName("position")
        public String position;
        @SerializedName("department")
        public String department;
        @SerializedName("phone")
        public String phone;
        @SerializedName("userEducation")
        public List<UserEducation> userEducation = null;
        @SerializedName("experience")
        public Integer experience;

    }

    public class Statement {

        @SerializedName("id")
        public Integer id;
        @SerializedName("name")
        public String name;
        @SerializedName("projectDescription")
        public String projectDescription;
        @SerializedName("category")
        public String category;
        @SerializedName("economicEffect")
        public String economicEffect;
        @SerializedName("status")
        public Status status;
        @SerializedName("createdAt")
        public Integer createdAt;
        @SerializedName("updatedAt")
        public Integer updatedAt;
        @SerializedName("generatingSaving")
        public Boolean generatingSaving;
        @SerializedName("newness")
        public String newness;
        @SerializedName("upvotes")
        public Integer upvotes;
        @SerializedName("advantagesDescription")
        public String advantagesDescription;

    }

    public class Status {

        @SerializedName("status")
        public Integer status;
        @SerializedName("statusName")
        public String statusName;

    }

    public class UserEducation {

        @SerializedName("university")
        public String university;
        @SerializedName("major")
        public String major;
        @SerializedName("graduationYear")
        public String graduationYear;

    }

}






