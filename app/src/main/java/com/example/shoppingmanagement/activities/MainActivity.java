package com.example.shoppingmanagement.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shoppingmanagement.R;
import com.example.shoppingmanagement.fragments.LoginFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static HashMap<String, String> database = new HashMap<String, String>();
    private static HashMap<String, DataModel> productDB = new HashMap<String, DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static HashMap<String, DataModel> getProductDB()
    {
        return productDB;
    }


    public static boolean isProductInDB(String productName)
    {
        return productDB.containsKey(productName);
    }

    public static void removeProductFromDB(String productName)
    {
        if (isProductInDB(productName)) {
            productDB.remove(productName);
        }
    }

    public static void insertProductToDB(String productName, Integer quantity)
    {
        DataModel product = new DataModel(productName, quantity.toString());

        if (isProductInDB(productName))
        {
            Integer newQuantity = Integer.parseInt(productDB.get(productName).getProductQuantity()) + quantity;

            product.setProductQuantity(newQuantity.toString());
            productDB.put(productName, product);
        }
        else {
            productDB.put(productName, product);
        }
    }

    public static void insertToDB(String username, String password)
    {
        database.put(username, password);
    }

    public static boolean isUserNameExists(String username)
    {
        return database.containsKey(username);
    }

    public static boolean verifyUsernameAndPassword(String username, String password)
    {
        boolean isVerified = false;

        if (isUserNameExists(username))
        {
            if (database.get(username) == password)
            {
                isVerified = true;
            }
        }

        return isVerified;
    }
}