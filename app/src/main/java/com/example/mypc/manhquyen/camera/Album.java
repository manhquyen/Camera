package com.example.mypc.manhquyen.camera;

/**
 * Created by MyPC on 09/05/2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Album extends AppCompatActivity {
    private GridView mGridView;
    private ImageAdapter mImageAdapter;
    private String folderPath;
    private String location;

    private int TAKE_PHOTO_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album);
        Bundle mBundle = getIntent().getExtras();
        location = mBundle.getString("values");

        mGridView = (GridView) findViewById(R.id.gridview_album);
        mImageAdapter = new ImageAdapter(this);

        mImageAdapter.add(location);
        mImageAdapter.notifyDataSetChanged();
        //Toast.makeText(getApplicationContext(),location,Toast.LENGTH_LONG).show();
        mGridView.setAdapter(mImageAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO
            }
        });
        registerForContextMenu(mGridView);


    }



}
