package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myproject.databinding.FragmentMainfragmentBinding;
import com.example.myproject.model.OrderViewModel;

import java.util.Objects;

public class Mainfragment extends Fragment implements AdapterView.OnItemSelectedListener {//implements View.OnClickListener
    private ArrayAdapter<CharSequence> adapter;
    private FragmentMainfragmentBinding fragmentMainfragmentBinding;


    public Mainfragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainfragment, container, false);
        fragmentMainfragmentBinding = FragmentMainfragmentBinding.inflate(inflater, container, false);
        Spinner spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(requireActivity().getApplicationContext(), R.array.grades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        OrderViewModel orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        return fragmentMainfragmentBinding.getRoot();
    }

    /*@Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnMath){
            //Переключение на фрагмент
        } //(new ElementarySchoolMath());
    }
     */
    public void Buttons(int number){ //This method must do smth
        if(number == 1){
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_elementaryschoolmath);
        } else if (number == 5) {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_averageScore);

        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentMainfragmentBinding.btnMath.setOnClickListener(view1 -> Buttons(1));
        fragmentMainfragmentBinding.btnRussian.setOnClickListener(view2 -> Buttons(0));
        fragmentMainfragmentBinding.btnEnglish.setOnClickListener(view3 -> Buttons(0));
        fragmentMainfragmentBinding.btnInformatics.setOnClickListener(view4 -> Buttons(0));
        fragmentMainfragmentBinding.btncount.setOnClickListener(view5 -> Buttons(5));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentMainfragmentBinding = null;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void init(){ // Создание NavController
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
    }
}