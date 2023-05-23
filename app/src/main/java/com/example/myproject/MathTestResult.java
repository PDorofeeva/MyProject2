package com.example.myproject;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentMathTestResultBinding;
import com.example.myproject.databinding.FragmentScoreAnswerBinding;
import com.example.myproject.model.OrderViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MathTestResult extends Fragment {
    private ArrayList<UserInfo> list;
    private SharedPreferences sharedPreferences;
    private DatabaseReference dataBase;
    private OrderViewModel orderViewModelPr;
    private TextView textView25, textView42;
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
        textView25 = view.findViewById(R.id.textView25);
        textView42 = view.findViewById(R.id.textView42);
        fragmentMathTestResultBinding.imageButton2.setOnClickListener(view1 -> goToBackScreen());
        fragmentMathTestResultBinding.imageButton12.setOnClickListener(view2 -> goToNextScreen());
    }

    public void goToNextScreen(){
        dataBase = FirebaseDatabase.getInstance().getReference("UsersResults/");
        String answer = textView25.getText().toString();
        String count = textView42.getText().toString();
        UserInfo User = new UserInfo(FirebaseAuth.getInstance().getUid(), answer, count);//!
        dataBase.child("MathResults").push().setValue(User).addOnSuccessListener(unused -> Log.d("TTT", "4321")).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("TTT", e.toString());
            }
        });

        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(User);
        list = new ArrayList<>();

        Toast.makeText(getActivity(), "Успешно", Toast.LENGTH_SHORT).show();
        //Database.child("User").child(FirebaseAuth.getInstance().getUid()).child("answer").setValue(fragmentMathTestResultBinding.textView42.getText().toString());
    }

    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_mathTestResult_to_mainfragment);
    }
}