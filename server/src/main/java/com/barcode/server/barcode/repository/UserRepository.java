package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * PackageName : com.example.ssssksss_blog.blog.repository
 * FileName : UserRepository
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description : @Repository를 넣을 필요 없다, JpaRepository를 상속받으면서 처리된다.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
//    Boolean existsByUuid(String uuid);
    Optional<User> findByEmail(String email);
}
