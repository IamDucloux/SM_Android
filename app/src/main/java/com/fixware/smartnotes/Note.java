package com.fixware.smartnotes;

public class Note {

    private String title;
    private String content;
    //private String topic;
    private String description;
    private int img_note;


    public Note() {

    }

    public Note(String title, String content, String description, int img_note) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.img_note = img_note;
    }

    public Note(String title, String description, int img_note) {
        this.title = title;
        this.description = description;
        this.img_note = img_note;
    }

    public int getImg_note() {
        return img_note;
    }

    public void setImg_note(int img_note) {
        this.img_note = img_note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
