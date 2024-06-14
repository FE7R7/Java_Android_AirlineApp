package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class TravelImageList extends AppCompatActivity {

    private Button b_travelImgListToMain;
    private ArrayList<String> names;
    private ArrayList<Integer> images;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_image_list);

        list= findViewById(R.id.id_list);
        b_travelImgListToMain= findViewById(R.id.b_ImgListToMain);

        b_travelImgListToMain.setOnClickListener(view -> {

            Intent i = new Intent(TravelImageList.this, MainActivity_WelCome.class);

            startActivity(i);

        });


        names = new ArrayList<>();
        names.add("ENJOY");
        names.add("TRAVEL");
        names.add("ENJOY");
        names.add("LIFE");


        images = new ArrayList<>();
        images.add(R.drawable.image1);
        images.add(R.drawable.image2);
        images.add(R.drawable.image3);
        images.add(R.drawable.image5);


        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.size();  //added this
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.travel_image_list, viewGroup, false);
            ImageView myImageView = view.findViewById(R.id.imageView_img_listView);
            TextView myTextView = view.findViewById(R.id.textView_img_listView);

            myImageView.setImageResource(images.get(i));
            myTextView.setText(names.get(i));

            return view;
        }

    }

}