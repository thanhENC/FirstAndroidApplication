package com.k204110855.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButton_Ex extends AppCompatActivity {
    // RadioButton radTuongDoi, radTot, radRatTot, radTuyetVoi;
    RadioGroup radgOption;
    Button btnVote;
    TextView txtVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_ex);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";

                try {
                    int id = radgOption.getCheckedRadioButtonId();
                    RadioButton radChecked = findViewById(id);
                    s = radChecked.getText().toString();
                }
                catch(Exception ex) {
                    s = "Ủa, bạn đã chọn đou";
                };


//                if (radTuongDoi.isChecked()){
//                    s = radTuongDoi.getText().toString();
//                }
//                else if (radTot.isChecked()){
//                    s = radTot.getText().toString();
//                }
//                else if (radRatTot.isChecked()){
//                    s = radRatTot.getText().toString();
//                }
//                else if (radTuyetVoi.isChecked()){
//                    s = radTuyetVoi.getText().toString();
//                }
                txtVote.setText("Bạn chọn: " + s);
            }
        });
    }

    private void linkViews() {
//        radTuongDoi = findViewById(R.id.rad_TuongDoiTot);
//        radTot = findViewById(R.id.rad_Tot);
//        radRatTot = findViewById(R.id.rad_RatTot);
//        radTuyetVoi = findViewById(R.id.rad_TuyetVoi);
        radgOption = findViewById(R.id.radg_Option);
        btnVote = findViewById(R.id.btn_Vote);

        txtVote = findViewById(R.id.txt_Vote);
    }
}