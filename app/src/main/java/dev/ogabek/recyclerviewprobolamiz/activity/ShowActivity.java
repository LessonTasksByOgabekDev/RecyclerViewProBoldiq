package dev.ogabek.recyclerviewprobolamiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import dev.ogabek.recyclerviewprobolamiz.R;
import dev.ogabek.recyclerviewprobolamiz.model.Devs;

public class ShowActivity extends AppCompatActivity {

    ImageView img;
    TextView name, job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        initViews();

        getData();

    }

    private void getData() {
        Devs dev = getIntent().getParcelableExtra("dev");
        img.setImageResource(dev.getImg());
        name.setText(dev.getName());
        job.setText(dev.getJob());
    }

    private void initViews() {
        img = findViewById(R.id.iv_img);
        name = findViewById(R.id.tv_name);
        job = findViewById(R.id.tv_job);
    }
}