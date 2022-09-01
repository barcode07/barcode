package com.barcode.server.barcode.dao;

import com.barcode.server.barcode.dto.enumClass.ChannelGroupTypeEnum;
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
@Table(name="channel_group")
@DynamicUpdate
@DynamicInsert
public class ChannelGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="SERVER_ID")
    private Server server;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ChannelGroupTypeEnum type = ChannelGroupTypeEnum.TEXT;

    @OneToMany(mappedBy = "channelGroups")
    @Builder.Default
    private List<TextChannel> textChannels = new ArrayList<>();

    @OneToMany(mappedBy = "channelGroups")
    @Builder.Default
    private List<VoiceChannel> voiceChannels = new ArrayList<>();

}
