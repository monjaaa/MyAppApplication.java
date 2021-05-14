package com.example.myapp.application.usecase;

import com.example.myapp.application.form.CommentForm;
import com.example.myapp.domain.model.UserComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommentUseCase {

    /**
     * ユーザの書き込みをDBに反映し、表示するデータをプレゼンテーション層に渡す
     * @param commentForm ユーザの入力データ
     * @return 表示するデータ
     */
    public void write(CommentForm commentForm) {
        // フォームオブジェクトからドメインオブジェクトへ変換
        UserComment userComment = UserComment.from(
                commentForm.getName(),
                commentForm.getMailAddress(),
                commentForm.getComment()
        );

        // 例えばここで、直近の投稿の一覧を取得し、今回と同じ内容の投稿がないかチェックする
    }
}