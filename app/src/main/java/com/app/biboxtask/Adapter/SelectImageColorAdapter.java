package com.app.biboxtask.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.biboxtask.R;
import com.app.biboxtask.databinding.SelectImageColorRowBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SelectImageColorAdapter extends RecyclerView.Adapter<SelectImageColorAdapter.colorViewHolder> {
    private Context context;
    private ArrayList<Integer> arrayList;
    private LayoutInflater layoutInflater;
    private OnClick onClick;

    public SelectImageColorAdapter(Context context, ArrayList<Integer> arrayList,OnClick onClick) {
        this.context = context;
        this.arrayList = arrayList;
        this.onClick = onClick;
    }


    @NonNull
    @Override
    public SelectImageColorAdapter.colorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SelectImageColorRowBinding binding;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.select_image_color_row,parent,false);
        return new SelectImageColorAdapter.colorViewHolder(binding);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull SelectImageColorAdapter.colorViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position)).into(holder.binding.image);
        holder.binding.cardView.setOnClickListener(v -> {
            onClick.getData(holder.binding.colorLayout,position);
        });
//        holder.binding.cardView.setOnClickListener(v -> {
//            holder.binding.colorLayout.setBackgroundResource(R.drawable.bg_color);
//        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class colorViewHolder extends RecyclerView.ViewHolder{
        SelectImageColorRowBinding binding;
        public colorViewHolder(@NonNull SelectImageColorRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
//            binding.cardView.setOnClickListener(v -> {
//
//                onClick.getData(binding.colorLayout,arrayList.get(getAdapterPosition()));
//            });
        }
    }
    public interface OnClick{
        void getData(LinearLayout linearLayout,int position);
    }

}
