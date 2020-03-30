package com.example.collections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.UserAuthListener, LoginFragment.SignupListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.replace(R.id.fragmentContainer, loginFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onLoginSuccessful() {
        Intent intent = new Intent(this, UserAcivity.class);
        startActivity(intent);
    }

    @Override
    public void onSignupClickSuccess() {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        SignupFragment signupFragment = new SignupFragment();
        ft.replace(R.id.fragmentContainer, signupFragment);
        ft.commit();
    }
}
