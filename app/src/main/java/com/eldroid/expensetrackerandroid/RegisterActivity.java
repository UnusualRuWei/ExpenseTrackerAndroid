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

public class RegisterActivity extends AppCompatActivity {

    private TextView existingaccounttextView;
    private Button registeraccountbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        existingaccounttextView = findViewById(R.id.existingaccounttextview);
        registeraccountbutton = findViewById(R.id. registeraccountbutton);

        String text = "Already Have An Account?";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        existingaccounttextView.setText(spannableString);

        existingaccounttextView.setOnClickListener( v -> {
            Intent toLogin = new Intent(this, LoginActivity.class);
            startActivity(toLogin);
        });

        registeraccountbutton.setOnClickListener( v ->{
            Intent toVerify = new Intent(this, VerifyEmailActivity.class);
            startActivity(toVerify);
        });
    }
}