package com.example.myapp.domain.model;

import com.example.myapp.domain.type.Comment;
import com.example.myapp.domain.type.MailAddress;
import com.example.myapp.domain.type.Name;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.util.Random;
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserComment {
    private final Name name;
    private final UserId userId;
    private final MailAddress mailAddress;
    private final Comment comment;

    /**
     * 名前が[!omikuji]ならばおみくじの結果を返す.
     * そうでないならばNameをそのまま返す.
     * @return なまえ
     */
    public Name getName() {
        if(!name.equals("!omikuji")) return name;
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                return Name.from("大吉");
            case 1:
                return Name.from("中吉");
            default:
                return Name.from("小吉");
        }
    }

    public static UserComment from(String name, String userId, String mailAddress, String comment) {
        return new UserComment(
            Name.from(name),
            UserId.from(userId),
            MailAddress.from(mailAddress),
            Comment.from(comment)
        );
    }
}