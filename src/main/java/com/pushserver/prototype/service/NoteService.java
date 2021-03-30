package com.pushserver.prototype.service;

import com.pushserver.prototype.dao.NoteDao;
import com.pushserver.prototype.dao.NoteRepository;
import com.pushserver.prototype.model.Note;
import com.pushserver.prototype.model.ResponseMessage;
import com.pushserver.prototype.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public ResponseMessage addUserNote(Note note) throws ExecutionException, InterruptedException {
        return noteRepository.addUserNote(note);
    }

    public List<Note> getUserNotes(User user){
        return noteRepository.getUserNotes(user);
    }

    public ResponseMessage removeNote(Note note){
        return noteRepository.removeNote(note);
    }
}
