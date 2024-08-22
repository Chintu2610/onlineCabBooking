package com.cab.Repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cab.Model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	boolean existsByEmail(String email);
	
}

