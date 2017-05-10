package com.example.mypc.manhquyen.camera;

/**
 * Created by MyPC on 05/05/2017.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class PictureView extends AppCompatActivity {
    private ImageView imageView;
    private static final int UI_ANIMATION_DELAY = 300;
    private View mContentView;
    private View mControlsView;
    private boolean mVisible;
    //private PhotoViewAttacher mAttacher;// zoom anh
    private PictureControl mPictureControl;
    private SwipeDetector mSwipeDetector;
    //private View.OnClickListener listenner;
    private GestureDetector gestureDetector;
    private boolean isZoom = false;
    private ArrayList<String> mArrayList;
    private int location;
   // private LoginManager manager;
   // private CallbackManager callbackManager; //facebook
    public String filePath;
    private Activity mContext;
    //private ShareDialog shareDialog;
    private TextView mInfoPic;
    private String mStrInfo;
    //private AboutUltil mAboutUltil;
    private int[] i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_view);
       // gestureDetector = new GestureDetector(this);
        imageView = (ImageView) findViewById(R.id.image_view);
        Bundle bundle = getIntent().getExtras();
        final String s = (String) bundle.get("values");
        final String cameraFolder = (String) bundle.get("cameraFolder");
        location = bundle.getInt("locations");
        i = new int[]{location};
        mArrayList = new ArrayList<>();
        String demo = Environment.getExternalStorageDirectory().getAbsolutePath() + "/New Folder/";
        File file = new File(cameraFolder);
        for (File tmp : file.listFiles()) {
            mArrayList.add(tmp.getAbsolutePath());
        }

        //Log.d("namhpb2", mArrayList.get(location+1)+"");
        Bitmap bitmap = BitmapFactory.decodeFile(mArrayList.get(location));
        imageView.setImageBitmap(bitmap);
        mInfoPic = (TextView) findViewById(R.id.infoPic);

        //mAttacher= new PhotoViewAttacher(imageView);
        //registerForContextMenu(imageView);
        //mPictureControl = new PictureControl(getApplicationContext());



    }

    private void getInformations(int i) {
        File file = new File(mArrayList.get(i));
        String name = file.getName();
        long leng = file.length();
        String path = file.getAbsolutePath();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin chi tiết:");
        builder.setMessage("Tên: " + name + "\n" + "Kích thước: " + leng + " byte" + "\n" + "Vị trí: " + path);
        builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
        //Toast.makeText(getApplicationContext(), "Tên: " + name + "\n" + "Kích thước: " + leng + " byte" + "\n" + "Vị trí: " + path, Toast.LENGTH_LONG).show();
    }

    private String getInfo(String s) {
        File file = new File(s);
        String name = file.getName();
        long leng = file.length()/1204;
        String path = file.getAbsolutePath();
        mStrInfo += "Tên: " + name + "\n" + "Kích thước: " + leng + " kb" + "\n" + "Vị trí: " + path;
        return mStrInfo;
    }





    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_full, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.shareInView:

                break;
            case R.id.infoinView:
                getInformations(i[0]);
                break;
            case R.id.about:

                break;
            case R.id.set_home:

                break;

        }
        return super.onOptionsItemSelected(item);
    }





}

