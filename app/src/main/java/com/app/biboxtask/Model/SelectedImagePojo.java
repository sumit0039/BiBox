package com.app.biboxtask.Model;

import java.util.ArrayList;

public class SelectedImagePojo {
 ArrayList<Integer> arrayList;

    public SelectedImagePojo(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}
