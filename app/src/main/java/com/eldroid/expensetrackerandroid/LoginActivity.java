package com.eldroid.expensetrackerandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private TextView forgotpasstextView,registeraccounttextView;
    private Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        forgotpasstextView = findViewById(R.id.forgotpasswordtextview);
        registeraccounttextView = findViewById(R.id.createnewaccounttextview);
        loginbutton = findViewById(R.id.loginuserbutton);

        String text = "Forgot Password?";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        forgotpasstextView.setText(spannableString);

        String text2 = "Create new Account";
        SpannableString spannableString2 = new SpannableString(text2);
        spannableString2.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        registeraccounttextView.setText(spannableString2);

        registeraccounttextView.setOnClickListener( v -> {
            Intent toCreateAccount = new Intent(this, RegisterActivity.class);
            startActivity(toCreateAccount);
        });

        forgotpasstextView.setOnClickListener( v -> {
            Intent toForgotPass = new Intent(this, ForgotPasswordActivity.class);
            startActivity(toForgotPass);
        });

        loginbutton.setOnClickListener( v-> {
            Intent toMainScreen = new Intent(this, MainActivity.class);
            startActivity(toMainScreen);
        });

    }
}