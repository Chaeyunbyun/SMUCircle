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


public class ReligionAdapter extends RecyclerView.Adapter<ReligionAdapter.ReligionViewHolder> {


    private ArrayList<EtcData> arrayList;
    private Context context;
    private OnItemClickListener mListener = null;

    public ReligionAdapter() {

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    public ReligionAdapter(ArrayList<EtcData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReligionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.etc_list, parent, false);
        ReligionViewHolder holder = new ReligionViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReligionViewHolder holder, int position) {
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

    public class ReligionViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView c_name;
        TextView master;
        TextView room;

        public ReligionViewHolder(@NonNull View itemView) {
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