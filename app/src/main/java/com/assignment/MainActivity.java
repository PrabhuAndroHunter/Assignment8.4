package com.assignment;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.assignment.adapter.MyGridViewAdapter;
import com.assignment.data.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();

    GridView mGridView;
    ArrayList <Item> gridArray = new ArrayList <Item>();
    MyGridViewAdapter customGridAdapter;

    public static String[] nameArray = {"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", " Ice Cream Sandwich",
            "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat"};

    public static Integer[] drawableArray = {R.drawable.cupcakean, R.drawable.donut, R.drawable.eclair, R.drawable.froyo,
            R.drawable.gingerbread, R.drawable.honeycomb, R.drawable.icecreamsandwich, R.drawable.jellybean,
            R.drawable.kitkat, R.drawable.lollipop, R.drawable.marshmallow, R.drawable.nougat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        mGridView = findViewById(R.id.gridView);  // init GridView
        loadData(); // load logos
        customGridAdapter = new MyGridViewAdapter(this, R.layout.item_grid, gridArray);
        mGridView.setAdapter(customGridAdapter); // Set adapter
        // Set OnItemClick listener on GridView
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), "Hi Bro am "+ nameArray[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    // This method load all logos from drawable
    private void loadData() {
        for (int i = 0; i < drawableArray.length; i++) {
            Bitmap image = BitmapFactory.decodeResource(this.getResources(), drawableArray[i]);
            gridArray.add(new Item(image, nameArray[i]));
        }
        return;
    }
}
