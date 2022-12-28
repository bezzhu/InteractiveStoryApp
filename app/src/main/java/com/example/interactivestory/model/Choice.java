package com.example.interactivestory.model;

public class Choice {
    private int choiceText;
    private int nextPage;

    public Choice(int choiceText, int nextPage) {
        this.choiceText = choiceText;
        this.nextPage = nextPage;
    }

    public int getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(int choiceText) {
        this.choiceText = choiceText;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
