package com.example.myapp.infrastructure.datasource;

import com.example.myapp.application.dto.UserCommentDto;
import com.example.myapp.application.dto.UserCommentReadDto;
import com.example.myapp.domain.model.UserComment;
import com.example.myapp.domain.model.UserCommentRepository;
import com.example.myapp.domain.model.UserComments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    private final UserCommentMapper mapper;

    @Override
    public void save(UserComment userComment) {

    }

    @Override
    public void save(UserCommentDto dto) {
        mapper.insert(dto);
    }

    @Override
    public UserComments select() {
        List<UserCommentReadDto> dtos = mapper.select();
        return UserComments.from(
                dtos.stream().map( dto -> UserComments.UserComment.from(
                        dto.getId(),
                        dto.getName(),
                        dto.getMailAddress(),
                        dto.getComment(),
                        dto.getCreatedAt()
                )).collect(Collectors.toUnmodifiableList())
        );
    }
}