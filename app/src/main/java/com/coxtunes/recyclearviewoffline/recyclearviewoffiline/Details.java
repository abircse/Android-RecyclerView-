package com.coxtunes.recyclearviewoffline.recyclearviewoffiline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView img = findViewById(R.id.dimage);
        TextView txt = findViewById(R.id.dtext);

        //-----for receive image postion-----//
        int image = (int) getIntent().getSerializableExtra("image");
        //------For receive  text position-----//
        String text = getIntent().getStringExtra("text");

        img.setImageResource(image);
        txt.setText(text);

    }
}
