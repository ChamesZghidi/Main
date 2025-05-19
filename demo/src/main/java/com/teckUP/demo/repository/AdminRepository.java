package com.teckUP.demo.repository;

import com.teckUP.demo.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin ,Integer> {

    Admin findByNom(String adminname);
}
