package com.amukelani.hellogroupassessment.models;

/**
 * Created by Amukelani on 9/25/16.
 */
public class ListItems {

    private String title;
    private int num;

    public ListItems() {
    }

    public ListItems(String title, int num) {
        this.title = title;
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
