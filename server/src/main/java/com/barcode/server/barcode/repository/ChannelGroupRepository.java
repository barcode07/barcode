package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.ChannelGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PackageName : com.barcode.server.barcode.repository
 * FileName : ChannelGroupRepository
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */

public interface ChannelGroupRepository extends  JpaRepository<ChannelGroup,Long> {
}
