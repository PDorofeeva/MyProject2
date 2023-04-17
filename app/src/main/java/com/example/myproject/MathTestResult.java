package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.databinding.FragmentMathTestResultBinding;
import com.example.myproject.databinding.FragmentScoreAnswerBinding;
import com.example.myproject.model.OrderViewModel;

public class MathTestResult extends Fragment {

    private OrderViewModel orderViewModelPr;
    public FragmentMathTestResultBinding fragmentMathTestResultBinding;

    public MathTestResult() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMathTestResultBinding = FragmentMathTestResultBinding.inflate(inflater, container, false);
        orderViewModelPr = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentMathTestResultBinding.setViewModelPr(orderViewModelPr);
        fragmentMathTestResultBinding.setLifecycleOwner(this);
        return fragmentMathTestResultBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentMathTestResultBinding.imageButton2.setOnClickListener(view1 -> goToBackScreen());
        fragmentMathTestResultBinding.imageButton12.setOnClickListener(view2 -> goToNextScreen());
    }

    public void goToNextScreen(){
        Navigation.findNavController(requireView()).navigate(R.id.action_mathTestResult_to_historyOfResults);
    }

    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_mathTestResult_to_mainfragment);
    }
}