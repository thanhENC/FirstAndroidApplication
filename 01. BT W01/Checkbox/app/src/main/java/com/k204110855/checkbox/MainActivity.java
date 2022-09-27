package com.k204110855.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.k204110855.checkbox.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    CheckBox chkFilm, chkFPT, chkClip;
//    Button btnConfirm;
//    TextView txtVote;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        LinkViews();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addEvents();
    }

//    private void LinkViews() {
//        chkFilm = findViewById(R.id.chk_Film);
//        chkClip = findViewById(R.id.chk_ClipTV);
//        chkFPT = findViewById(R.id.chk_FPT);
//        btnConfirm = findViewById(R.id.btn_Confirm);
//        txtVote = findViewById(R.id.txt_Vote);
//    }

    private void addEvents() {
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "Bạn chọn: ";
                if (binding.chkFilm.isChecked()) {
                    s += binding.chkFilm.getText().toString() + ", ";
                }
                if (binding.chkClipTV.isChecked()) {
                    s += binding.chkClipTV.getText().toString() + ", ";
                }
                if (binding.chkFPT.isChecked()) {
                    s += binding.chkFPT.getText().toString() + ", ";
                }

                if (s == "Bạn chọn: "){
                    s = "Bạn nhạt nhẽo zị, hông thích xem phim luôn.";
                }
                else {
                    s = s.substring(0, s.length()-2) + ".";
                }

                binding.txtVote.setText(s);
            }
        });
//        btnConfirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s = "Bạn chọn: ";
//
//                if (chkFilm.isChecked()) {
//                    s += chkFilm.getText().toString() + ", ";
//                }
//                if (chkClip.isChecked()) {
//                    s += chkClip.getText().toString() + ", ";
//                }
//                if (chkFPT.isChecked()) {
//                    s += chkFPT.getText().toString() + ", ";
//                }
//
//                if (s == "Bạn chọn: "){
//                    s = "Bạn nhạt nhẽo zị, hông thích xem phim luôn.";
//                }
//                else {
//                    s = s.substring(0, s.length()-2) + ".";
//                }
//
//                txtVote.setText(s);
//            }
//        });
    }
}