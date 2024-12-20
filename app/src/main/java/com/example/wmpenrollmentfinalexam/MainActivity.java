package com.example.wmpenrollmentfinalexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbPancasila, cbIndonesian, cbReligion, cbCitizenship, cbEnglish, cbWebProgramming, cbEconomicSurvival;
    private TextView tvTotalCredits;
    private Button btnSubmit;

    private int totalCredits = 0;
    private final int MAX_CREDITS = 24;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbPancasila = findViewById(R.id.cbPancasila);
        cbIndonesian = findViewById(R.id.cbIndonesian);
        cbReligion = findViewById(R.id.cbReligion);
        cbCitizenship = findViewById(R.id.cbCitizenship);
        cbEnglish = findViewById(R.id.cbEnglish);
        cbWebProgramming = findViewById(R.id.cbWebProgramming);
        cbEconomicSurvival = findViewById(R.id.cbEconomicSurvival);

        tvTotalCredits = findViewById(R.id.tvTotalCredits);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set listeners for checkboxes
        setCheckboxListeners();

        // Submit button click
        btnSubmit.setOnClickListener(view -> {
            if (totalCredits > MAX_CREDITS) {
                Toast.makeText(getApplicationContext(), "You cannot select more than 24 credits.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Subjects submitted successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCheckboxListeners() {
        cbPancasila.setOnCheckedChangeListener((buttonView, isChecked) -> updateCredits(isChecked, 5));
        cbIndonesian.setOnCheckedChangeListener((buttonView, isChecked) -> updateCredits(isChecked, 3));
        cbReligion.setOnCheckedChangeListener((buttonView, isChecked) -> updateCredits(isChecked, 4));
        cbCitizenship.setOnCheckedChangeListener((buttonView, isChecked) -> updateCredits(isChecked, 6));
        cbEnglish.setOnCheckedChangeListener((buttonView, isChecked) -> updateCredits(isChecked, 0));
        cbWebProgramming.setOnCheckedChangeListener((buttonView, isChecked) -> updateCredits(isChecked, 6));
        cbEconomicSurvival.setOnCheckedChangeListener((buttonView, isChecked) -> updateCredits(isChecked, 6));
    }

    private void updateCredits(boolean isChecked, int credits) {
        if (isChecked) {
            totalCredits += credits;
        } else {
            totalCredits -= credits;
        }
        tvTotalCredits.setText("Total Credits: " + totalCredits);
    }
}
