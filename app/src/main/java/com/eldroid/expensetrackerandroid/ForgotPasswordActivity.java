package com.eldroid.expensetrackerandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextView goback;
    private Button sendemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sendemail = findViewById(R.id.sendemailforgotpassbutton);
        goback = findViewById(R.id.gobacktextview);

        String text = "Go Back";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        goback.setText(spannableString);

        goback.setOnClickListener( v -> {
            Intent toLogin = new Intent(this, LoginActivity.class);
            startActivity(toLogin);
        });

        sendemail.setOnClickListener( v -> {
            Toast.makeText(this, "Email Sent!", Toast.LENGTH_SHORT).show();
        });


    }
}