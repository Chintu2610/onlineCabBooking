package com.cab.Repositary;

import com.cab.Model.Subscription;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	boolean existsByEmail(String email);
}