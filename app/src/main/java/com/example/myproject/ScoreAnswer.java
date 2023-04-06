package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myproject.databinding.FragmentAverageScoreBinding;
import com.example.myproject.databinding.FragmentScoreAnswerBinding;
import com.example.myproject.model.OrderViewModel;

public class ScoreAnswer extends Fragment {

    TextView txt;
    private OrderViewModel orderViewModel;

    public FragmentScoreAnswerBinding fragmentScoreAnswerBinding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScoreAnswer() {
        // Required empty public constructor
    }

    public static ScoreAnswer newInstance(String param1, String param2) {
        ScoreAnswer fragment = new ScoreAnswer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//pdct.1.1.20230406T133711Z.13e82af190600236.8d14e3e11e16383c8e446125ee47f705544b2e8f

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentScoreAnswerBinding = FragmentScoreAnswerBinding.inflate(inflater, container, false);
        orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentScoreAnswerBinding.setViewModel(orderViewModel);
        fragmentScoreAnswerBinding.setLifecycleOwner(this);
        //Log.d("RRR",number+"");
        //orderViewModel.set_avgscore(number);
        // Inflate the layout for this fragment
        return fragmentScoreAnswerBinding.getRoot();
    }


}