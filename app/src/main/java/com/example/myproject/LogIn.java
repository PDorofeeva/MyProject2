package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentLogInBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogIn extends Fragment {

    private FragmentLogInBinding logInBinding;

    private EditText username;
    private EditText email;

    private String USER_KEY = "User";
    private DatabaseReference dataBase;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LogIn() {
        // Required empty public constructor
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

        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        dataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
        //logInBinding.login.setOnClickListener(view2 -> onClickSave());
        logInBinding.login.setOnClickListener(v -> {
            String id = dataBase.getKey();
            String name = username.getText().toString();
            String useremail = email.getText().toString();
            if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(useremail)) {
                UserInfo User = new UserInfo(id, name, useremail);
                dataBase.push().setValue(User);
                Navigation.findNavController(requireView()).navigate(R.id.action_logIn_to_mainfragment);
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(getActivity(), "Заполните необходимые поля", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment_mainfragment, container, false);
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false);
        return logInBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logInBinding = null;
    }
}