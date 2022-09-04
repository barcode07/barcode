package com.barcode.server.barcode.dao;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
public class TextChannel extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="CHANNEL_GROUP_ID")
    private ChannelGroup channelGroups;

    @Column
    private String name;

    @OneToMany(mappedBy = "textChannel" , cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<TextChannelMessage> messages = new ArrayList<>();
}
