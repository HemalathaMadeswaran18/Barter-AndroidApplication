package com.example.barterapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class buy_homepage_class extends AppCompatActivity {
        ImageView imageView,imageView2,imageView3;
        TextView tv_title1,tv_title2,tv_title3,tv_desc1,tv_desc2,tv_desc3;
        Button b1,b2,b3;
        public static String n1,n2,n3,n4,n5,n6,n7,n8;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_homepage);

        imageView = findViewById(R.id.imageView_buy);
        tv_title1 = findViewById(R.id.textView55);
        tv_desc1 = findViewById(R.id.textView66);
        imageView2 = findViewById(R.id.imageView);
        tv_title2 = findViewById(R.id.textView49);
        tv_desc2 = findViewById(R.id.textView69);
        imageView3 = findViewById(R.id.imageView45);
        tv_title3 = findViewById(R.id.textView4);
        tv_desc3 = findViewById(R.id.textView6);
    b1=findViewById(R.id.button22);
        b2=findViewById(R.id.button28);
        b3=findViewById(R.id.button2);





      ConnectorLogin login = new ConnectorLogin();
        login.execute("");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectorLogin2 login2 = new ConnectorLogin2();
                login2.execute("");

                Uri uri = Uri.parse(n1); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectorLogin2 login2 = new ConnectorLogin2();
                login2.execute("");

                Uri uri = Uri.parse(n2); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectorLogin2 login2 = new ConnectorLogin2();
                login2.execute("");

                Uri uri = Uri.parse(n3); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    private class ConnectorLogin extends AsyncTask<String,Void,String> {
        String res = "";
        public static final String url = "jdbc:mysql://192.168.0.101:3306/BARTER"; //ip of laptop and port of xampp
        public static final String user = "hema";
        public static final String pass = "1234";


        public String image;
        public ArrayList<String> resultList = new ArrayList<String>();
        public  ArrayList<String> resultList4 = new ArrayList<String>();
        public  ArrayList<String> resultList5 = new ArrayList<String>();
        public  ArrayList<String> resultList2 = new ArrayList<String>();
        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                System.out.println("Databaseection success");

                String result = "Database Connection Successful\n";
                String result4 = "Database Connection Successful\n";
                String result5 = "Database Connection Successful\n";
                String result2 = "Database Connection Successful\n";

                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM `FOR_SALE` ;");
               // ResultSet rs = st.executeQuery("SELECT * FROM `FOR_SALE` WHERE `EMAIL` = '"+"EMAIL"+"' ;");

                ResultSetMetaData rsmd = rs.getMetaData();


                while (rs.next()) {                                         //-> to run with ddl
                 //   result += rs.getString(1).toString() + "\n"; // TO DETERMINE WHICH COLUMN INFO WE ARE GETTING!

                    image = rs.getString(3);
                    result = rs.getString(3);
                    resultList.add(result);
                    result4 = rs.getString(4);
                    resultList4.add(result4);
                    result5 = rs.getString(5);
                    resultList5.add(result5);
                    result2 = rs.getString(2);
                    resultList2.add(result2);


                }

                res = result;




            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return res;
        }


        @Override
        protected void onPostExecute(String s) {
            System.out.println(s);


            if (s != "") {
                Toast.makeText(buy_homepage_class.this, "WELCOME BACK " + s, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(buy_homepage_class.this, buy_or_sell_class.class);  //from and to ----------------------------!!!!!!!!
//                startActivity(intent);  //to open login page]

                n1 = resultList2.get(0); //link
                n2 = resultList2.get(1);
                n3 = resultList2.get(2);





                byte[] bytes = Base64.decode(resultList.get(0), Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length); //bitmap contains the image
                imageView.setImageBitmap(bitmap);

                tv_title1.setText(resultList4.get(0));
                tv_desc1.setText(resultList5.get(0));

                byte[] bytess = Base64.decode(resultList.get(1), Base64.DEFAULT);
                Bitmap bitmaps = BitmapFactory.decodeByteArray(bytess, 0, bytess.length); //bitmap contains the image
                imageView2.setImageBitmap(bitmaps);

                tv_title2.setText(resultList4.get(1));
                tv_desc2.setText(resultList5.get(1));

                byte[] bytesss = Base64.decode(resultList.get(2), Base64.DEFAULT);
                Bitmap bitmapss = BitmapFactory.decodeByteArray(bytesss, 0, bytesss.length); //bitmap contains the image
                imageView3.setImageBitmap(bitmapss);

                tv_title3.setText(resultList4.get(2));
                tv_desc3.setText(resultList5.get(2));

            } else {
                Toast.makeText(buy_homepage_class.this, "INVALID DETAILS QQ", Toast.LENGTH_SHORT).show();
            }
        }

    }



    private class ConnectorLogin2 extends AsyncTask<String,Void,String> {
        String res = "";
        public static final String url = "jdbc:mysql://192.168.0.101:3306/BARTER"; //ip of laptop and port of xampp
        public static final String user = "hema";
        public static final String pass = "1234";


        public String image;
        public ArrayList<String> resultList = new ArrayList<String>();

        public  ArrayList<String> resultList2 = new ArrayList<String>();
        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                System.out.println("Databaseection success");

                String result = "Database Connection Successful\n";

                String result2 = "Database Connection Successful\n";

                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM `FOR_SALE` ;");
                // ResultSet rs = st.executeQuery("SELECT * FROM `FOR_SALE` WHERE `EMAIL` = '"+"EMAIL"+"' ;");

                ResultSetMetaData rsmd = rs.getMetaData();


                while (rs.next()) {                                         //-> to run with ddl
                    //   result += rs.getString(1).toString() + "\n"; // TO DETERMINE WHICH COLUMN INFO WE ARE GETTING!

                    image = rs.getString(3);
                    result = rs.getString(3);
                    resultList.add(result);

                    result2 = rs.getString(2);
                    resultList2.add(result2);


                }

                res = result;




            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return res;
        }


        @Override
        protected void onPostExecute(String s) {
            System.out.println(s);


            if (s != "") {
                Toast.makeText(buy_homepage_class.this, "WELCOME BACK " + s, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(buy_homepage_class.this, buy_or_sell_class.class);  //from and to ----------------------------!!!!!!!!
//                startActivity(intent);  //to open login page]

                n1 = resultList2.get(0); //link
                n2 = resultList2.get(1);
                n3 = resultList2.get(2);

//                ClipboardManager clipboardManager = null;
//                ClipData clipData;
//
//                String txtcopy = n1;
//                clipData = ClipData.newPlainText("text",txtcopy);
//                clipboardManager.setPrimaryClip(clipData);
//
//                Toast.makeText(getApplicationContext(), "Text Copied",
//                        Toast.LENGTH_SHORT).show();
//                System.out.println("text copied");



            } else {
                Toast.makeText(buy_homepage_class.this, "INVALID DETAILS QQ", Toast.LENGTH_SHORT).show();
            }
        }

    }









}
