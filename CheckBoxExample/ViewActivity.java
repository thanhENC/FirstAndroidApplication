package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    CheckBox chkFilm, chkFPT, chkClip;
    Button btnConfirm;
    TextView txtVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        chkFilm = findViewById(R.id.chk_Film);
        chkFPT = findViewById(R.id.chk_FPT);
        chkClip = findViewById(R.id.chk_Clip);

        btnConfirm = findViewById(R.id.btn_Confirm);

        txtVote = findViewById(R.id.txt_Vote);
    }

    private void addEvents() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code here
                String s = "Bạn chọn: ";
                if (chkFilm.isChecked())
                    s += chkFilm.getText().toString() + ", ";
                if (chkFPT.isChecked())
                    s += chkFPT.getText().toString() + ", ";
                if (chkClip.isChecked())
                    s += chkClip.getText().toString();

                txtVote.setText(s);
            }
        });
    }
}