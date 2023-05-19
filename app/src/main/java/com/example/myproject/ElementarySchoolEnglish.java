package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.databinding.FragmentElementarySchoolEnglishBinding;
import com.example.myproject.databinding.FragmentElementarySchoolRussianBinding;

public class ElementarySchoolEnglish extends Fragment {

    private FragmentElementarySchoolEnglishBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ElementarySchoolEnglish() {
        // Required empty public constructor
    }


    public static ElementarySchoolEnglish newInstance(String param1, String param2) {
        ElementarySchoolEnglish fragment = new ElementarySchoolEnglish();
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
        binding = FragmentElementarySchoolEnglishBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.btnEnglishBack.setOnClickListener(view1 -> goToBackScreen());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void goToNextScreen(int number) {

    }
    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_elementarySchoolEnglish_to_mainfragment);
    }
}