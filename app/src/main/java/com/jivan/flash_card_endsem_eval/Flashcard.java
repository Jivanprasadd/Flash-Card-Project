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

    public void flip() {
        isFlipped = !isFlipped;
    }
}
