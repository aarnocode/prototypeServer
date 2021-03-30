package com.pushserver.prototype.model;

public class Note {
    private Integer id;
    private Integer user_id;
    private String note;

    public Note(Integer id, Integer user_id, String note) {
        this.id = id;
        this.user_id = user_id;
        this.note = note;
    }

    public Note(Integer user_id, String note) {
        this.user_id = user_id;
        this.note = note;
    }

    public Note() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
