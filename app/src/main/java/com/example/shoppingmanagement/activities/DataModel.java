package com.example.shoppingmanagement.activities;

import androidx.annotation.Nullable;

public class DataModel {
    private String productName;
    private String productQuantity;

    public DataModel(String productName, String productQuantity) {
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }
}
