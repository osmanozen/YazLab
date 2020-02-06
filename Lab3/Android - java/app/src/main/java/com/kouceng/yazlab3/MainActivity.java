package com.kouceng.yazlab3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView ivImage;
    Button uploadImage;
    EditText compressValue;
    private static final int requestCamera=1, selectFile=0;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private ProgressDialog mProgress;
    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        ivImage = (ImageView)findViewById(R.id.ivImage);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        compressValue =(EditText)findViewById(R.id.compressValue);
        //String userId = mAuth.getCurrentUser().getUid(); 


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        mProgress = new ProgressDialog(this);
    }

    public void selectImage(){

        final CharSequence[] items = {"Kamera", "Galeri", "İptal"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Resim Ekle");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Kamera")){

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, requestCamera);
                }else if(items[i].equals("Galeri")){

                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent,"Resim Seç"), selectFile);
                }else if(items[i].equals("İptal")){

                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == Activity.RESULT_OK){

            if(requestCode==requestCamera){

                mProgress.setMessage("Resim yükleniyor...");
                mProgress.show();

                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, os); //Sıkıstırma yok!
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), bmp, "title", null);
                Uri uri = Uri.parse(path);

                ivImage.setImageURI(uri);
                StorageReference filepath = mStorageRef.child("User").child(uri.getLastPathSegment());

                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        mProgress.dismiss();
                        Toast.makeText(MainActivity.this,"Resim yüklendi.", Toast.LENGTH_LONG).show();
                    }
                });
            }else if(requestCode==selectFile){

                mProgress.setMessage("Resim yükleniyor...");
                mProgress.show();

                Uri selectedImageUri = data.getData();
                ivImage.setImageURI(selectedImageUri);
                StorageReference filepath = mStorageRef.child("User").child(selectedImageUri.getLastPathSegment());

                filepath.putFile(selectedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        mProgress.dismiss();
                        Toast.makeText(MainActivity.this,"Resim yüklendi.", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
