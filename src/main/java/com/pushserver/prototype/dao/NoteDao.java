package com.pushserver.prototype.dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Write;
import com.pushserver.prototype.model.Note;
import com.pushserver.prototype.model.ResponseMessage;
import com.pushserver.prototype.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class NoteDao implements NoteRepository{

    @Override
    public ResponseMessage addUserNote(Note note) throws ExecutionException, InterruptedException {
        note.setId(getAllNotes().size()+1);

        try{
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("api/v1/notes")
                    .document(note.getId().toString()).set(note);
            return new ResponseMessage(200,"Successfully add a note!");
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(400,"Failed to add a note");
        }
    }

    @Override
    public List<Note> getUserNotes(User user) {
        List<Note> noteList = new ArrayList<Note>();
        try{
            Firestore dbFirestore = FirestoreClient.getFirestore();
            CollectionReference notes = dbFirestore.collection("api/v1/notes");
            Query query = notes.whereEqualTo("user_id",user.getUser_id());
            ApiFuture<QuerySnapshot> querySnapshot = query.get();

            for(DocumentSnapshot document : querySnapshot.get().getDocuments()){
                if(Integer.valueOf(document.get("user_id").toString())==user.getUser_id()){
                    noteList.add(document.toObject(Note.class));
                }
            }
            return noteList;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return noteList;
        }
    }

    @Override
    public ResponseMessage removeNote(Note note) {
        try{
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> writeResult = dbFirestore.collection("api/v1/notes")
                    .document(note.getId().toString()).delete();
            return new ResponseMessage(200, "Note successfully removed");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(400,"Failed to remove note");
        }
    }

    @Override
    public List<Note> getAllNotes() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference notes = dbFirestore.collection("api/v1/notes");
        Query query = notes.whereGreaterThan("id",0);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<Note> noteList = new ArrayList<Note>();
        for(DocumentSnapshot document : querySnapshot.get().getDocuments()){
            noteList.add(document.toObject(Note.class));
        }
        return noteList;
    }
}
