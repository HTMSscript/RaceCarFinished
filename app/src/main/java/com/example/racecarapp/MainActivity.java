package com.example.racecarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivImage;
    private TextView tvDesc;
    private static Button btnOpt1;
    private static Button btnOpt2;
    private static Button btnOpt3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImage = findViewById(R.id.iv_img);
        tvDesc = findViewById(R.id.tv_desc);
        btnOpt1 = findViewById(R.id.btn_op1);
        btnOpt2 = findViewById(R.id.btn_opt2);
        btnOpt3 = findViewById(R.id.btn_opt3);

        /*Intent intent = new Intent(this, exampleActivity.class);
        intent.putExtra("key ", data);

         */
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
}