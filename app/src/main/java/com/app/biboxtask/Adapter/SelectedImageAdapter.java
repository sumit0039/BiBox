package com.app.biboxtask.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.biboxtask.Helper.ItemTouchHelperAdapter;
import com.app.biboxtask.Helper.OnStartDragListener;
import com.app.biboxtask.R;
import com.app.biboxtask.databinding.SelectedImageRowBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;

public class SelectedImageAdapter extends RecyclerView.Adapter<SelectedImageAdapter.selectedViewHolder>
        implements ItemTouchHelperAdapter {
    private Context context;
    private ArrayList<Integer> arrayList;
    private OnStartDragListener onStartDragListener;
    private LayoutInflater layoutInflater;

    public SelectedImageAdapter(Context context, ArrayList<Integer> arrayList, OnStartDragListener onStartDragListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.onStartDragListener = onStartDragListener;
    }

    @NonNull
    @Override
    public SelectedImageAdapter.selectedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SelectedImageRowBinding binding;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.selected_image_row,parent,false);
        return new SelectedImageAdapter.selectedViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedImageAdapter.selectedViewHolder holder, int position) {
        Log.d("jdksbf",arrayList.get(position).toString());

            Glide.with(context).load(arrayList.get(position)).into(holder.binding.image);
        holder.binding.cardView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN)
                    onStartDragListener.onStartDrag(holder);
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(arrayList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        arrayList.remove(position);
        notifyItemRemoved(position);
    }

    public class selectedViewHolder extends RecyclerView.ViewHolder{
        SelectedImageRowBinding binding;
        public selectedViewHolder(@NonNull SelectedImageRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
