package com.example.greetyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView greet;
    EditText user_field;
    Button greet_button;
    Calendar calendar;
    Date date;
    int timeOfDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"WELCOME SANDHYA (1947139)",Toast.LENGTH_LONG).show();


        final ImageView imageView= (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.hi);

        greet = (TextView)findViewById(R.id.greeting_text);
        user_field = (EditText)findViewById(R.id.name_field);
        greet_button = (Button)findViewById(R.id.greeting_button);

        greet_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name = user_field.getText().toString();

                date = new Date();
                calendar = Calendar.getInstance();
                calendar.setTime(date);
                timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

                if(timeOfDay >= 0 && timeOfDay < 12){
                    greet.setText("Good Morning "+name);
                    imageView.setImageResource(R.drawable.morning);

                }else if(timeOfDay >= 12 && timeOfDay < 16){
                    greet.setText("Good Afternoon "+name);
                    imageView.setImageResource(R.drawable.afternoon);
                }else if(timeOfDay >= 16 && timeOfDay < 21){
                    greet.setText("Good Evening "+name);
                    imageView.setImageResource(R.drawable.evening);
                }else if(timeOfDay >= 21 && timeOfDay < 24){
                    greet.setText("Good Night "+name);
                    imageView.setImageResource(R.drawable.night);
                }
            }
        });
    }
}