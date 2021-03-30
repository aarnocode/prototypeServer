package com.pushserver.prototype.dao;

import com.pushserver.prototype.model.Note;
import com.pushserver.prototype.model.ResponseMessage;
import com.pushserver.prototype.model.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface NoteRepository {
    ResponseMessage addUserNote(Note note) throws ExecutionException, InterruptedException;
    List<Note> getUserNotes(User user);
    List<Note> getAllNotes() throws ExecutionException, InterruptedException;
    ResponseMessage removeNote(Note note);
}
