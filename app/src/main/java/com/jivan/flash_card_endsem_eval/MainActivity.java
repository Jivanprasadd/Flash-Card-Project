package com.jivan.flash_card_endsem_eval;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnFlashcardList;
    private Button btnSlideshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFlashcardList = findViewById(R.id.viewListButton);
        btnSlideshow = findViewById(R.id.viewSlideshowButton);

        // Set up random flashcards
        ArrayList<Flashcard> flashcards = generateRandomFlashcards();

        btnFlashcardList.setOnClickListener(v -> {
            // Pass random flashcards to FlashcardListActivity
            Intent intent = new Intent(MainActivity.this, Flashcardlist.class);
            intent.putExtra("flashcards", flashcards);
            startActivity(intent);
        });

        btnSlideshow.setOnClickListener(v -> {
            // Pass random flashcards to SlideshowActivity
            Intent intent = new Intent(MainActivity.this, SliderFlashcard.class);
            intent.putExtra("flashcards", flashcards); // Pass the list to the next activity
            startActivity(intent);
        });
    }

    // Method to generate random flashcards
    private ArrayList<Flashcard> generateRandomFlashcards() {
        ArrayList<Flashcard> flashcards = new ArrayList<>();
        Random random = new Random();

        String[] questions = {
                "What is the capital of France?",
                "What is 5 + 3?",
                "Who developed the theory of relativity?",
                "What is the largest planet in our solar system?",
                "What is the atomic number of oxygen?"
        };

        String[] answers = {
                "Paris",
                "8",
                "Albert Einstein",
                "Jupiter",
                "8"
        };

        for (int i = 0; i < 5; i++) {
            String question = questions[random.nextInt(questions.length)];
            String answer = answers[random.nextInt(answers.length)];
            flashcards.add(new Flashcard(question, answer));
        }

        return flashcards;
    }
}
