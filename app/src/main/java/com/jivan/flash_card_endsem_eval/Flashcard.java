package com.jivan.flash_card_endsem_eval;

import java.io.Serializable;

public class Flashcard implements Serializable {
    private String question;
    private String answer;
    private boolean isFlipped;  // To track if the card is flipped

    // Constructor
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isFlipped = false; // Initially, the card is not flipped
    }

    // Getters and Setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    // Toggle the flipped state (flip the card)
    public void flip() {
        this.isFlipped = !this.isFlipped;
    }
}
