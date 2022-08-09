package com.example.barterapp;

import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectorLogin extends AsyncTask<String,Void,String> {
    String res = "";
    public static String n1,n2,n3,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20;
    public static String n4,n5,n6;
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
            System.out.println("buy success");

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
            n1 = resultList2.get(0); //link
            n2 = resultList2.get(1);
             n3 = resultList2.get(2);

            System.out.println( "n4 = resultList.get(0)");
            System.out.println( n4 = resultList.get(0));
            n4 = resultList.get(0);//image
            n5 = resultList.get(1);
            n6 = resultList.get(2);

            System.out.println("N5 IS"+n5);

            n7 = resultList4.get(0);//title
             n8 = resultList4.get(1);
              n9 = resultList4.get(2);

            n10 = resultList5.get(0);//desc
              n11 = resultList5.get(1);
               n12= resultList5.get(2);


               n13= resultList2.get(3);
               n14=resultList.get(3);
               n15=resultList4.get(3);
               n16 = resultList5.get(3);

            n17= resultList2.get(4);
            n18=resultList.get(4);
            n19=resultList4.get(4);
            n20 = resultList5.get(4);



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



           // Toast.makeText(buy_recycler_homepage.this, "WELCOME BACK " + s, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(buy_homepage_class.this, buy_or_sell_class.class);  //from and to ----------------------------!!!!!!!!
//                startActivity(intent);  //to open login page]




//                byte[] bytes = Base64.decode(resultList.get(0), Base64.DEFAULT);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length); //bitmap contains the image
//                imageView.setImageBitmap(bitmap);
//
//                tv_title1.setText(resultList4.get(0));
//                tv_desc1.setText(resultList5.get(0));
//
//                byte[] bytess = Base64.decode(resultList.get(1), Base64.DEFAULT);
//                Bitmap bitmaps = BitmapFactory.decodeByteArray(bytess, 0, bytess.length); //bitmap contains the image
//                imageView2.setImageBitmap(bitmaps);
//
//                tv_title2.setText(resultList4.get(1));
//                tv_desc2.setText(resultList5.get(1));
//
//                byte[] bytesss = Base64.decode(resultList.get(2), Base64.DEFAULT);
//                Bitmap bitmapss = BitmapFactory.decodeByteArray(bytesss, 0, bytesss.length); //bitmap contains the image
//                imageView3.setImageBitmap(bitmapss);
//
//                tv_title3.setText(resultList4.get(2));
//                tv_desc3.setText(resultList5.get(2));


           // Toast.makeText(buy_recycler_homepage.this, "INVALID DETAILS QQ", Toast.LENGTH_SHORT).show();

    }

}