package com.example.myapp.datasource;

import com.example.myapp.domain.model.UserComment;
import com.example.myapp.application.dto.UserCommentDto;
import com.example.myapp.domain.model.UserCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    private final UserCommentMapper mapper;

    @Override
    public void save(UserComment userComment) {
        mapper.insert(UserCommentDto.from(userComment));
    }
}