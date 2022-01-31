package dev.ogabek.recyclerviewprobolamiz.helper;

import android.content.Context;
import android.content.Intent;

import dev.ogabek.recyclerviewprobolamiz.activity.ShowActivity;
import dev.ogabek.recyclerviewprobolamiz.model.Devs;

public class ForIntent {

    Context context;

    public ForIntent(Context context) {
        this.context = context;
    }

    public Intent sendDevsToShowActivity(Devs dev) {
        Intent intent = new Intent(context, ShowActivity.class);
        intent.putExtra("dev", dev);
        return intent;
    }

}
