package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

import kotlinx.coroutines.scheduling.NanoTimeSource;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mainfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mainfragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayAdapter<CharSequence> adapter;
    private ImageButton btnMath;
    public Mainfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mainfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Mainfragment newInstance(String param1, String param2) {
        Mainfragment fragment = new Mainfragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainfragment, container, false);
        btnMath = view.findViewById(R.id.btnMath);
        btnMath.setOnClickListener(this);
        Bundle bundle = new Bundle(); //воспользоваться бандлом
        /*bundle.putString("amount", amount); Передача данных
        Navigation.findNavController(view).navigate(R.id.confirmationAction, bundle);
        Navigation.findNavController(view).navigate(R.id.action_mainfragment_to_elementaryschoolmath);
        TextView tv = view.findViewById(R.id.textViewAmount);// think about it
        tv.setText(getArguments().getString("amount"));
        return view;
         */

        btnMath = view.findViewById(R.id.btnMath);
        btnMath.setOnClickListener(this);
        Spinner spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.grades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnMath){
            //Переключение на фрагмент
        } //(new elementaryschoolmath());
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void init(){ // Создание NavController
        NavController navController = Navigation.findNavController(/*????*/, R.id.nav_host_fragment); // не принимает mainfragment
    }
}