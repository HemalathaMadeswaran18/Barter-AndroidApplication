package com.example.barterapp;

import static com.example.barterapp.ConnectorLogin.n1;
import static com.example.barterapp.ConnectorLogin.n10;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class buy_recycler_homepage extends AppCompatActivity {



    public void openWebpage(){
        Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

        Button b1;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_recycler_homepage);

        b1  = findViewById(R.id.button3);

        ConnectorLogin login = new ConnectorLogin();
        login.execute("");
        System.out.println("onnector login");
        System.out.println(ConnectorLogin.n7);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ExampleItem> exampleItems = new ArrayList<>();
                exampleItems.add(new ExampleItem(ConnectorLogin.n4,ConnectorLogin.n7,n10,n1));
                exampleItems.add(new ExampleItem(ConnectorLogin.n5,ConnectorLogin.n8,ConnectorLogin.n11,ConnectorLogin.n2));
                exampleItems.add(new ExampleItem(ConnectorLogin.n6,ConnectorLogin.n9,ConnectorLogin.n12,ConnectorLogin.n3));
                exampleItems.add(new ExampleItem(ConnectorLogin.n14,ConnectorLogin.n15,ConnectorLogin.n16,ConnectorLogin.n13));
                exampleItems.add(new ExampleItem(ConnectorLogin.n18,ConnectorLogin.n19,ConnectorLogin.n20,ConnectorLogin.n17));
                System.out.println(ConnectorLogin.n8+"N5 ");
                System.out.println("running recycler");
                mRecyclerView = findViewById(R.id.RecyclerView);
                mRecyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(buy_recycler_homepage.this);
                mAdapter = new ExampleAdapter(exampleItems); //to assign constructor to this list given above
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }
        });







    }

}
