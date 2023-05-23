package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentAverageScoreBinding;
import com.example.myproject.databinding.FragmentScoreAnswerBinding;
import com.example.myproject.model.OrderViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ScoreAnswer extends Fragment {
    private DatabaseReference dataBase;
    private TextView txtforanswer;

    public FragmentScoreAnswerBinding fragmentScoreAnswerBinding;
    private OrderViewModel orderViewModel;

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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentScoreAnswerBinding = FragmentScoreAnswerBinding.inflate(inflater, container, false);
        orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentScoreAnswerBinding.setViewModel(orderViewModel);
        fragmentScoreAnswerBinding.setLifecycleOwner(this);

        //Log.d("RRR",number+"");
        // Inflate the layout for this fragment
        return fragmentScoreAnswerBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtforanswer = view.findViewById(R.id.txtforanswer);
        fragmentScoreAnswerBinding.imageButton5.setOnClickListener(view2 ->  goToBackScreen());
        fragmentScoreAnswerBinding.imageButton8.setOnClickListener(view3 -> Save());
    }

    public void Save(){
        dataBase = FirebaseDatabase.getInstance().getReference("UsersResults/");
        String quantity = txtforanswer.getText().toString();
        dataBase.child("UsersMarks").push().setValue(quantity).addOnSuccessListener(unused -> Log.d("TTT", "4321")).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("TTT", e.toString());
            }
        });


        Toast.makeText(getActivity(), "Успешно", Toast.LENGTH_SHORT).show();
        //Database.child("User").child(FirebaseAuth.getInstance().getUid()).child("answer").setValue(fragmentMathTestResultBinding.textView42.getText().toString());
    }

    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_scoreAnswer_to_mainfragment);
    }
}