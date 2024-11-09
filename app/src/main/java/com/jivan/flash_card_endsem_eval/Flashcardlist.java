package com.jivan.flash_card_endsem_eval;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class Flashcardlist extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FlashcardAdapter flashcardAdapter;
    private ArrayList<Flashcard> flashcards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcardlist);

        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton addButton = findViewById(R.id.addButton);

        flashcards = new ArrayList<>();
        flashcardAdapter = new FlashcardAdapter(flashcards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(flashcardAdapter);

        addButton.setOnClickListener(v -> showAddFlashcardDialog());
    }

    private void showAddFlashcardDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_flashcard, null);
        builder.setView(dialogView);

        EditText questionEditText = dialogView.findViewById(R.id.questionEditText);
        EditText answerEditText = dialogView.findViewById(R.id.answerEditText);

        builder.setTitle("Add New Flashcard")
                .setPositiveButton("Add", (dialog, which) -> {
                    String question = questionEditText.getText().toString().trim();
                    String answer = answerEditText.getText().toString().trim();

                    if (!question.isEmpty() && !answer.isEmpty()) {
                        Flashcard flashcard = new Flashcard(question, answer);
                        flashcardAdapter.addFlashcard(flashcard);
                        Toast.makeText(this, "Flashcard Added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Please enter both question and answer", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
