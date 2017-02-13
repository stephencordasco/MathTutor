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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

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
        number1 = rand.nextInt(9) + 1;
        number2 = rand.nextInt(10);

        TextView firstNumText = (TextView) findViewById(R.id.numTextView1);
        String firstNumStr = String.valueOf(number1);
        firstNumText.setText(firstNumStr);

        TextView secondNumText = (TextView) findViewById(R.id.numTextView2);
        String secondNumStr = String.valueOf(number2);
        secondNumText.setText(secondNumStr);

        Button checkButton = (Button) findViewById(R.id.checkBtn);
        checkButton.setText("Check");
    }

    // Method for the Check button: checks if the user entered the correct answer or not
    public void calculate(View view) {
        int total = number1 + number2;

        Button checkButton = (Button) findViewById(R.id.checkBtn);
        EditText checkText = (EditText) findViewById(R.id.editText);
        int userAnswer = Integer.parseInt(checkText.getText().toString());

        if (total == userAnswer)
        {
            generate(view);
        }
        else
        {
            checkButton.setText("Incorrect.");
        }
    }
}
