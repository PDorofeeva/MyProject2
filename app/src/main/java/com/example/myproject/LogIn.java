package com.example.myproject;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.databinding.FragmentLogInBinding;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

public class LogIn extends Fragment {
    private DatabaseReference dataBase;
    private ConstraintLayout container1, container2;
    private ImageView img;
    private int PICK_IMAGE_REQUEST = 71;
    private StorageReference storageReference;
    private TextView AccEmail;
    private Uri upuri;
    private FragmentLogInBinding logInBinding;

    private FirebaseAuth auth;
    private EditText EmailText, password;

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
            container1.setVisibility(View.GONE);
            container2.setVisibility(View.VISIBLE);
            String txt = user.getEmail();
            AccEmail.setText(txt);
        } else{
            container2.setVisibility(View.GONE);
            container1.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "Пожалуйста, авторизуйтесь", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        storageReference = FirebaseStorage.getInstance().getReference("ProfileImages");
        logInBinding.exit.setOnClickListener(view1 -> GoToBackScreen());
        logInBinding.button23.setOnClickListener(view1 -> SaveImg());
        logInBinding.choosing.setOnClickListener(view2 -> ProfilePhoto());
        //first group
        container1 = view.findViewById(R.id.container2);
        password = view.findViewById(R.id.password);
        EmailText = view.findViewById(R.id.TextEmail);
        //second group
        container2 = view.findViewById(R.id.container3);
        AccEmail = view.findViewById(R.id.textView55);
        img = view.findViewById(R.id.profile_image);

        auth = FirebaseAuth.getInstance();
        logInBinding.imageButton10.setOnClickListener(view1 -> GoToBackScreen());
        logInBinding.registration.setOnClickListener(v -> {
            if (TextUtils.isEmpty(EmailText.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
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
            if (TextUtils.isEmpty(EmailText.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
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
            Toast.makeText(getActivity(), "Вы вышли из аккаунта", Toast.LENGTH_SHORT).show();
        });
    }

    public void ProfilePhoto(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

    }


    private void ImageUpload(){
        Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        byte[] barr = outputStream.toByteArray();
        final StorageReference ref = storageReference.child("ProfileImages/");
        UploadTask l = ref.putBytes(barr);
        Task<Uri> task = l.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                return ref.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                upuri = task.getResult();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null){
            if(resultCode == RESULT_OK){
                img.setImageURI(data.getData());
                ImageUpload();
            }
        }
    }

    public void  SaveImg(){
        if(auth.getUid() != null && upuri != null){
            //dataBase = FirebaseDatabase.getInstance().getReference("UsersProfileImages/");
            UserInfo forImg = new UserInfo(upuri.toString(), auth.getUid());
            dataBase = FirebaseDatabase.getInstance().getReference("UsersProfileImages/"+ auth.getUid());
            dataBase.removeValue();
            dataBase.push().setValue(forImg).addOnSuccessListener(unused -> Log.d("TTT", "Works")).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("TTT", e.toString());
                }
            });
            Toast.makeText(getActivity(), "Успешно", Toast.LENGTH_SHORT).show();
            ShowImage();
        }
    }

    public void ShowImage(){
        Picasso.get().load(upuri).into(img);
    }

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
