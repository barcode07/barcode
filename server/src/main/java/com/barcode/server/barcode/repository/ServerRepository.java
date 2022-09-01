package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.Server;
import com.barcode.server.barcode.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PackageName : com.barcode.server.barcode.repository
 * FileName : ServerRepository
 * Author : 이 수 경
 * Date : 2022-08-19
 * Description :
 */

public interface ServerRepository extends JpaRepository<Server,Long> {

}
