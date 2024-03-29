package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.databinding.ElementaryschoolmathBinding;

public class ElementarySchoolMath extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ElementaryschoolmathBinding elementaryschoolmathBinding;

    public ElementarySchoolMath() {
        // Required empty public constructor
    }
    public static ElementarySchoolMath newInstance(String param1, String param2) {
        ElementarySchoolMath fragment = new ElementarySchoolMath();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        elementaryschoolmathBinding.btnaddition.setOnClickListener(view1 -> goToNextScreen());
        elementaryschoolmathBinding.btnaddition.setOnClickListener(view2 -> goToNextScreen());
        elementaryschoolmathBinding.btnMathBack.setOnClickListener(view2 -> goToBackScreen());
    }
    public void goToNextScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_elementaryschoolmath_to_theoryandpractice);
    }
    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_elementaryschoolmath_to_mainfragment);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        elementaryschoolmathBinding = ElementaryschoolmathBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return elementaryschoolmathBinding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        elementaryschoolmathBinding = null;
    }
}