package dev.ogabek.recyclerviewprobolamiz.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.recyclerviewprobolamiz.R;
import dev.ogabek.recyclerviewprobolamiz.activity.MainActivity;
import dev.ogabek.recyclerviewprobolamiz.activity.ShowActivity;
import dev.ogabek.recyclerviewprobolamiz.listener.OnClickListener;
import dev.ogabek.recyclerviewprobolamiz.model.Devs;

public class DevsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Devs> devsList;
    MainActivity mainActivity;

    OnClickListener listener;

    public DevsAdapter(List<Devs> devsList, MainActivity mainActivity, OnClickListener listener) {
        this.devsList = devsList;
        this.mainActivity = mainActivity;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new DevsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Devs dev = devsList.get(position);

        if (holder instanceof DevsViewHolder) {
            ((DevsViewHolder) holder).name.setText(dev.getName());
            ((DevsViewHolder) holder).job.setText(dev.getJob());
            ((DevsViewHolder) holder).item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    mainActivity.callShowActivityWithData(dev);
                    listener.onItemClickListener(dev);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return devsList.size();
    }

    private class DevsViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name, job;

        LinearLayout item;

        public DevsViewHolder(View view) {
            super(view);

            img = view.findViewById(R.id.item_img);
            name = view.findViewById(R.id.item_name);
            job = view.findViewById(R.id.item_job);

            item = view.findViewById(R.id.item);

        }
    }
}
