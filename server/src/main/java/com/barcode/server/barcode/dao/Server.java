package com.barcode.server.barcode.dao;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : com.barcode.server.barcode.dao
 * FileName : Server
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name="server")
@DynamicUpdate
@DynamicInsert
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
<<<<<<< HEAD
=======
    private Long adminId;

    @Column
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
    private String imgUrl;

    @Column
    private String inviteCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
<<<<<<< HEAD
    private User user;

    @OneToMany(mappedBy = "server", fetch=FetchType.LAZY)
    @Builder.Default
    private List<ChannelGroup> channelGroups = new ArrayList<>();

    @OneToMany(mappedBy = "server", fetch=FetchType.LAZY)
=======
    private User userId;

    @OneToMany(mappedBy = "serverId", fetch=FetchType.LAZY)
    @Builder.Default
    private List<UserGroup> userGroup = new ArrayList<>();

    @OneToMany(mappedBy = "serverId", fetch=FetchType.LAZY)
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
    @Builder.Default
    private List<Team> team = new ArrayList<>();


}
