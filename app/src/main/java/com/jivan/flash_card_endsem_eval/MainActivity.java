package com.jivan.flash_card_endsem_eval;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnFlashcardList;
    private Button btnSlideshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFlashcardList = findViewById(R.id.viewListButton);
        btnSlideshow = findViewById(R.id.viewSlideshowButton);

        btnFlashcardList.setOnClickListener(v -> {
            // Navigate to FlashcardListActivity (RecyclerView activity)
            Intent intent = new Intent(MainActivity.this, Flashcardlist.class);
            startActivity(intent);
        });

        btnSlideshow.setOnClickListener(v -> {
            // Navigate to SlideshowActivity
            Intent intent = new Intent(MainActivity.this, SlideshowActivity.class);
            startActivity(intent);
        });
    }
}
