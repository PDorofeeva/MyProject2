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
import com.example.myproject.databinding.FragmentElementarySchoolRussianBinding;


public class ElementarySchoolRussian extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private FragmentElementarySchoolRussianBinding elementarySchoolRussianBinding;

    public ElementarySchoolRussian() {
        // Required empty public constructor
    }

    public static ElementarySchoolRussian newInstance(String param1, String param2) {
        ElementarySchoolRussian fragment = new ElementarySchoolRussian();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        elementarySchoolRussianBinding = FragmentElementarySchoolRussianBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return elementarySchoolRussianBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        elementarySchoolRussianBinding.btnRussianBack.setOnClickListener(view1 -> goToBackScreen());
        elementarySchoolRussianBinding.btn.setOnClickListener(view1 -> goToNextScreen(1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        elementarySchoolRussianBinding = null;
    }

    public void goToNextScreen(int number) {
        if(number == 1){
        Navigation.findNavController(requireView()).navigate(R.id.action_elementarySchoolRussian_to_orphograms);}
    }
    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_elementarySchoolRussian_to_mainfragment);
    }
}