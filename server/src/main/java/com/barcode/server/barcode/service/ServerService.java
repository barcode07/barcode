package com.barcode.server.barcode.service;

import com.barcode.server.barcode.dao.Server;
import com.barcode.server.barcode.dao.Team;
import com.barcode.server.barcode.dao.User;
import com.barcode.server.barcode.dto.ServerDto;
import com.barcode.server.barcode.repository.ServerRepository;
import com.barcode.server.barcode.repository.TeamRepository;
import com.barcode.server.barcode.repository.UserRepository;
import com.barcode.server.commonDto.ResponseDataDto;
import com.barcode.server.commonDto.ResponseErrorDto;
import com.barcode.server.commonDto.ResponseErrorsDto;
import com.barcode.server.commonDto.ResponseStatusDto;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * PackageName : com.barcode.server.barcode.service
 * FileName : ServerService
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

@Service
public class ServerService {

    private ServerRepository serverRepository;
    private UserRepository userRepository;
    private TeamRepository teamRepository;

    public ServerService(ServerRepository serverRepository, UserRepository userRepository, TeamRepository teamRepository) {
        this.serverRepository = serverRepository;
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    public ResponseEntity create(ServerDto serverDto) {
        Optional<User> user = userRepository.findById(serverDto.getUserId());
        if(user==null) {
            return ResponseEntity.badRequest()
                    .body(new ResponseErrorDto(400,"존재하지 않는 유저입니다"));
        }
        Server server = serverRepository.save(Server.builder().name(serverDto.getName()).userId(user.get()).adminId(serverDto.getUserId()).build());
        teamRepository.save(Team.builder().userId(user.get()).serverId(server).build());
        return ResponseEntity.ok()
                .body(new ResponseStatusDto(200,"서버를 생성하였습니다."));
    }
    @Transactional
    public ResponseEntity read(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        List<Team> team = teamRepository.findAllByUserId(user.get());
        HashMap<String, Object> map = new HashMap<>();
        for(Team team1: team) {
            ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
            objectNode.put("name",team1.getServerId().getName()).put("imgUrl",team1.getServerId().getImgUrl());
            map.put(String.valueOf(team1.getServerId().getId()),objectNode);
        }
        return ResponseEntity.ok()
                .body(new ResponseDataDto(200,"서버를 조회하였습니다.",map));
    }

    public ResponseEntity update(ServerDto serverDto) {
        Optional<User> user = userRepository.findById(serverDto.getUserId());
        if(user==null) {
            return ResponseEntity.badRequest()
                    .body(new ResponseErrorDto(400,"존재하지 않는 유저입니다"));
        }
        serverRepository.save(Server.builder().name(serverDto.getName()).userId(user.get()).adminId(serverDto.getUserId()).build());
        return ResponseEntity.ok()
                .body(new ResponseStatusDto(200,"서버를 생성하였습니다."));
    }
    public ResponseEntity delete(Long serverId) {
        serverRepository.deleteById(serverId);
        return ResponseEntity.ok()
                .body(new ResponseStatusDto(200,"서버를 삭제하였습니다."));
    }
}
