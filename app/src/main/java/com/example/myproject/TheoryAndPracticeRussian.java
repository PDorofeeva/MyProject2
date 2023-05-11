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

import com.example.myproject.databinding.FragmentElementarySchoolRussianBinding;
import com.example.myproject.databinding.FragmentTheoryAndPracticeRussianBinding;
import com.example.myproject.databinding.TheoryandpracticeBinding;
import com.example.myproject.model.OrderViewModel;

import java.util.Random;

public class TheoryAndPracticeRussian extends Fragment {

    public FragmentTheoryAndPracticeRussianBinding binding;

    private OrderViewModel orderViewModelPr;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public TheoryAndPracticeRussian() {
        // Required empty public constructor

    }


    public static TheoryAndPracticeRussian newInstance(String param1, String param2) {
        TheoryAndPracticeRussian fragment = new TheoryAndPracticeRussian();
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
        binding = FragmentTheoryAndPracticeRussianBinding.inflate(inflater, container, false);
        orderViewModelPr = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnPractice.setOnClickListener(view1 -> goToNextScreen());
        binding.theoryAndPracticeBack.setOnClickListener(view2 -> goToBackScreen());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    String[] arr = {"З москва", "З казань", "З мария", "З ольга", "З волга", "З день рождения", "З новый год", "М девочка", "М игрушка", "М русский язык", "М декабрь", "М школа", "М море", "М математика", "М озеро", "З франция", "М телевизор", "З алексей", "М картина", "Мотец", "Мсова", "ЗКанада", "Зсказка о царе Салтане", "Мблины", "Мщётка", "Знижний новгород", "Звладимир", "Мтелефон", "Ммедведь", "Здень города", "Зроссия", "Мдневник", "Мэстофета", "Змальдивы", "Змихаил", "Мсоревнования", "Млитература", "Змосква-река", "Зпланета сатурн"};
    Random yuy = new Random();
    int i = yuy.nextInt(arr.length);

    public void goToNextScreen() {
        orderViewModelPr.set_number1(i);
        orderViewModelPr.set_stroke(arr[i].substring(1));
        Log.d("TXTB", "" + i + " " + arr[i]);
        //Log.d("PPP", "! ВЫВОДИТСЯ: " + f.substring(1) + " ИСТИННАЯ СТРОКА " + arrel);
        Navigation.findNavController(requireView()).navigate(R.id.action_theoryAndPracticeRussian_to_russianPractice);
    }
    public void goToBackScreen() {
        Navigation.findNavController(requireView()).navigate(R.id.action_theoryAndPracticeRussian_to_orphograms);
    }

}