package com.donate.donate_app.service;


import com.donate.donate_app.entity.Users;
import com.donate.donate_app.repository.UsersRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Firebase {
    @Autowired
    UsersRepository usersRepository;

    public void createFirebaseUsers(String email, String password){
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            //Criar um mapping
            Users users = new Users();
            users.setUsername(userRecord.getEmail());
            users.setName("Nome");
            users.setPassword("pass");
            System.out.println("Usuário criado com sucesso: " + userRecord);
            usersRepository.save(users);
        } catch (Exception e) {
            System.out.println("Erro ao criar usuário: " + e.getMessage());
        }
    }
}
