package com.geektech.quizapp_gt_4_2.model;

import com.google.gson.annotations.SerializedName;

public class Type {
    @SerializedName("boolean")
    String booleanType;
    @SerializedName("multiple")
    String multipleTpye;

    public String getBooleanType() {
        return booleanType;
    }

    public void setBooleanType(String booleanType) {
        this.booleanType = booleanType;
    }

    public String getMultipleTpye() {
        return multipleTpye;
    }

    public void setMultipleTpye(String multipleTpye) {
        this.multipleTpye = multipleTpye;
    }
}
