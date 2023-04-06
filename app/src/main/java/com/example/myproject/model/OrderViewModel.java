package com.example.myproject.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel extends ViewModel {
    private MutableLiveData<Integer> _avgscore = new MutableLiveData<>(1);// для Model
    public LiveData<Integer> avgscore  = _avgscore; // для View

    public void set_avgscore(int _score) {
        this._avgscore.setValue(_score);
    }
}
