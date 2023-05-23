package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentMathTestResultBinding;
import com.example.myproject.databinding.FragmentRussianTestResultsBinding;
import com.example.myproject.model.OrderViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class russianTestResults extends Fragment {

    private DatabaseReference dataBase;
    private OrderViewModel orderViewModelPr;
    private TextView textView25, textView42;
    public FragmentRussianTestResultsBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public russianTestResults() {
        // Required empty public constructor
    }

    public static russianTestResults newInstance(String param1, String param2) {
        russianTestResults fragment = new russianTestResults();
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
        binding = FragmentRussianTestResultsBinding.inflate(inflater, container, false);
        orderViewModelPr = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        binding.setViewModelPr(orderViewModelPr);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView25 = view.findViewById(R.id.textView25);
        textView42 = view.findViewById(R.id.textView42);
        binding.imageButton2.setOnClickListener(view1 -> goToBackScreen());
        binding.imageButton12.setOnClickListener(view2 -> goToNextScreen());
    }

    public void goToNextScreen(){
        dataBase = FirebaseDatabase.getInstance().getReference("UsersResults/");
        String answer = textView25.getText().toString();
        String count = textView42.getText().toString();
        UserInfo User = new UserInfo(FirebaseAuth.getInstance().getUid(), answer, count);//!
        //Navigation.findNavController(requireView()).navigate(R.id.action_mathTestResult_to_historyOfResults);
        dataBase.child("RussianResults").push().setValue(User).addOnSuccessListener(unused -> Log.d("TTT", "Works")).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("TTT", e.toString());
            }
        });

        Toast.makeText(getActivity(), "Успешно", Toast.LENGTH_SHORT).show();
        //Database.child("User").child(FirebaseAuth.getInstance().getUid()).child("answer").setValue(fragmentMathTestResultBinding.textView42.getText().toString());
    }

    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_russianTestResults_to_mainfragment);
    }
}