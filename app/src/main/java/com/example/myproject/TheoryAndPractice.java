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

import com.example.myproject.databinding.TheoryandpracticeBinding;
import com.example.myproject.model.OrderViewModel;

import java.util.Random;

public class TheoryAndPractice extends Fragment {
    private OrderViewModel orderViewModelPr;
    TheoryandpracticeBinding theoryandpracticeBinding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TheoryAndPractice() {
        // Required empty public constructor
    }

    public static TheoryAndPractice newInstance(String param1, String param2) {
        TheoryAndPractice fragment = new TheoryAndPractice();
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
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        theoryandpracticeBinding.btnPractice.setOnClickListener(view1 -> goToNextScreen());
        theoryandpracticeBinding.theoryAndPracticeBack.setOnClickListener(view2 -> goToBackScreen());
    }
    Random rnd = new Random();
    int number1 = rnd.nextInt(100);
    int number2 = rnd.nextInt(100);
    public void goToNextScreen() {
        orderViewModelPr.set_number1(number1);
        orderViewModelPr.set_number2(number2);
        Navigation.findNavController(requireView()).navigate(R.id.action_theoryandpractice_to_newfragment);
    }
    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_theoryandpractice_to_elementaryschoolmath);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        theoryandpracticeBinding = TheoryandpracticeBinding.inflate(inflater, container, false);
        orderViewModelPr = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        // Inflate the layout for this fragment
        return theoryandpracticeBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        theoryandpracticeBinding = null;
    }
}