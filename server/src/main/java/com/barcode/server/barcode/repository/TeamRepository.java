package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.Team;
import com.barcode.server.barcode.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * PackageName : com.barcode.server.barcode.repository
 * FileName : TeamRepository
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

public interface TeamRepository extends JpaRepository<Team,Long> {
    List<Team> findAllByUserId(User user);
}
