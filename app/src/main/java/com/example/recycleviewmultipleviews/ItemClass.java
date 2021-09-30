package com.example.recycleviewmultipleviews;

// ItemClass

import java.net.URL;

public class ItemClass {

    // Integers assigned to each layout
    // these are declared static so that they can
    // be accessed from the class name itself
    // And final so that they are not modified later
    public static final int LayoutOne = 0;
    public static final int LayoutTwo = 1;
    public static final int LayoutThree = 2;
    public static final int LayoutFour = 3;

    // This variable ViewType specifies
    // which out of the two layouts
    // is expected in the given item
    private int viewType;

    // String variable to hold the TextView
    // of the first item.
    private String text;

    public ItemClass(int viewType, String text)
    {
        this.text = text;
        this.viewType = viewType;
    }

    // public constructor for the first layout
    public ItemClass(int viewType,  int delete, String text)
    {
        this.text = text;
        this.delete = delete;
        this.viewType = viewType;
    }

    // getter and setter methods for the text variable

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    // Variables for the item of second layout
    private int icon;
    private int delete;
    private String text_one, text_two;
    private URL image;

    // public constructor for the second layout
    public ItemClass(int viewType, int icon, int delete,String text_one,
                     String text_two)
    {
        this.icon = icon;
        this.delete = delete;
        this.text_one = text_one;
        this.text_two = text_two;
        this.viewType = viewType;
    }

    // getter and setter methods for
    // the variables of the second layout

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public int geticon() { return icon; }

    public void seticon(int icon) { this.icon = icon; }

    public int getdelete() { return delete; }

    public void setdelete(int delete) { this.delete = icon; }

    public String getText_one() { return text_one; }

    public void setText_one(String text_one)
    {
        this.text_one = text_one;
    }

    public String getText_two() { return text_two; }

    public void setText_two(String text_two)
    {
        this.text_two = text_two;
    }

    public int getViewType() { return viewType; }

    public void setViewType(int viewType)
    {
        this.viewType = viewType;
    }

    public ItemClass(int viewType, URL image, String text_one)
    {
        this.image = image;
        this.text_one = text_one;
        this.viewType = viewType;
    }
}
