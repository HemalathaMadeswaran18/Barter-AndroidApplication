package com.example.barterapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch extends AsyncTask<String, Void, String> {
    String res = "";
    public static final String url = "jdbc:mysql://192.168.0.101:3306/BARTER"; //ip of laptop and port of xampp
    public static final String user = "hema";
    public static final String pass = "1234";

    @Override
    protected String doInBackground(String... strings) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Databaseection success");


            String result = "Database Connection Successful\n";
            Statement st = con.createStatement();


            int rs = st.executeUpdate("INSERT INTO `FOR_SALE` (`EMAIL`, `LINK`, `IMAGE` ,`TITLE`, `DESCRIPTION`) " +
                    "VALUES ('" + SignIn_class.email_detail + "', '" + SignIn_class.link + "', '" + upload_details.encodedImage + "', '"+upload_details.Title+"', '"+upload_details.Desc+"');");


            res = result;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return res;
    }


}
