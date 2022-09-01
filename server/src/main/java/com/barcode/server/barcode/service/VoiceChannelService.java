package com.barcode.server.barcode.service;

import com.barcode.server.barcode.dao.ChannelGroup;
import com.barcode.server.barcode.dao.VoiceChannel;
import com.barcode.server.barcode.dto.VoiceChannelDto;
import com.barcode.server.barcode.repository.ChannelGroupRepository;
import com.barcode.server.barcode.repository.VoiceChannelRepository;
import com.barcode.server.commonDto.ResponseDataDto;
import com.barcode.server.commonDto.ResponseStatusDto;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**
 * PackageName : com.barcode.server.barcode.service
 * FileName : VoiceChannelService
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */
@Service
public class VoiceChannelService {

    private VoiceChannelRepository voiceChannelRepository;
    private ChannelGroupRepository channelGroupRepository;

    public VoiceChannelService(VoiceChannelRepository voiceChannelRepository, ChannelGroupRepository channelGroupRepository) {
        this.voiceChannelRepository = voiceChannelRepository;
        this.channelGroupRepository = channelGroupRepository;
    }

    public ResponseEntity create(VoiceChannelDto voiceChannelDto) {
        Optional<ChannelGroup> channelGroup = channelGroupRepository.findById(voiceChannelDto.getChannelGroupId());
        voiceChannelRepository.save(VoiceChannel.builder().channelGroups(channelGroup.get()).name(voiceChannelDto.getName()).build());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"음성 채널 생성 성공"));
    }

    public ResponseEntity read(Long voiceChannelId) {
        Optional<VoiceChannel> voiceChannel = voiceChannelRepository.findById(voiceChannelId);
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        HashMap<String, Object> map = new HashMap<>();
        objectNode.put("channelGroupId",voiceChannel.get().getChannelGroups().getId()).put("name",voiceChannel.get().getName());
        map.put(String.valueOf(voiceChannel.get().getId()),objectNode);
        return ResponseEntity.ok().body(new ResponseDataDto(200,"채팅 채널 조회 성공",map));
    }
}
