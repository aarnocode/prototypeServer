package com.pushserver.prototype.dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.pushserver.prototype.model.ResponseMessage;
import com.pushserver.prototype.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Repository
public class UserDao implements UserRepository{

    @Override
    public ResponseMessage registerUser(User user) throws ExecutionException, InterruptedException {
        user.setUser_id(getAllUser().size()+1);
        if(validateEmail(user.getEmail())){
            try{
                Firestore dbFirestore = FirestoreClient.getFirestore();
                ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("api/v1/users")
                        .document(user.getUser_id().toString()).set(user);
                return new ResponseMessage(200,"Successfully Registered!");
            }catch(Exception e){
                System.out.println(e.getMessage());
                return new ResponseMessage(400,"Failed to register");
            }
        }else{
            return new ResponseMessage(400,"Email already exists");
        }

    }

    public User userLogin(User user){
        try{
            Firestore dbFirestore = FirestoreClient.getFirestore();
            CollectionReference users = dbFirestore.collection("api/v1/users");
            Query email = users.whereEqualTo("email",user.getEmail());
            ApiFuture<QuerySnapshot> querySnapshot = email.get();
            for(DocumentSnapshot document : querySnapshot.get().getDocuments()){
                if(document.get("email").equals(user.getEmail())){
                    if(document.get("password").equals(user.getPassword())){
                        return new User(Integer.valueOf(document.get("user_id").toString()),
                                        document.get("first_name").toString(),
                                        document.get("last_name").toString(),
                                        document.get("email").toString());
                    }else{
                        return new User();
                    }
                }
            }
            return new User();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new User();
        }
    }

    @Override
    public List<User> getAllUser() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference employees = dbFirestore.collection("api/v1/users");
        Query query = employees.whereGreaterThan("user_id",0);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<User> userList = new ArrayList<User>();
        for(DocumentSnapshot document : querySnapshot.get().getDocuments()){
            userList.add(document.toObject(User.class));
        }
        return userList;
    }

    public boolean validateEmail(String email) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference users = dbFirestore.collection("api/v1/users");
        Query query = users.whereEqualTo("email",email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        for(DocumentSnapshot document : querySnapshot.get().getDocuments()){
            if(document.get("email").equals(email)){
                return false;
            }
        }
        return true;
    }
}
