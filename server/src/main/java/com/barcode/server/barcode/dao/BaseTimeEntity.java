package com.barcode.server.barcode.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : BaseTimeEntity
 * Author : 이 수 경
 * Date : 2022-04-29
 * Description :
 */
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
@Embeddable
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
public class BaseTimeEntity {

    @Column(name="create_at", nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name="updated_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updateddAt;

    @Column(name="deleted_at", nullable = true, columnDefinition = "DATETIME DEFAULT NULL")
    private LocalDateTime deletedAt;
}
