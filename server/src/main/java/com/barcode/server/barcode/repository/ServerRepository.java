package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.Server;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

=======
import com.barcode.server.barcode.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
/**
 * PackageName : com.barcode.server.barcode.repository
 * FileName : ServerRepository
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

public interface ServerRepository extends JpaRepository<Server,Long> {
<<<<<<< HEAD
    Optional<Server> findById(Long id);
=======

>>>>>>> 1c7d14314658c1a463824e558e22bced466a0aee
}
