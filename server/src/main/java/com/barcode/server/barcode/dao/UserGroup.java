package com.barcode.server.barcode.dao;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : com.barcode.server.barcode.dao
 * FileName : Group
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name="user_group")
@DynamicUpdate
@DynamicInsert
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="SERVER_ID")
    private Server serverId;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany(mappedBy = "userGroupId")
    @Builder.Default
    private List<TextChannel> textChannels = new ArrayList<>();

}
