package com.pushserver.prototype.controller;

import com.pushserver.prototype.model.Note;
import com.pushserver.prototype.model.ResponseMessage;
import com.pushserver.prototype.model.User;
import com.pushserver.prototype.service.NoteService;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin("*")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("api/v1/getNotes")
    public List<Note> getUserNotes(@RequestBody User user){
        return noteService.getUserNotes(user);
    }

    @PostMapping("api/v1/addNote")
    public ResponseMessage addUserNote(@RequestBody Note note) throws ExecutionException, InterruptedException {
        return noteService.addUserNote(note);
    }
}
