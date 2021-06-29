package com.app.biboxtask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.biboxtask.Model.BicyclePartsPojo;
import com.app.biboxtask.R;
import com.app.biboxtask.databinding.BicyclePartsRowBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BicyclePartsAdapter extends RecyclerView.Adapter<BicyclePartsAdapter.partsViewHolder> {
    private Context context;
    private List<BicyclePartsPojo> partsPojoList;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private OngetIds ongetIds;
    private LayoutInflater layoutInflater;

    public BicyclePartsAdapter(Context context, List<BicyclePartsPojo> partsPojoList,OngetIds ongetIds) {
        this.context = context;
        this.partsPojoList = partsPojoList;
        this.ongetIds = ongetIds;
    }
    public interface OngetIds{
        void OnAddressSelect(ArrayList<Integer> arrayList);
    }

    @NonNull
    @Override
    public BicyclePartsAdapter.partsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BicyclePartsRowBinding binding;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.bicycle_parts_row,parent,false);
        return new BicyclePartsAdapter.partsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BicyclePartsAdapter.partsViewHolder holder, int position) {
        BicyclePartsPojo data = partsPojoList.get(position);
        Glide.with(context).load(data.getImage()).into(holder.binding.image);
        holder.binding.name.setText(data.getName());
        if(partsPojoList != null && partsPojoList.size()>0){
//            holder.checkBox.setText(userList.get(position).getId());
            holder.binding.checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.binding.checkbox.isChecked()){
                        arrayList.add(partsPojoList.get(position).getImage());

                    }else {
                        arrayList.remove(Integer.valueOf(partsPojoList.get(position).getImage()));
                    }
                    ongetIds.OnAddressSelect(arrayList);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return partsPojoList.size();
    }

    public class partsViewHolder extends RecyclerView.ViewHolder{
        BicyclePartsRowBinding binding;
        public partsViewHolder(@NonNull BicyclePartsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
