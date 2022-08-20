package com.barcode.server.barcode.dao;

import com.barcode.server.barcode.dao.UserGroup;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * PackageName : com.barcode.server.barcode.dao.Channel
 * FileName : TextChannel
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name="text_channel")
@DynamicUpdate
@DynamicInsert
public class TextChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_GROUP_ID")
    private UserGroup userGroupId;

    @Column
    private String name;
}
