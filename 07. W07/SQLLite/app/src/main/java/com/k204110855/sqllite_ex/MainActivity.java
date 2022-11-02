package com.k204110855.sqllite_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.k204110855.sqllite_ex.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Create database
        copyBD();
    }

    private void copyBD() {
        File dbFile = getDatabasePath(Utils.DB_NAME);
        if (!dbFile.exists()) {
           if(copyDBFromAssets()){
               Toast.makeText(this, "Copy database success", Toast.LENGTH_SHORT).show();
           }
           else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
           }
        }
    }

    private boolean copyDBFromAssets() {
        String dbFilePath = getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX + Utils.DB_NAME;
        try{
            InputStream inputStream = getAssets().open(Utils.DB_NAME);
            File f = new File(getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbFilePath);
            byte[] buffer = new byte[1024]; int length;
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}