package com.barcode.server.barcode.repository;

import com.barcode.server.barcode.dao.VoiceChannel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PackageName : com.barcode.server.barcode.repository
 * FileName : VoiceChannelRepository
 * Author : 이 수 경
 * Date : 2022-08-21
 * Description :
 */

public interface VoiceChannelRepository extends JpaRepository<VoiceChannel,Long> {

}
