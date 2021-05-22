package com.example.myapp.domain.model;

import com.example.myapp.application.dto.UserCommentDto;

public interface UserCommentRepository {
    void save(UserComment dto);

    void save(UserCommentDto dto); //これないとエラー出る

    UserComments select();
}