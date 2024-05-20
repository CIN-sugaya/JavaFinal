package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByEmail(String email);
}
