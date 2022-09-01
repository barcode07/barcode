package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * PackageName : com.barcode.server.barcode.repository
 * FileName : ServerRepository
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

public interface ServerRepository extends JpaRepository<Server,Long> {
    Optional<Server> findById(Long id);

}
