package com.example.myapp.application.usecase;

import com.example.myapp.application.auth.UserAuthRepository;
import com.example.myapp.application.form.UserForm;
import  lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class UserAuthUsecase {
    private final UserAuthRepository authRepository;

    public void userCreate(UserForm form, HttpServletRequest request) throws ServletException {
        authRepository.createUser(
                form.getUsername(),
                form.getPassword()
        );

        request.login(form.getUsername(), form.getPassword());
    }
}
