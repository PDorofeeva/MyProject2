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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentAverageScoreBinding;
import com.example.myproject.model.OrderViewModel;

import java.util.Objects;

public class AverageScore extends Fragment {
    public EditText editTextint;
    public EditText editTextdbl1;
    public EditText editTextdbl2;
    private FragmentAverageScoreBinding fragmentAverageScoreBinding;
    private OrderViewModel orderViewModel;

    public AverageScore() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAverageScoreBinding = FragmentAverageScoreBinding.inflate(inflater, container, false);
        orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentAverageScoreBinding.setViewModel(orderViewModel);
        fragmentAverageScoreBinding.setLifecycleOwner(this);


        return fragmentAverageScoreBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentAverageScoreBinding.btncount2.setOnClickListener(view1 -> Buttons());
        editTextint= view.findViewById(R.id.editTextNumberSigned);
        editTextdbl1 = view.findViewById(R.id.editTextNumberDecimal);
        editTextdbl2 = view.findViewById(R.id.editTextNumberDecimal2);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentAverageScoreBinding = null;
    }
    public static int Answer(int quantity, double NewAverageScore, double result){
        int five = 0;
        double current = result/quantity; // CurrentAverageScore
        if (current>=NewAverageScore){

        } else {
            while (current < NewAverageScore) {
                result += 5;
                five++;
                quantity++;
                current = result / quantity;
            }
        }
        return five;

    }



    public void Buttons(){

        if (editTextdbl1.getText().toString().isEmpty() || editTextdbl2.getText().toString().isEmpty() || editTextint.getText().toString().isEmpty() || Double.parseDouble(editTextdbl1.getText().toString()) == 0 || Double.parseDouble(editTextdbl2.getText().toString()) == 0 || Integer.parseInt(editTextint.getText().toString())==0){
            Toast.makeText(getActivity(), "Введите все значения", Toast.LENGTH_SHORT).show();
        } else {
            double NewAverageScore = Double.parseDouble(editTextdbl1.getText().toString());
            double CurrentAverageScore = Double.parseDouble(editTextdbl2.getText().toString());
            int quantity = Integer.parseInt(editTextint.getText().toString());
            double result = quantity*CurrentAverageScore;
            int result2 = Answer(quantity, NewAverageScore, result);
            Log.d("RRR",result2+"");
            orderViewModel.set_avgscore(result2);
            Navigation.findNavController(requireView()).navigate(R.id.action_averageScore_to_scoreAnswer);
        }
    }
}