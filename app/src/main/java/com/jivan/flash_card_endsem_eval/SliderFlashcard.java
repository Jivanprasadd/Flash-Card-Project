package com.jivan.flash_card_endsem_eval;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;

public class SliderFlashcard extends AppCompatActivity {

    private ViewPager2 viewPager;
    private SliderFlashcardAdapter sliderFlashcardAdapter;
    private ArrayList<Flashcard> flashcards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider);  // Set your layout file here

        // Initialize the viewPager and adapter
        ArrayList<Flashcard> flashcards = (ArrayList<Flashcard>) getIntent().getSerializableExtra("flashcards");
        viewPager = findViewById(R.id.viewPager);
        sliderFlashcardAdapter = new SliderFlashcardAdapter(flashcards);
        viewPager.setAdapter(sliderFlashcardAdapter);

        // Set up left and right arrows
        ImageView leftArrow = findViewById(R.id.leftArrow);
        ImageView rightArrow = findViewById(R.id.rightArrow);

        leftArrow.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() > 0) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1); // Go to the previous flashcard
            }
        });

        rightArrow.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() < flashcards.size() - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1); // Go to the next flashcard
            }
        });
    }
}
