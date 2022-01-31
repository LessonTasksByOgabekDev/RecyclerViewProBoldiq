package dev.ogabek.recyclerviewprobolamiz.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.recyclerviewprobolamiz.R;
import dev.ogabek.recyclerviewprobolamiz.adapter.DevsAdapter;
import dev.ogabek.recyclerviewprobolamiz.helper.ForIntent;
import dev.ogabek.recyclerviewprobolamiz.listener.OnClickListener;
import dev.ogabek.recyclerviewprobolamiz.model.Devs;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    RecyclerView recyclerView;
    MainActivity mainActivity;

    ForIntent forIntent = new ForIntent(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_main_recycler_view);
        mainActivity = this;

        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));

        DevsAdapter adapter = new DevsAdapter(prepareDevsList(), mainActivity, this);

        recyclerView.setAdapter(adapter);

    }

    private List<Devs> prepareDevsList() {
        List<Devs> devsList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            devsList.add(new Devs(R.mipmap.ic_launcher_round, "Name  " + i, "Job  " + i));
        }
        return devsList;
    }

    public void callShowActivityWithData(Devs dev) {
        startActivity(forIntent.sendDevsToShowActivity(dev));
    }


    @Override
    public void onItemClickListener(Devs dev) {
        callShowActivityWithData(dev);
    }
}