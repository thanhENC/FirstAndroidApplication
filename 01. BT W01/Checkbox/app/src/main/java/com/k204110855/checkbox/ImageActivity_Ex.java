package com.k204110855.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageActivity_Ex extends AppCompatActivity {
    ImageView imvPhoto;
    ImageButton btnChange, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_ex);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imvPhoto.getTag() == null || imvPhoto.getTag() == "bonk") {
                    imvPhoto.setImageResource(R.drawable.glass_cheems);
                    imvPhoto.setTag("glass");
                }
                else if(imvPhoto.getTag() == "glass"){
                    imvPhoto.setImageResource(R.drawable.cheems_bonk);
                    //imvPhoto.setImageDrawable(getResources().getDrawable(R.Drawable.glass_cheems));
                    imvPhoto.setTag("bonk");
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

    private void linkViews() {
        imvPhoto = findViewById(R.id.imv_Photo);
        btnChange = findViewById(R.id.btn_Change);
        btnClose = findViewById(R.id.btn_Close);
    }
}