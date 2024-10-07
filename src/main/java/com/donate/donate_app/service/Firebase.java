package com.donate.donate_app.service;


import com.donate.donate_app.entity.Users;
import com.donate.donate_app.repository.UsersRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Firebase {
    @Autowired
    UsersRepository usersRepository;

    public Users createFirebaseUsers(String name , String email, String password){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            //Criar um mapping
            Users users = new Users();
            users.setEmail(userRecord.getEmail());
            users.setName(name);
            users.setAuth_id(userRecord.getUid());
            System.out.println("Usuário criado com sucesso: " + userRecord);
            return users;
        } catch (Exception e) {
            System.out.println("Erro ao criar usuário: " + e.getMessage());
            return null;
        }
    }

    public void verifyFirebaseToken(String token) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
    }
}
