package com.barcode.server.barcode.service;

<<<<<<< HEAD
import com.barcode.server.barcode.repository.ServerRepository;
import com.barcode.server.barcode.repository.TeamRepository;
import com.barcode.server.barcode.repository.UserRepository;
=======
import com.barcode.server.barcode.dao.Team;
import com.barcode.server.barcode.dto.TeamDto;
import com.barcode.server.barcode.repository.ServerRepository;
import com.barcode.server.barcode.repository.TeamRepository;
import com.barcode.server.barcode.repository.UserRepository;
import org.springframework.http.ResponseEntity;
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
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
