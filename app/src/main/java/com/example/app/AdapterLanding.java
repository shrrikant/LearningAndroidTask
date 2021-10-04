package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleviewmultipleviews.BR;
import com.example.recycleviewmultipleviews.R;
import com.example.recycleviewmultipleviews.databinding.CardLayoutBinding;

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
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        CardLayoutBinding view = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.card_layout, parent, false);
        return new AdapterLanding.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLanding.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        DentistDataModal model = dataModelArrayList.get(position);
        holder.bind(model);
        Glide.with(context).load(model.getImage()).into(holder.categoryBinding.mediaImage);
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
        CardLayoutBinding categoryBinding;

        public Viewholder(@NonNull CardLayoutBinding itemView) {
            super(itemView.getRoot());
            this.categoryBinding = itemView;

        }

        public void bind(Object obj) {
            categoryBinding.setVariable(BR.model, obj);
            categoryBinding.executePendingBindings();
        }
    }
}
