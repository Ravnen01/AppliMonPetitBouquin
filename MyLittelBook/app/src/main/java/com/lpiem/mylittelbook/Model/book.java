package com.lpiem.mylittelbook.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by iem2 on 02/11/15.
 */
public class Book {

    private String isbn;
    private String title;
    private String authorName;
    private String authorFirstName;
    private double moyenne;
    private String editor;

    public Book(String isbn, String title, String authorName, String authorFirstName, double moyenne, String editor) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.authorFirstName = authorFirstName;
        this.moyenne = moyenne;
        this.editor = editor;
    }

    public Book(JSONObject jsonObject){
        try {
            isbn=jsonObject.getString("ISBN");
            title=jsonObject.getString("Title");
            editor=jsonObject.getString("Editor");
            authorName=jsonObject.getString("Name");
            authorFirstName=jsonObject.getString("Firstname");
            moyenne=jsonObject.getDouble("AVG(C.Rate)");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
}
