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
import com.example.myproject.databinding.FragmentHistoryOfScoreBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryOfScore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryOfScore extends Fragment {
    FragmentHistoryOfScoreBinding historyOfScoreBinding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HistoryOfScore() {
        // Required empty public constructor
    }
    public static HistoryOfScore newInstance(String param1, String param2) {
        HistoryOfScore fragment = new HistoryOfScore();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        historyOfScoreBinding.imageButton3.setOnClickListener(view2 -> goToBackScreen());
    }
    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_historyOfScore_to_mainfragment);
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
        historyOfScoreBinding = FragmentHistoryOfScoreBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return historyOfScoreBinding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        historyOfScoreBinding = null;
    }
}