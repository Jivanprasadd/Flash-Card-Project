package com.jivan.flash_card_endsem_eval;

public class Flashcard {
    private String question;
    private String answer;
    private boolean isFlipped;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isFlipped = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void flip() {
        isFlipped = !isFlipped;
    }
}
