package com.barcode.server.barcode.service;

import com.barcode.server.barcode.repository.ServerRepository;
import com.barcode.server.barcode.repository.TeamRepository;
import com.barcode.server.barcode.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * PackageName : com.barcode.server.barcode.service
 * FileName : TeamService
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */
@Service
public class TeamService {

    private TeamRepository teamRepository;
    private UserRepository userRepository;
    private ServerRepository serverRepository;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository, ServerRepository serverRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.serverRepository = serverRepository;
    }

}
