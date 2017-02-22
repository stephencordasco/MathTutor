package com.example.stephencordasco.mathtutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.Toast;

public class PracticeSetUpActivity extends AppCompatActivity {

    Spinner mathSpinner;
    Spinner diffSpinner;
    ArrayAdapter<CharSequence> mathAdapter;
    ArrayAdapter<CharSequence> diffAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_set_up);

        // Initialize Spinner objects
        mathSpinner = (Spinner) findViewById(R.id.math_type_spinner);
        diffSpinner = (Spinner) findViewById(R.id.difficulty_spinner);

        // Initialize the adapters
        mathAdapter = ArrayAdapter.createFromResource(this,
                R.array.math_types, android.R.layout.simple_spinner_item);
        diffAdapter = ArrayAdapter.createFromResource(this,
                R.array.difficulty_types, android.R.layout.simple_spinner_item);

        // Set the drop down view for the adapter and add the adapter to the spinner
        mathAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mathSpinner.setAdapter(mathAdapter);

        diffAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diffSpinner.setAdapter(diffAdapter);

        mathSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) +
                        " selected", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Define a reference to the begin practice button
        Button beginPractice = (Button) findViewById(R.id.begin_practice_btn);

        beginPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to begin the practice activity
                Intent beginIntent = new Intent(PracticeSetUpActivity.this, Practice.class);
                startActivity(beginIntent);
            }
        });
    }
}
