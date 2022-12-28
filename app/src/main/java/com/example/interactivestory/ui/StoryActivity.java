package com.example.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.interactivestory.R;
import com.example.interactivestory.model.Page;
import com.example.interactivestory.model.Story;
import java.util.Stack;

public class StoryActivity extends AppCompatActivity {
    private String name;
    private Story story;
    private ImageView storyImage;
    private TextView storyText;
    private Button choice1;
    private Button choice2;
    private Page page;
    private final Stack<Integer> pageStack = new Stack<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImage = findViewById(R.id.storyImage);
        storyText = findViewById(R.id.storyText);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);

        Intent intent = getIntent();
        String key = getString(R.string.key_name);
        name = intent.getStringExtra(key);
        setTitle("Rocket captain: "+name);
        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        page = story.getPage(pageNumber);
        pageStack.push(pageNumber);
        Drawable image = ContextCompat.getDrawable(this, page.getPageImage());
        storyImage.setImageDrawable(image);

        String text = getString(page.getPageText());
        text = String.format(text , name);
        storyText.setText(text);

        if(page.isFinalPage()){
            choice1.setVisibility(View.INVISIBLE);
            choice2.setText(R.string.play_again_button_text);
            choice2.setOnClickListener(view -> finish());
        }else {
            loadChoiceButton(page);
        }
    }

    private void loadChoiceButton(Page page) {
        choice1.setText(page.getChoice1().getChoiceText());
        choice1.setOnClickListener(view -> {
            int nextPage = page.getChoice1().getNextPage();
            loadPage(nextPage);
        });
        choice2.setText(page.getChoice2().getChoiceText());
        choice2.setOnClickListener(view -> {
            int nextPage = page.getChoice2().getNextPage();
            loadPage(nextPage);
        });

    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if(pageStack.isEmpty()){
            super.onBackPressed();
        }else {
            loadPage(pageStack.pop());
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if(page.isFinalPage()){
            menu.add(R.string.play_again_button_text);
        }else {
            menu.add(page.getChoice1().getChoiceText());
            menu.add(page.getChoice2().getChoiceText());
        }
        return true;
    }
}