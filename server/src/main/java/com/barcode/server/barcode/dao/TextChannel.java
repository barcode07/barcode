package com.barcode.server.barcode.dao;

<<<<<<< HEAD
=======
import com.barcode.server.barcode.dao.UserGroup;
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
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
<<<<<<< HEAD
    @JoinColumn(name="CHANNEL_GROUP_ID")
    private ChannelGroup channelGroups;
=======
    @JoinColumn(name="USER_GROUP_ID")
    private UserGroup userGroupId;
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee

    @Column
    private String name;
}
