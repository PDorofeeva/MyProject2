package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.databinding.FragmentElementarySchoolRussianBinding;
import com.example.myproject.databinding.FragmentOrphogramsBinding;

public class Orphograms extends Fragment {
    private FragmentOrphogramsBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Orphograms() {
        // Required empty public constructor
    }


    public static Orphograms newInstance(String param1, String param2) {
        Orphograms fragment = new Orphograms();
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
        binding = FragmentOrphogramsBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnRussianBack.setOnClickListener(view1 -> goToBackScreen());
        binding.button.setOnClickListener(view2 -> goToNextScreen(1));

    }

    public void goToBackScreen(){
        Navigation.findNavController(requireView()).navigate(R.id.action_orphograms_to_elementarySchoolRussian);
    }

    public void goToNextScreen(int number){
        if (number == 1){
            Navigation.findNavController(requireView()).navigate(R.id.action_orphograms_to_theoryAndPracticeRussian);
        }
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}