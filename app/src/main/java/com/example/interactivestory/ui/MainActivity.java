package com.example.interactivestory.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    String name;
    Button startYourAdventure;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startYourAdventure = findViewById(R.id.start_your_adventure);
        username = findViewById(R.id.username);


        startYourAdventure.setOnClickListener(view -> {
            name = username.getText().toString();
            if(name.isEmpty()){
                Toast.makeText(this , "Enter your name" , Toast.LENGTH_SHORT).show();
            }else {
                startStory();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        username.setText("");
    }

    public void startStory(){
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resource = getResources();
        String key = resource.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);
    }
}