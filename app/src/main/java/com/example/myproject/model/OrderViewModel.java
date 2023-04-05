package com.example.myproject.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel extends ViewModel {
    private MutableLiveData<Double> _avgscore = new MutableLiveData<>(0.0);// для Model
    public LiveData<Double> avgscore  = _avgscore; // для View

    public void set_avgscore(double _score) {
        this._avgscore.setValue(_score);
    }
}
