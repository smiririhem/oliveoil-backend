package com.crns.huileolive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crns.huileolive.entities.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
