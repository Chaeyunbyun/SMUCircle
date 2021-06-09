package com.example.smucircle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.VolunteerViewHolder> {


    private ArrayList<EtcData> arrayList;
    private Context context;
    private OnItemClickListener mListener = null;

    public VolunteerAdapter() {

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    public VolunteerAdapter(ArrayList<EtcData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VolunteerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.etc_list, parent, false);
        VolunteerViewHolder holder = new VolunteerViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VolunteerViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.profile);
        holder.c_name.setText(arrayList.get(position).getCname());
        holder.master.setText(arrayList.get(position).getMaster());
        holder.room.setText(arrayList.get(position).getRoom());


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class VolunteerViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView c_name;
        TextView master;
        TextView room;

        public VolunteerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile = itemView.findViewById(R.id.profile);
            this.c_name = itemView.findViewById(R.id.c_name);
            this.master = itemView.findViewById(R.id.master);
            this.room = itemView.findViewById(R.id.room);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(v, position);
                        }
                    }

                }
            });
        }
    }
}