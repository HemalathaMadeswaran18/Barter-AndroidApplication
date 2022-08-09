package com.example.barterapp;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import static java.net.Proxy.Type.HTTP;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> ExampleList;

    buy_recycler_homepage a;


    public ExampleAdapter(ArrayList<ExampleItem> mExampleList) {
        this.ExampleList = mExampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = ExampleList.get(position);
        System.out.println(currentItem.getmImageResource());
        System.out.println(currentItem.getmTitle());
        byte[] bytes = Base64.decode(currentItem.getmImageResource(), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length); //bitmap contains the image
        holder.imageView.setImageBitmap(bitmap);
        holder.textView1.setText(currentItem.getmTitle());
        holder.textView2.setText(currentItem.getmDesc());
        holder.textView3.setText(currentItem.getmLink());

    }

    @Override
    public int getItemCount() {
        return ExampleList.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView1, textView2, textView3;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView3);
            textView1 = itemView.findViewById(R.id.textView8);
            textView2 = itemView.findViewById(R.id.textView9);
            textView3 = itemView.findViewById(R.id.textView10);


        }
    }
}