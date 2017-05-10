package com.example.mypc.manhquyen.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    private ImageAdapter imageAdapter;
    //private ImageAdapter2 imageAdapter2;
    private GridView gridview;
    private int TAKE_PHOTO_CODE = 0;
    public static int count;
    final String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/New Folder/camera";
    final String cameraFolder = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //FacebookSdk.sdkInitialize(getApplicationContext());
            gridview = (GridView) findViewById(R.id.gridview);
            imageAdapter = new ImageAdapter(this);
            //imageAdapter2 = new ImageAdapter2(this);
            gridview.setAdapter(imageAdapter);
            registerForContextMenu(gridview);
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, PictureView.class);
                    intent.putExtra("values", imageAdapter.getItem(position));
                    intent.putExtra("cameraFolder",cameraFolder);
                    //Bundle bundle = new Bundle();
                    //bundle.putInt("vi tri ",position); // CanhDai là tên giao dịch

                    // Đưa thùng chứa Bundle cho người đưa thư Intent, trong đó GoiTin là
                    // tên của thùng chứa
                    //intent.putExtra("GoiTin", bundle);
                    Log.d("manhquyen",position+"");
                   intent.putExtra("locations",position);
                    //intent.putExtra("positions",position);
                    startActivity(intent);
                }
            });
            String ExternalStorageDirectoryPath = Environment
                    .getExternalStorageDirectory()
                    .getAbsolutePath();

            String targetPath = ExternalStorageDirectoryPath + "/New Folder/";
            //String targetPath = ExternalStorageDirectoryPath+ "/Picture/picFolder/";

            //Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
            File targetDirector = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/");

            File[] files = targetDirector.listFiles();
            for (File file : files) {
                imageAdapter.add(file.getAbsolutePath());
            }
            MediaScannerConnection.scanFile(this,
                    new String[] { cameraFolder }, null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        public void onScanCompleted(String path, Uri uri) {

                        }
                    });

        }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.aboutMain:
//                Intent gallery = new Intent(getApplicationContext(), GalleryView.class);
//                startActivity(gallery);
                //new AboutUltil(this).showAboutApp();
                break;
            case R.id.album_list:
                //Intent newintent = new Intent(getApplicationContext(),Album.class);
                //startActivity(newintent);
                //Toast.makeText(getApplicationContext(),"clgt",Toast.LENGTH_LONG).show();
                break;
            case R.id.camera:
               // openCamera();
                //printKeyHash();
                break;
            case R.id.slide:
                Intent intent = new Intent(MainActivity.this, SlideShow.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}
