package com.example.barterapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SignIn_class extends AppCompatActivity {

    public static final String url = "jdbc:mysql://192.168.0.101:3306/BARTER"; //ip of laptop and port of xampp
    public static final String user = "hema";
    public static final String pass = "1234";

    public static String username,email_detail,link;



String email_login,password_login;

    EditText email,password;
    Button signin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_page);

        email = findViewById(R.id.email_et_login);
        password = findViewById(R.id.pwd_et_login);
        signin = findViewById(R.id.signing_btn_login);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_login = email.getText().toString();
                password_login=password.getText().toString();

                ConnectorLogin login = new ConnectorLogin();
                login.execute("");

            }
        });


    }


    private class ConnectorLogin extends AsyncTask<String,Void,String>{
        String res = "";
        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                System.out.println("Databaseection success");

                String result = "Database Connection Successful\n";
                String output;
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM `USER_TABLE` WHERE `EMAIL` = '"+email_login+"' AND `PASSWORD` = '"+password_login+"';");



                ResultSetMetaData rsmd = rs.getMetaData();
                user user1 = new user();
                while (rs.next()) {                                         //-> to run with ddl
                            result += rs.getString(1).toString() + "\n"; // TO DETERMINE WHICH COLUMN INFO WE ARE GETTING!
                            user1.name_user = rs.getString(1).toString();
                            user1.email_user = rs.getString(2).toString();
                            user1.link_user = rs.getString(4).toString();

                          }



                username = user1.name_user;
                email_detail = user1.email_user;
                link = user1.link_user;
                res = username;



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


            if (s!=null){
                Toast.makeText(SignIn_class.this, "WELCOME BACK "+s, Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(SignIn_class.this, buy_or_sell_class.class);  //from and to ----------------------------!!!!!!!!
                startActivity(intent);  //to open login page

            }
            else {
                Toast.makeText(SignIn_class.this,"INVALID DETAILS QQ", Toast.LENGTH_SHORT).show();
            }
        }
    }






}

