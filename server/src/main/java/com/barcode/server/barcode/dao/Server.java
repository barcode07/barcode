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
    private String imgUrl;

    @Column
    private String inviteCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(mappedBy = "server", fetch=FetchType.LAZY)
    @Builder.Default
    private List<ChannelGroup> channelGroups = new ArrayList<>();

    @OneToMany(mappedBy = "server", fetch=FetchType.LAZY)
    @Builder.Default
    private List<Team> team = new ArrayList<>();


}
