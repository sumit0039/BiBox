package com.app.biboxtask.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.app.biboxtask.R;
import com.app.biboxtask.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {
    private ActivityFirstBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_first);

        binding.tv1.setText("Bicycle Description");
        binding.tv2.setText("A bicycle (or bike) is a small, human powered land vehicle with a seat, two wheels, two pedals, and a metal chain connected to cogs on the pedals and rear wheel. A frame gives the bike strength, and the other parts are attached to the frame. The name comes from these two words - the prefix \"bi-\" meaning two, and the suffix \"-cycle\" meaning wheel. It is powered by a person riding on top, who pushes the pedals around with his or her feet.\n"+
                "\n"+
                "Riding bicycles, which is also called cycling, is an important way to travel in several parts of the world. The most popular type of cycling is Utility cycling. It is also a common recreation, a good form of low-impact exercise, and a popular sport. Road bicycle racing is the second most popular spectator sport in the world. Bicycling uses less energy per mile than any other human transport.");

        binding.start.setOnClickListener(v -> {
            startActivity(new Intent(this,SecondActivity.class));
        });
    }
}