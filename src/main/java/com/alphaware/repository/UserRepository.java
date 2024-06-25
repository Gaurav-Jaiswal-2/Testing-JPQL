package com.alphaware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alphaware.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	  @Query("SELECT u FROM Users u JOIN u.profile p WHERE " +
	           "(:filter IS NULL OR " +
	           "LOWER(p.firstname) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
	           "LOWER(p.middlename) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
	           "LOWER(p.lastname) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
	           "LOWER(u.gender) = LOWER(:filter) OR " +
	           "LOWER(u.status) = LOWER(:filter))")
	    List<Users> findByFilter(@Param("filter") String filter);
}
