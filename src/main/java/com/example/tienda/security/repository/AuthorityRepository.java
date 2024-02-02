package com.example.tienda.security.repository;

import com.example.tienda.security.entity.Authority;
import com.example.tienda.security.entity.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Authority findByName(AuthorityName authorityName);
}
