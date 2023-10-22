package com.illhab.illhabServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_user")
@Entity
public class User extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<UserProject> userProjects = new ArrayList<>();

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 15)
    @Setter
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SNS_ROLE sns_role;

    @Builder
    public User(String email, String name, String sns_role) {
        this.email = email;
        this.name = name;

        //sns_role은 string으로 받고 여기서 변환
        switch (sns_role){
            case "google":
                this.sns_role = SNS_ROLE.GOOGLE;
                break;
            case "kakao":
                this.sns_role = SNS_ROLE.KAKAO;
                break;
            case "github":
                this.sns_role = SNS_ROLE.GITHUB;
                break;
            default:
                this.sns_role = SNS_ROLE.NONE;
                break;
        }
    }

    public void changeName(String name){
        //setter 지양을 위해 해당 메서드를 만들었습니다.
        //이름을 바꾸는 용도로 사용하는 메서드입니다.
        this.name = name;
    }
}

