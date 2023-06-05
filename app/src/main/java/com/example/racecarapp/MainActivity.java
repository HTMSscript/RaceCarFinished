package com.example.racecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static ImageView ivDri;
    private static ImageView ivFin;
    private static ImageView ivMon;
    private static ImageView ivNit;
    private static ImageView ivPit;
    private static ImageView ivSta;
    private static TextView tvDesc;
    private static Button btnOpt1;
    private static Button btnOpt2;
    private static Button btnOpt3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivDri = findViewById(R.id.iv_img1);
        ivFin = findViewById(R.id.iv_img2);
        ivMon = findViewById(R.id.iv_img3);
        ivNit = findViewById(R.id.iv_img4);
        ivPit = findViewById(R.id.iv_img5);
        ivSta = findViewById(R.id.iv_img6);
        tvDesc = findViewById(R.id.tv_desc);
        btnOpt1 = findViewById(R.id.btn_op1);
        btnOpt2 = findViewById(R.id.btn_opt2);
        btnOpt3 = findViewById(R.id.btn_opt3);

        btnOpt1.setVisibility(View.INVISIBLE);
        btnOpt2.setVisibility(View.INVISIBLE);
        btnOpt3.setVisibility(View.INVISIBLE);
        ivDri.setVisibility(View.INVISIBLE);
        ivFin.setVisibility(View.INVISIBLE);
        ivNit.setVisibility(View.INVISIBLE);
        ivPit.setVisibility(View.INVISIBLE);
        ivSta.setVisibility(View.INVISIBLE);



        //Intent intent = new Intent(this, exampleActivity.class);
        //intent.putExtra("key ", data);


        Car honda = new Car();
        Car lexus = new Car("Lexus", "Silver");
        Track monaco = new Track(honda, lexus);

        //runs app
        monaco.race();
    }

    public static Button getBtnOpt1() {
        return btnOpt1;
    }

    public static Button getBtnOpt2() {
        return btnOpt2;
    }
    public static Button getBtnOpt3() {
        return btnOpt3;
    }
    public static void btnSetText(Button btn, String str) {
        btn.setText(str);
    }
    public static TextView getTvDesc() {
        return tvDesc;
    }
    public static void tvSetText(TextView tv, String str) {
        tv.setText(str);
    }
    public static void btnSetVis(Button btn) {
        btn.setVisibility(View.VISIBLE);
    }
    public static void btnSetInvis(Button btn) {
        btn.setVisibility(View.INVISIBLE);
    }
    public static ImageView getIvSta() {
        return ivSta;
    }
    public static ImageView getIvDri() {
        return ivDri;
    }
    public static ImageView getIvFin() {
        return ivFin;
    }
    public static ImageView getIvMon() {
        return ivMon;
    }
    public static ImageView getIvNit() {
        return ivNit;
    }
    public static ImageView getIvPit() {
        return ivPit;
    }
}

