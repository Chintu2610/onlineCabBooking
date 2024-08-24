package com.cab.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.Model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
	
}
