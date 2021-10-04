package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleviewmultipleviews.R;

import java.util.ArrayList;

public class AdapterLanding extends RecyclerView.Adapter<AdapterLanding.Viewholder> {

    private Context context;
    private ArrayList<DentistDataModal> dataModelArrayList;

    // Constructor
    public AdapterLanding(Context context, ArrayList<DentistDataModal> dataModelArrayList) {
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @NonNull
    @Override
    public AdapterLanding.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLanding.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        DentistDataModal model = dataModelArrayList.get(position);
        holder.dataName.setText(model.getName());
        holder.shortDataName.setText(model.getShortName());
        holder.totalCourses.setText(model.getTotalCourses());
        Glide.with(context).load(model.getImage()).into(holder.dataImage);
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return dataModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView dataImage;
        private TextView dataName;
        private TextView shortDataName;
        private TextView totalCourses;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            dataImage = itemView.findViewById(R.id.media_image);
            dataName = itemView.findViewById(R.id.head_name);
            shortDataName = itemView.findViewById(R.id.short_name);
            totalCourses = itemView.findViewById(R.id.total_courses);

        }
    }
}
