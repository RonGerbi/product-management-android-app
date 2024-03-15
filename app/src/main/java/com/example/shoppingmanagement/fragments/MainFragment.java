package com.example.shoppingmanagement.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shoppingmanagement.R;
import com.example.shoppingmanagement.activities.CustomAdapter;
import com.example.shoppingmanagement.activities.DataModel;
import com.example.shoppingmanagement.activities.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView productRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CustomAdapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        productRecyclerView = view.findViewById(R.id.productView);
        linearLayoutManager = new LinearLayoutManager(getContext());
        productRecyclerView.setLayoutManager(linearLayoutManager);
        productRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new CustomAdapter(MainActivity.getProductDB());
        productRecyclerView.setAdapter(adapter);

        TextView usernameText = view.findViewById(R.id.usernameText);
        String username = getArguments().getString("name");

        usernameText.setText("Hello " + username);

        Button addProductBtn = view.findViewById(R.id.addProductButton);
        Button removeProductBtn = view.findViewById(R.id.removeProductButton);

        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText productName = view.findViewById(R.id.productNameInput);
                EditText quantity = view.findViewById(R.id.productQuantityInput);

                MainActivity.insertProductToDB(productName.getText().toString(), Integer.parseInt(quantity.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });

        removeProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText productName = view.findViewById(R.id.productNameInput);

                MainActivity.removeProductFromDB(productName.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}