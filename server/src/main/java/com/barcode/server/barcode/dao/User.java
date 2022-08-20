package com.barcode.server.barcode.dao;

import com.barcode.server.barcode.dto.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : User
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name="user")
@DynamicUpdate
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column()
    private String password;

    @Column(unique = true, length = 30)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.ROLE_USER;

    @Column(name = "access_yn", insertable = false, nullable = false, columnDefinition = "tinyint(1) default 1")
    @Builder.Default
    private Boolean accessYn = true;

    @Column(name = "isConnected", insertable = false, nullable = false, columnDefinition = "tinyint(1) default 1")
    @Builder.Default
    private Boolean isConnected = false;

    @Embedded
    private BaseTimeEntity baseTimeEntity;

    @OneToMany(mappedBy = "userId", fetch=FetchType.LAZY)
    @Builder.Default
    private List<Server> server = new ArrayList<>();

    @OneToMany(mappedBy = "userId", fetch=FetchType.LAZY)
    @Builder.Default
    private List<Team> team = new ArrayList<>();

}

