package com.jivan.flash_card_endsem_eval;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;

public class FlashcardAdapter extends RecyclerView.Adapter<FlashcardAdapter.FlashcardViewHolder> {
    private ArrayList<Flashcard> flashcards;

    public FlashcardAdapter(ArrayList<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    @NonNull
    @Override
    public FlashcardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flashcard, parent, false);
        return new FlashcardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlashcardViewHolder holder, int position) {
        Flashcard flashcard = flashcards.get(position);

        // Set the question or answer visibility based on the flip state
        if (flashcard.isFlipped()) {
            holder.questionTextView.setVisibility(View.GONE);
            holder.answerTextView.setVisibility(View.VISIBLE);
            holder.answerTextView.setText(flashcard.getAnswer());
        } else {
            holder.questionTextView.setVisibility(View.VISIBLE);
            holder.answerTextView.setVisibility(View.GONE);
            holder.questionTextView.setText(flashcard.getQuestion());
        }

        // Handle the click to flip the flashcard
        holder.itemView.setOnClickListener(v -> {
            flashcard.flip();
            notifyItemChanged(position);
        });

        // Show Edit/Delete buttons
        holder.editButton.setVisibility(View.VISIBLE);
        holder.deleteButton.setVisibility(View.VISIBLE);

        // Handle the "Edit" button click
        holder.editButton.setOnClickListener(v -> {
            showEditFlashcardDialog(v, position);
        });

        // Handle the "Delete" button click
        holder.deleteButton.setOnClickListener(v -> {
            deleteFlashcard(position);
        });
    }

    @Override
    public int getItemCount() {
        return flashcards.size();
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
        notifyItemInserted(flashcards.size() - 1);
    }

    public void deleteFlashcard(int position) {
        flashcards.remove(position);
        notifyItemRemoved(position);
    }

    public void editFlashcard(int position, String newQuestion, String newAnswer) {
        // Get the flashcard at the given position
        Flashcard flashcard = flashcards.get(position);

        flashcard.setQuestion(newQuestion);
        flashcard.setAnswer(newAnswer);

        notifyItemChanged(position);
    }


    private void showEditFlashcardDialog(View view, int position) {
        // Get current question and answer
        Flashcard flashcard = flashcards.get(position);
        String currentQuestion = flashcard.getQuestion();
        String currentAnswer = flashcard.getAnswer();

        // Create a dialog to edit the flashcard
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        LayoutInflater inflater = LayoutInflater.from(view.getContext());
        View dialogView = inflater.inflate(R.layout.dialog_add_flashcard, null);
        builder.setView(dialogView);

        EditText questionEditText = dialogView.findViewById(R.id.questionEditText);
        EditText answerEditText = dialogView.findViewById(R.id.answerEditText);

        questionEditText.setText(currentQuestion);
        answerEditText.setText(currentAnswer);

        builder.setTitle("Edit Flashcard")
                .setPositiveButton("Save", (dialog, which) -> {
                    String newQuestion = questionEditText.getText().toString().trim();
                    String newAnswer = answerEditText.getText().toString().trim();

                    if (!newQuestion.isEmpty() && !newAnswer.isEmpty()) {
                        editFlashcard(position, newQuestion, newAnswer);
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        builder.show();
    }

    static class FlashcardViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView, answerTextView;
        Button editButton, deleteButton;

        FlashcardViewHolder(View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            answerTextView = itemView.findViewById(R.id.answerTextView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
