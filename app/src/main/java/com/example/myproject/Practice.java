package com.example.myproject;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentPractice1Binding;
import com.example.myproject.model.OrderViewModel;

import java.util.Random;
import java.util.Scanner;

public class Practice extends Fragment {
    public int maxcount = 5;

    public FragmentPractice1Binding fragmentPracticeBinding;
    public OrderViewModel orderViewModelPr;

    public ProgressBar progressBar;
    public EditText editTextint2;

    public TextView textView37, textView39, helper37, helper39;

    public Button button15;
    public Practice() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentPracticeBinding = FragmentPractice1Binding.inflate(inflater, container, false);
        orderViewModelPr = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentPracticeBinding.setViewModelPr(orderViewModelPr);
        fragmentPracticeBinding.setLifecycleOwner(this);
        return fragmentPracticeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentPracticeBinding.button14.setOnClickListener(view2 ->  goToBackScreen());
        fragmentPracticeBinding.button15.setOnClickListener(view1 -> ForNumbersAddition());
        fragmentPracticeBinding.button10.setOnClickListener(view1 -> ForLastNumbers());
        editTextint2= view.findViewById(R.id.editTextint2);
        textView37 = view.findViewById(R.id.textView37);
        textView39 = view.findViewById(R.id.textView39);
        helper37 = view.findViewById(R.id.helper37);
        helper39 = view.findViewById(R.id.helper39);
        button15 = view.findViewById(R.id.button15);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setMax(maxcount);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentPracticeBinding = null;
    }
    int count = 1;
    int right = 0;



    public void ForNumbersAddition(){
        progressBar.setProgress(count);
        if (editTextint2.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Введите ответ", Toast.LENGTH_SHORT).show();
        } else if ( editTextint2.getText().toString().equals("-")) {
            editTextint2.getText().clear();
            Random yuy = new Random();
            String number1 = Integer.toString(yuy.nextInt(100));
            String number2 = Integer.toString(yuy.nextInt(100));
            textView37.setText(number1);
            textView39.setText(number2);
            if(count == maxcount)
            {
                showMeText();
                orderViewModelPr.set_answer(right);
                orderViewModelPr.set_count(count);
                Navigation.findNavController(requireView()).navigate(R.id.action_newfragment_to_mathTestResult);
            }
            count++;
        } else{
            ForNumbersAddition2();
            editTextint2.getText().clear();
            Random yuy = new Random();
            String number1 = Integer.toString(yuy.nextInt(100));
            String number2 = Integer.toString(yuy.nextInt(100));
            textView37.setText(number1);
            textView39.setText(number2);
        }
    }
    public void ForNumbersAddition2(){
        int answer = Integer.parseInt(editTextint2.getText().toString());
        if(count <= maxcount){
            int one = Integer.parseInt((String) textView37.getText());
            int two = Integer.parseInt((String) textView39.getText());
            orderViewModelPr.set_number1last(String.valueOf(one));
            orderViewModelPr.set_number2last(String.valueOf(two));
            if (one + two == answer) {
                right++;
            }
        }
        if (count == maxcount)
        {
            showMeText();
            orderViewModelPr.set_answer(right);
            orderViewModelPr.set_count(count);
            Navigation.findNavController(requireView()).navigate(R.id.action_newfragment_to_mathTestResult);
        }
        count++;
    }

    public void ForLastNumbers(){
        count--;
        textView37.setText(helper37.getText().toString());
        textView39.setText(helper39.getText().toString());
    }


    public void showMeText(){
        if (right <maxcount-2){
            orderViewModelPr.set_stroke("Возможно стоит повторить теорию?");
        } else if (right == maxcount-2 || right == maxcount-1) {
            orderViewModelPr.set_stroke("Ещё немного и победа!");
        } else{
            orderViewModelPr.set_stroke("Хорошая работа! Материал усвоен!");
        }
    }

    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_newfragment_to_mainfragment);
    }
}