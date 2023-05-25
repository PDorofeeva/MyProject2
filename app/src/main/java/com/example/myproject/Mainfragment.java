package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myproject.databinding.FragmentMainfragmentBinding;
import com.example.myproject.databinding.FragmentMathTestResultBinding;
import com.example.myproject.model.OrderViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Mainfragment extends Fragment implements AdapterView.OnItemSelectedListener {//implements View.OnClickListener
    private ArrayAdapter<CharSequence> adapter;
    private OrderViewModel orderViewModelPr;
    public FragmentMainfragmentBinding binding;
    private ImageView profileimage;

    private FirebaseAuth auth;
    private DatabaseReference dataBase;
    public Mainfragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             //ShowImg();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainfragment, container, false);
        Spinner spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(requireActivity().getApplicationContext(), R.array.grades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        orderViewModelPr = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        binding = FragmentMainfragmentBinding.inflate(inflater, container, false);
        //binding.setViewModelPr(orderViewModelPr);
        //binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    public void Buttons(int number){
        if(number == 1){
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_elementaryschoolmath);
            // here
        } else if (number == 2) {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_elementarySchoolRussian);
        } else if (number == 3) {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_elementarySchoolEnglish);
        } else if (number == 4) {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_elementarySchoolInformatics);
        }else if (number == 5) {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_averageScore);
        } else if (number == 6) {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_historyOfScore);
        } else if (number == 7) {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainfragment_to_logIn);
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileimage = view.findViewById(R.id.profile_image);
        binding.btnMath.setOnClickListener(view1 -> Buttons(1));
        binding.btnRussian.setOnClickListener(view2 -> Buttons(2));
        binding.btnEnglish.setOnClickListener(view3 -> Buttons(3));
        binding.btnInformatics.setOnClickListener(view4 -> Buttons(4));
        binding.btncount.setOnClickListener(view5 -> Buttons(5));
        binding.btnresultcount.setOnClickListener(view6 -> Buttons(6));
        binding.imageButton16.setOnClickListener(view6 -> Buttons(7));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}