package com.example.socket_chat_app.controller;

import com.example.socket_chat_app.model.ActiveUser;
import com.example.socket_chat_app.model.Storage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:63342")
public class UserController {

    @GetMapping("/active")
    public List<ActiveUser> list() {
        return Storage.activeUserList;
    }
}
