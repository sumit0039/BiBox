package com.app.biboxtask.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app.biboxtask.Adapter.BicyclePartsAdapter;
import com.app.biboxtask.Model.BicyclePartsPojo;
import com.app.biboxtask.R;
import com.app.biboxtask.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements BicyclePartsAdapter.OngetIds{
    private ActivitySecondBinding binding;
    private List<BicyclePartsPojo> partsPojoList;
    private ArrayList<Integer> newAarrayList = new ArrayList<>();
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second);

        binding.bicyclePartsRecyclerview.setHasFixedSize(true);
        binding.bicyclePartsRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.bicyclePartsRecyclerview.setAdapter(new BicyclePartsAdapter(this,getPartsList(),SecondActivity.this));

        binding.next.setOnClickListener(v -> {
            if (newAarrayList.size()==0){
                Toast.makeText(SecondActivity.this,"Please select atleast one parts",Toast.LENGTH_LONG).show();
            }else {
                startActivity(new Intent(SecondActivity.this,ThiredActivity.class)
                        .putExtra("myList",newAarrayList));
            }

        });
    }

    private List<BicyclePartsPojo> getPartsList() {
        partsPojoList = new ArrayList<>();
        partsPojoList.add(new BicyclePartsPojo(R.drawable.seat,"Seat"));
        partsPojoList.add(new BicyclePartsPojo(R.drawable.handle,"Handle"));
        partsPojoList.add(new BicyclePartsPojo(R.drawable.chain,"Chain"));
        partsPojoList.add(new BicyclePartsPojo(R.drawable.wheel,"Wheel"));
        partsPojoList.add(new BicyclePartsPojo(R.drawable.image,"Break"));
        return partsPojoList;
    }


    @Override
    public void OnAddressSelect(ArrayList<Integer> arrayList) {
        newAarrayList = arrayList;
//        pos = position;
        Log.d("jshbjhsd",newAarrayList.toString());
//        Log.d("jshbjhsd", String.valueOf(position));


    }

//    @Override
//    public void OnAddressSelect(ArrayList<String> arrayList) {
//        newAarrayList = arrayList;
////        pos = position;
//        Log.d("jshbjhsd",newAarrayList.toString());
////        Log.d("jshbjhsd", String.valueOf(position));
//    }


}