package com.example.barterapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class upload_details extends AppCompatActivity {

    public static String encodedImage;
    private static int RESULT_LOAD_IMAGE = 1;
    Button uploadImage, finalUpload;
    EditText title, details;
    ImageView imageView;

    public static String Title, Desc;

    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_details);

        uploadImage = findViewById(R.id.button4);

        title = findViewById(R.id.title_et);
        details = findViewById(R.id.desc_et);
        imageView = findViewById(R.id.imageView2);

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Title = title.getText().toString();
                Desc = details.getText().toString();
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);


            Bitmap originBitmap = null;
            Uri selectedImage = data.getData();
            InputStream imagestream;
            try {
                imagestream = getContentResolver().openInputStream(selectedImage);
                originBitmap = BitmapFactory.decodeStream(imagestream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (originBitmap != null) {
                this.imageView.setImageBitmap(originBitmap);
                Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);


                //add async code
                Fetch doLogin = new Fetch();
                doLogin.execute("");
                Toast.makeText(upload_details.this, "ITEM UPLOADED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(upload_details.this, buy_or_sell_class.class);  //from and to ----------------------------!!!!!!!!
                startActivity(intent);


            }
        }
    }


}

