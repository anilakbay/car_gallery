package com.anilakbay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anilakbay.model.Address;

@Repository
public interface AdressRepository extends JpaRepository<Address, Long> {
}
