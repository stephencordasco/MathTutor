package com.example.stephencordasco.mathtutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class Practice extends AppCompatActivity {

    // References to Strings storing data passed from previous activity
    String math_selection;
    String diff_selection;

    // Reference to EditText
    EditText checkText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        // Receive the string names that are passed from the spinners in PracticeSetUpActivity
        Bundle extras = getIntent().getExtras();
        Bundle extras2 = getIntent().getExtras();
        // Store the data in the String
        math_selection = extras.getString("SpinnerValue");
        diff_selection = extras2.getString("SpinnerValue2");

        // Set the listener and Intent for the Home button
        Button home = (Button) findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intentHome = new Intent(Practice.this, MainActivity.class);
                startActivity(intentHome);
            }
        });
    }

    // A set of globals used to generate and calculate a sum
    int number1 = 0;
    int number2 = 0;

    // Method for the Generate button: generates random numbers
    public void generate(View view) {
        Random rand = new Random();

        // Conditions based off the difficulty selection by the user
        if (diff_selection.equals("Beginner")) {
            number1 = rand.nextInt(9) + 1;
            number2 = rand.nextInt(10);
        }
        else if (diff_selection.equals("Intermediate")) {
            number1 = rand.nextInt(50) + 1;
            number2 = rand.nextInt(51);
        }
        else {
            number1 = rand.nextInt(100) + 1;
            number2 = rand.nextInt(101);
        }

        // For the equation
        TextView firstNumText = (TextView) findViewById(R.id.firstDigitTextView);
        String firstNumStr = String.valueOf(number1);
        firstNumText.setText(firstNumStr);

        TextView secondNumText = (TextView) findViewById(R.id.secondDigitTextView);
        String secondNumStr = String.valueOf(number2);
        secondNumText.setText(secondNumStr);
    }

    // Method for the Check button: checks if the user entered the correct answer or not
    public void calculate(View view) {
        int total = number1 + number2;

        checkText = (EditText) findViewById(R.id.editText);
        int userAnswer = Integer.parseInt(checkText.getText().toString());

        if (total == userAnswer)
        {
            generate(view);
        }
    }
}
