package com.crns.huileolive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.crns.huileolive.entities.Moulinage;

public interface MoulinageRepository extends JpaRepository<Moulinage, Long> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "delete from moulinage where id = :id")
	public void deleteMoulinageById(@Param("id") Long id);
}
