package com.example.barterapp;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp_class extends AppCompatActivity {

    public static final String url = "jdbc:mysql://192.168.0.101:3306/BARTER"; //ip of laptop and port of xampp
    public static final String user = "hema";
    public static final String pass = "1234";
    public String name_db,email_db,password_db,link_db;
    EditText email,password,confirm_password,name,link;
    Button signup; //assign from the xml page



   
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        name = findViewById(R.id.name_edittext);
        email = findViewById(R.id.email_edittext);
        password = findViewById(R.id.password_edittext);

        link = findViewById(R.id.link_et);
        signup = findViewById(R.id.signup_button1);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newuser s1 = new newuser();
                s1.setEmail(email.getText().toString());
                s1.setName(name.getText().toString());
                s1.setLink(link.getText().toString());
                s1.setPassword(password.getText().toString());

                name_db = s1.getName();
                email_db = s1.getEmail();
                password_db = s1.getPassword();
                link_db = s1.getLink();

                ConnectMySQL connectMySql = new ConnectMySQL();  //creating object for a class declared below
                connectMySql.execute("");

            }
        });
    }

    private class ConnectMySQL extends AsyncTask<String,Void,String> {
        String res = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                System.out.println("Databaseection success");


                String result = "Database Connection Successful\n";
                Statement st = con.createStatement();


                int rs = st.executeUpdate("INSERT INTO `USER_TABLE` (`NAME`, `EMAIL`, `PASSWORD`, `LINK`) " +
                        "VALUES ('"+name_db+ "', '"+email_db+"', '"+password_db+"', '"+link_db+"');");




                res = result;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return res;
        }
    }
















}

  class newuser{
    String name,email,password,link;

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public String getEmail() {
          return email;
      }

      public void setEmail(String email) {
          this.email = email;
      }

      public String getPassword() {
          return password;
      }

      public void setPassword(String password) {
          this.password = password;
      }

      public String getLink() {
          return link;
      }

      public void setLink(String link) {
          this.link = link;
      }
  }


