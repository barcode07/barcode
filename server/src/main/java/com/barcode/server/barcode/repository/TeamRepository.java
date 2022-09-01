package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.Team;
import com.barcode.server.barcode.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee

/**
 * PackageName : com.barcode.server.barcode.repository
 * FileName : TeamRepository
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

public interface TeamRepository extends JpaRepository<Team,Long> {
<<<<<<< HEAD
    List<Team> findAllByUser(User user);
=======
    List<Team> findAllByUserId(User user);
>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
}
