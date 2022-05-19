package com.mju.mobile.Repository;

import com.mju.mobile.Model.Auth.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth, String> {
    public Optional<Auth> findById (@Param("id") String id);
}
