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

    private MutableLiveData<Integer> _number1 = new MutableLiveData<>(0);// для Model
    public LiveData<Integer> number1 = _number1; // для View

    private MutableLiveData<Integer> _number2 = new MutableLiveData<>(0);// для Model
    public LiveData<Integer> number2  = _number2; // для View

    private MutableLiveData<String> _number1last = new MutableLiveData<>("");// для Model
    public LiveData<String> number1last = _number1last; // для View

    private MutableLiveData<String> _number2last = new MutableLiveData<>("");// для Model
    public LiveData<String> number2last  = _number2last; // для View



    private MutableLiveData<String> _stroke = new MutableLiveData<>("");// для Model
    public LiveData<String> stroke  = _stroke; // для View


    public void set_avgscore(int _score) {
        this._avgscore.setValue(_score);
    }
    public void set_answer(int _answer){this._answer.setValue(_answer);}

    public void set_count(int _count){this._count.setValue(_count);}

    public void set_number1(int _number1){this._number1.setValue(_number1);}
    public void set_number2(int _number2){this._number2.setValue(_number2);}

    public void set_number1last(String _number1last){this._number1last.setValue(_number1last);}
    public void set_number2last(String _number2last){this._number2last.setValue(_number2last);}

    public void set_stroke(String _stroke){this._stroke.setValue(_stroke);}
}
