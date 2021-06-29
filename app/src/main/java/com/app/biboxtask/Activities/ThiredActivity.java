package com.app.biboxtask.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.app.biboxtask.Adapter.SelectedImageAdapter;
import com.app.biboxtask.Helper.MyItemTouchHelperCallback;
import com.app.biboxtask.Helper.OnStartDragListener;
import com.app.biboxtask.R;
import com.app.biboxtask.databinding.ActivityThiredBinding;

import java.util.ArrayList;

import butterknife.BindView;

public class ThiredActivity extends AppCompatActivity {
    private ActivityThiredBinding binding;

    private ArrayList<Integer> myList;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private ArrayList<Integer> colorArrayList;

    @BindView(R.id.selected_image_recyclerView)
    RecyclerView recyclerView;

    ItemTouchHelper itemTouchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_thired);

//        data();
        myList = (ArrayList<Integer>) getIntent().getSerializableExtra("myList");
        colorArrayList = myList;
//        pos = getIntent().getIntExtra("position",0);
        binding.next.setOnClickListener(v -> {
            startActivity(new Intent(ThiredActivity.this,FourthActivity.class)
                    .putExtra("arrayList",colorArrayList));
        });




        for (int i=0; i<myList.size(); i++){
            arrayList.add(myList.get(i));
            Log.d("shbcsd",arrayList.toString());
        }
        binding.selectedImageRecyclerView.setHasFixedSize(true);
        binding.selectedImageRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        SelectedImageAdapter adapter = new SelectedImageAdapter(this, arrayList, new OnStartDragListener() {
            @Override
            public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
                itemTouchHelper.startDrag(viewHolder);
                colorArrayList = arrayList;
                Log.d("hadbdsc",arrayList.toString());
            }
        });
        binding.selectedImageRecyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback  callback = new MyItemTouchHelperCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(binding.selectedImageRecyclerView);



    }

//    private void data() {
//        ButterKnife.bind(this);
//        recyclerView.setHasFixedSize(true);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(layoutManager);
//
//        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this, arrayList, viewHolder -> {
//            itemTouchHelper.startDrag(viewHolder);
//        });
//        recyclerView.setAdapter(myRecyclerAdapter);
//        ItemTouchHelper.Callback  callback = new MyItemTouchHelperCallback(myRecyclerAdapter);
//        itemTouchHelper = new ItemTouchHelper(callback);
//        itemTouchHelper.attachToRecyclerView(recyclerView);
//    }
}