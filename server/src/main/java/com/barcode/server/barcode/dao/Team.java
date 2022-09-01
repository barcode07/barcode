package com.barcode.server.barcode.dao;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * PackageName : com.barcode.server.barcode.dao
 * FileName : Team
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name="team")
@DynamicUpdate
@DynamicInsert
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
<<<<<<< HEAD
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Server_ID")
    private Server server;
=======
    private User userId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Server_ID")
    private Server serverId;
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
}
