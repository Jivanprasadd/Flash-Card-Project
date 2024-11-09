package com.jivan.flash_card_endsem_eval;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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

        // Set visibility based on flip status
        if (flashcard.isFlipped()) {
            holder.questionTextView.setVisibility(View.GONE);
            holder.answerTextView.setVisibility(View.VISIBLE);
            holder.answerTextView.setText(flashcard.getAnswer());
        } else {
            holder.questionTextView.setVisibility(View.VISIBLE);
            holder.answerTextView.setVisibility(View.GONE);
            holder.questionTextView.setText(flashcard.getQuestion());
        }

        // Toggle flip status on click and update UI
        holder.itemView.setOnClickListener(v -> {
            flashcard.flip();
            notifyItemChanged(position);
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

    static class FlashcardViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView, answerTextView;

        FlashcardViewHolder(View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            answerTextView = itemView.findViewById(R.id.answerTextView);
        }
    }
}
