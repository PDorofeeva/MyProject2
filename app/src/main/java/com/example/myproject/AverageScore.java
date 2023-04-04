package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.myproject.databinding.ElementaryschoolmathBinding;
import com.example.myproject.databinding.FragmentAverageScoreBinding;

public class AverageScore extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private FragmentAverageScoreBinding fragmentAverageScoreBinding;

    public AverageScore() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AverageScore newInstance(String param1, String param2) {
        AverageScore fragment = new AverageScore();
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

        double CurrentAverageScore = Double.parseDouble(String.valueOf(R.id.editTextNumberDecimal2));
        double NewAverageScore = Double.parseDouble(String.valueOf(R.id.editTextNumberDecimal));
        int quantity = Integer.parseInt(String.valueOf(R.id.editTextNumberSigned));
        ForAverageScore result = new ForAverageScore(CurrentAverageScore, NewAverageScore, quantity);
        int result2 = Integer.parseInt(String.valueOf(result));




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view =

        fragmentAverageScoreBinding = FragmentAverageScoreBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return fragmentAverageScoreBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentAverageScoreBinding.btncount2.setOnClickListener(view1 -> Buttons());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentAverageScoreBinding = null;
    }

    public void Buttons(){
        Navigation.findNavController(requireView()).navigate(R.id.action_averageScore_to_scoreAnswer);
    }
}