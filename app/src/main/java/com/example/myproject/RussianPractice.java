package com.example.myproject;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Spannable;
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

import com.example.myproject.databinding.FragmentPractice1Binding;
import com.example.myproject.databinding.FragmentRussianPracticeBinding;
import com.example.myproject.databinding.FragmentTheoryAndPracticeRussianBinding;
import com.example.myproject.model.OrderViewModel;

import java.util.Random;
import java.util.Scanner;

public class RussianPractice extends Fragment {
    public int maxcount = 5;

    public FragmentRussianPracticeBinding fragmentRussianPracticeBinding;
    public FragmentTheoryAndPracticeRussianBinding fragmentTheoryAndPracticeRussianBinding;
    public OrderViewModel orderViewModelPr;

    public ProgressBar progressBar;
    public EditText editTextint2;
    public SpannableStringBuilder builder;
    public TextView textView37, helper;

    public Button button15, button10, btnPractice;
    public TextView textView39;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RussianPractice() {
        // Required empty public constructor
    }

    public static RussianPractice newInstance(String param1, String param2) {
        RussianPractice fragment = new RussianPractice();
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
        fragmentRussianPracticeBinding = FragmentRussianPracticeBinding.inflate(inflater, container, false);
        fragmentTheoryAndPracticeRussianBinding = FragmentTheoryAndPracticeRussianBinding.inflate(inflater, container, false);
        orderViewModelPr = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        fragmentRussianPracticeBinding.setViewModelPr(orderViewModelPr);
        fragmentRussianPracticeBinding.setLifecycleOwner(this);
        return fragmentRussianPracticeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        helper = view.findViewById(R.id.hepler);
        fragmentRussianPracticeBinding.button14.setOnClickListener(view2 ->  goToBackScreen());
        fragmentRussianPracticeBinding.button15.setOnClickListener(view1 -> ForCapitalAndLittleLetter(1));
        fragmentRussianPracticeBinding.button10.setOnClickListener(view1 -> ForCapitalAndLittleLetter(2));
        editTextint2= view.findViewById(R.id.editTextint2);
        textView37 = view.findViewById(R.id.textView37);
        button15 = view.findViewById(R.id.button15);
        button10 = view.findViewById(R.id.button10);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setMax(maxcount);
    }

    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_russianPractice_to_mainfragment);
    }
    int count = 1;
    int right = 0;
    String[] arr = {"Змосква", "Зказань", "Змария", "Зольга", "Зволга", "Здень рождения", "Зновый год", "Мдевочка", "Мигрушка", "Мрусский язык", "Мдекабрь", "Мшкола", "Мморе", "Мматематика", "Мозеро", "Зфранция", "Мтелевизор", "Залексей", "Мкартина", "Мотец", "Мсова", "ЗКанада", "Зсказка о царе Салтане", "Мблины", "Мщётка", "Знижний новгород", "Звладимир", "Мтелефон", "Ммедведь", "Здень города", "Зроссия", "Мдневник", "Мэстофета", "Змальдивы", "Змихаил", "Мсоревнования", "Млитература", "Змосква-река", "Зпланета сатурн", "Марбуз", "Мдоктор", "Зока", "Зкремль"};

    Random yuy = new Random();

    public void ForCapitalAndLittleLetter(int number){
        progressBar.setProgress(count);
        ForCapitalAndLittleLetter2(number);
        String word = arr[yuy.nextInt(arr.length)];
        SpannableString spn =new SpannableString(word);
        spn.setSpan(new ForegroundColorSpan(Color.parseColor("#211400")),
                0,
                1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView37.setText(spn);

        //Log.d("PPP", "Count" + count);
        /*if (count == 1){

            String answer = String.valueOf(a.charAt(0));
            String c = String.valueOf(f.charAt(0));
            if(answer.equals(c)){
                right++;
                count++;
                Log.d("PPP", "Right: " + a + "First letter from a: " + answer + "First letter from arr[i]: " + c);
            } else{ count++; }
        } else {

         */

        //}
    }

    public void ForCapitalAndLittleLetter2(int number){
        String answer = "";
        if(count<=maxcount) {
            if (count == 1) {
                String word = arr[Integer.parseInt(helper.getText().toString())];
                String wordFirstLetter = String.valueOf(word.charAt(0)); //Получение элемента
                String g = textView37.getText().toString();
                if (number == 1) {
                    answer = button15.getText().toString();
                }
                if (number == 2) {
                    answer = button10.getText().toString();
                }
                if (wordFirstLetter.equals(String.valueOf(answer.charAt(0)))) {
                    right++;
                }
                Log.d("TXTB", "Right answer: " + right);
            } else {
                String word = textView37.getText().toString();
                String wordFirstLetter = String.valueOf(word.charAt(0));
                if (number == 1) {
                    answer = button15.getText().toString();
                }
                if (number == 2) {
                    answer = button10.getText().toString();
                }
                if (wordFirstLetter.equals(String.valueOf(answer.charAt(0)))) {
                    right++;
                }
                Log.d("TXTB", "Right answer: " + right);
            }
        }
        if(maxcount == count){
            showMeText();
            orderViewModelPr.set_count(count);
            orderViewModelPr.set_answer(right);
            Navigation.findNavController(requireView()).navigate(R.id.action_russianPractice_to_russianTestResults); }
        count++;














        /*String answer = "";
        String f = arr[i];
        char c = f.charAt(0);
        String k = String.valueOf(c);
        textView37.setText(f.substring(1));
        if (number == 1) {
            answer = button15.getText().toString();
            Log.d("PPP", "Answer1 " + answer); //M
        } else if (number == 2) {
            answer = button10.getText().toString(); //3
            Log.d("PPP", "Answer2 " + answer);
        }
        if (answer.equals(k)) {
            right++;
            count++;
        } else {
            count++;
        }
        Log.d("PPP", "Count:" + count + "Right:" + right + "CorrectAnswer:" + k);

         */
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}