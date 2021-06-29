package com.app.biboxtask.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.app.biboxtask.Adapter.SelectImageColorAdapter;
import com.app.biboxtask.MainActivity;
import com.app.biboxtask.R;
import com.app.biboxtask.databinding.ActivityFourthBinding;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity implements SelectImageColorAdapter.OnClick{
  private ActivityFourthBinding binding;
    LinearLayout mLinear;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_fourth);

        ArrayList<Integer> myList = (ArrayList<Integer>) getIntent().getSerializableExtra("arrayList");
        Log.d("jknskd",myList.toString());

        binding.colorRecyclerView.setHasFixedSize(true);
        binding.colorRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        binding.colorRecyclerView.setAdapter(new SelectImageColorAdapter(this,myList,FourthActivity.this));
        binding.redColor.setOnClickListener(v -> {
           if (pos >= 0){
               mLinear.setBackgroundResource(R.drawable.bg_red);
           }

        });
        binding.greenColor.setOnClickListener(v -> {
            if (pos >= 0){
                mLinear.setBackgroundResource(R.drawable.bg_green);
            }
        });

        binding.yellowColor.setOnClickListener(v -> {
            if (pos >= 0){
                mLinear.setBackgroundResource(R.drawable.bg_yellow);
            }
        });

        binding.next.setOnClickListener(v -> {
            binding.colorLayout.setVisibility(View.GONE);
            binding.next.setVisibility(View.GONE);
            binding.color.setVisibility(View.GONE);
            binding.finish.setVisibility(View.VISIBLE);
        });
    }
    @Override
    public void getData(LinearLayout linearLayout, int position) {
        mLinear = linearLayout;
        pos = position;
        binding.colorLayout.setVisibility(View.VISIBLE);
        binding.next.setVisibility(View.VISIBLE);
        binding.color.setVisibility(View.VISIBLE);

        Log.d("ckdsn",Integer.valueOf(pos).toString());
//        mLinear.setBackgroundResource(R.drawable.bg_red);


    }
}