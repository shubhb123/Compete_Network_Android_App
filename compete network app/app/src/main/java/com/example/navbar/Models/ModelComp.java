package com.example.navbar.Models;

public class ModelComp {
    int pic;
    String text, text1;
    public ModelComp(int pic, String text, String text1) {
        this.pic = pic;
        this.text = text;
        this.text1 = text1;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
}
