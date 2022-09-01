package com.barcode.server.barcode.service;

import com.barcode.server.barcode.dao.ChannelGroup;
import com.barcode.server.barcode.dao.Server;
import com.barcode.server.barcode.dto.ChannelGroupDto;
import com.barcode.server.barcode.dto.enumClass.ChannelGroupTypeEnum;
import com.barcode.server.barcode.repository.ChannelGroupRepository;
import com.barcode.server.barcode.repository.ServerRepository;
import com.barcode.server.commonDto.ResponseErrorDto;
import com.barcode.server.commonDto.ResponseStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * PackageName : com.barcode.server.barcode.service
 * FileName : ChannelService
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */
@Service
public class ChannelGroupService {

    private ChannelGroupRepository channelGroupRepository;
    private ServerRepository serverRepository;

    public ChannelGroupService(ChannelGroupRepository channelGroupRepository, ServerRepository serverRepository) {
        this.channelGroupRepository = channelGroupRepository;
        this.serverRepository = serverRepository;
    }

    public ResponseEntity create(ChannelGroupDto channelGroupDto) {
        Optional<Server> server = serverRepository.findById(channelGroupDto.getServerId());

        try {
            channelGroupRepository.save(
                    ChannelGroup.builder()
                    .server(server.get())
                    .name(channelGroupDto.getName())
                    .type(ChannelGroupTypeEnum.valueOf(channelGroupDto.getType())).build());
            return ResponseEntity.ok()
                    .body(new ResponseStatusDto(200,"채널그룹을 생성했습니다."));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ResponseErrorDto(400,"채널그룹 생성중 에러발생: " + e.getMessage()));
        }
    }
}
