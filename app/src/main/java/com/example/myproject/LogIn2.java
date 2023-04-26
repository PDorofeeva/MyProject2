/*package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myproject.databinding.FragmentLogIn2Binding;
import com.example.myproject.databinding.FragmentLogInBinding;

public class LogIn2 extends Fragment {
    //private  FirebaseAuth

    private EditText EmailText, PasswordText;
    private FragmentLogIn2Binding logIn2Binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LogIn2() {
        // Required empty public constructor
    }


    public static LogIn2 newInstance(String param1, String param2) {
        LogIn2 fragment = new LogIn2();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EmailText = view.findViewById(R.id.TextEmail);
        PasswordText = view.findViewById(R.id.password);
        logIn2Binding.registration.setOnClickListener(view1 -> Registration());
        logIn2Binding.authorization.setOnClickListener(view2 -> Authorization());
    }
    public void Registration(){

    }
    public void  Authorization(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        logIn2Binding = FragmentLogIn2Binding.inflate(inflater, container, false);
        return logIn2Binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logIn2Binding = null;
    }

}

 */