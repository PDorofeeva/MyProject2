package com.example.myproject.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel extends ViewModel {
    private MutableLiveData<Integer> _avgscore = new MutableLiveData<>(1);// для Model
    public LiveData<Integer> avgscore  = _avgscore; // для View


    private MutableLiveData<Integer> _answer = new MutableLiveData<>(0);// для Model
    public LiveData<Integer> answer  = _answer; // для View

    private MutableLiveData<Integer> _count = new MutableLiveData<>(0);// для Model
    public LiveData<Integer> count  = _count; // для View

    public void set_avgscore(int _score) {
        this._avgscore.setValue(_score);
    }
    public void set_answer(int _answer){this._answer.setValue(_answer);}

    public void set_count(int _count){this._count.setValue(_count);}
}
