package com.example.myproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentLogInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends Fragment {
    private ConstraintLayout container1, container2;
    private ImageButton imgbtn10, imgbtn11;
    private Button btnIn, btnUp;
    private TextView AccEmail, lettersEmail, lettersAcc, txtBack, authoriztxt, logOutxt;
    private EditText passwordtxt;

    private FragmentLogInBinding logInBinding;

    private FirebaseAuth auth;
    private EditText EmailText, password;

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
    public void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if(user != null){
            /*
            imgbtn10.setVisibility(View.VISIBLE);
            txtBack.setVisibility(View.VISIBLE);
            lettersAcc.setVisibility(View.VISIBLE);
            lettersEmail.setVisibility(View.VISIBLE);
            lettersAcc.setVisibility(View.VISIBLE);
            AccEmail.setVisibility(View.VISIBLE);
            btnIn.setVisibility(View.GONE);
            btnUp.setVisibility(View.GONE);
            authoriztxt.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            EmailText.setVisibility(View.GONE);
             */
            container1.setVisibility(View.GONE);
            container2.setVisibility(View.VISIBLE);
            String txt = user.getEmail();
            AccEmail.setText(txt);
        } else{
            container2.setVisibility(View.GONE);
            container1.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "Пожалуйста, авторизуйтесь", Toast.LENGTH_SHORT).show();
            //Navigation.findNavController(requireView()).navigate(R.id.action_logIn_to_mainfragment);
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //first group
        container1 = view.findViewById(R.id.container2);
        authoriztxt = view.findViewById(R.id.textView51);
        btnUp = view.findViewById(R.id.registration);
        btnIn = view.findViewById(R.id.authorization);
        password = view.findViewById(R.id.password);
        EmailText = view.findViewById(R.id.TextEmail);
        //second group
        container2 = view.findViewById(R.id.container3);
        imgbtn11 = view.findViewById(R.id.imageButton11);
        imgbtn10 = view.findViewById(R.id.imageButton10);
        logOutxt = view.findViewById(R.id.textView52);
        AccEmail = view.findViewById(R.id.textView55);
        lettersEmail = view.findViewById(R.id.textView53);
        lettersAcc = view.findViewById(R.id.textView48);
        txtBack = view.findViewById(R.id.textView50);

        auth = FirebaseAuth.getInstance();
        logInBinding.imageButton10.setOnClickListener(view1 -> GoToBackScreen());
        logInBinding.registration.setOnClickListener(v -> {
            if(TextUtils.isEmpty(EmailText.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(getActivity(), "Заполните необходимые поля", Toast.LENGTH_SHORT).show();
            } else {
                auth.createUserWithEmailAndPassword(EmailText.getText().toString(), password.getText().toString()).addOnCompleteListener(task -> {
                    if ((task.isSuccessful())) {
                        Navigation.findNavController(requireView()).navigate(R.id.action_logIn_to_mainfragment);
                        Toast.makeText(getActivity(), "Упешная регистрация", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Пользователь уже существует", Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });
        logInBinding.authorization.setOnClickListener(v -> {
            if(TextUtils.isEmpty(EmailText.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(getActivity(), "Заполните необходимые поля", Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(EmailText.getText().toString(), password.getText().toString()).addOnCompleteListener(task -> {
                    if ((task.isSuccessful())) {
                        Navigation.findNavController(requireView()).navigate(R.id.action_logIn_to_mainfragment);
                        Toast.makeText(getActivity(), "Успешная авторизация", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Неверные данные", Toast.LENGTH_SHORT).show();
                    }

                });
            }

        });
        logInBinding.imageButton11.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            container2.setVisibility(View.GONE);
            container1.setVisibility(View.VISIBLE);
            //VisibilityOfRegistrAndAuth();
            Toast.makeText(getActivity(), "Вы вышли из аккаунта", Toast.LENGTH_SHORT).show();
        });
}
/*
public void VisibilityOfRegistrAndAuth(){
    imgbtn11.setVisibility(View.GONE);
    imgbtn10.setVisibility(View.GONE);
    txtBack.setVisibility(View.GONE);
    lettersAcc.setVisibility(View.GONE);
    lettersEmail.setVisibility(View.GONE);
    lettersAcc.setVisibility(View.GONE);
    logOutxt.setVisibility(View.GONE);
    AccEmail.setVisibility(View.GONE);
    btnIn.setVisibility(View.VISIBLE);
    btnUp.setVisibility(View.VISIBLE);
    authoriztxt.setVisibility(View.VISIBLE);
    password.setVisibility(View.VISIBLE);
    EmailText.setVisibility(View.VISIBLE);
}

        username = view.findViewById(R.id.username);
        phone = view.findViewById(R.id.phone);

        dataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
        String id = dataBase.getKey();
        logInBinding.re
        //logInBinding.login.setOnClickListener(view2 -> onClickSave());
        logInBinding.login.setOnClickListener(v -> {
            String name = username.getText().toString();
            String telephone = phone.getText().toString();
            String logInWord = password.getText().toString();
            dataBase.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(telephone)) {
                        Toast.makeText(getActivity(), "Учётная запись уже существует", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(telephone) || !TextUtils.isEmpty(logInWord)) {
                            UserInfo User = new UserInfo(id, name, telephone, logInWord);
                            dataBase.push().setValue(User);
                            Navigation.findNavController(requireView()).navigate(R.id.action_logIn_to_mainfragment);
                            Toast.makeText(getActivity(), "Учётная запись сохранена", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Заполните необходимые поля", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        });

 */


    public void GoToBackScreen(){
        Navigation.findNavController(requireView()).navigate(R.id.action_logIn_to_mainfragment);
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
