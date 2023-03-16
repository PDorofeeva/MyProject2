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
import com.example.myproject.databinding.FragmentAverageScoreBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AverageScore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AverageScore extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private FragmentAverageScoreBinding fragmentAverageScoreBinding;

    public AverageScore() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AverageScore.
     */
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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