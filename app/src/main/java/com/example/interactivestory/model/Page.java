package com.example.interactivestory.model;

public class Page {
    private int pageImage;
    private int pageText;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage = false;


    public Page(int pageImage, int pageText) {
        this.pageImage = pageImage;
        this.pageText = pageText;
        isFinalPage = true;
    }

    public Page(int pageImage, int pageText, Choice choice1, Choice choice2) {
        this.pageImage = pageImage;
        this.pageText = pageText;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }

    public int getPageImage() {
        return pageImage;
    }

    public void setPageImage(int pageImage) {
        this.pageImage = pageImage;
    }

    public int getPageText() {
        return pageText;
    }

    public void setPageText(int pageText) {
        this.pageText = pageText;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }

}
