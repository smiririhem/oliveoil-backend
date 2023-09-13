package com.crns.huileolive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crns.huileolive.entities.Lotolive;

public interface LotoliveRepository extends JpaRepository<Lotolive, Long> {

	public List<Lotolive> findByIdIn(List<Long> ids);
}
