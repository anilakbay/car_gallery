package com.anilakbay.repository;

import com.anilakbay.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
    @Override
    Optional<RefreshToken> findById(Long aLong);

    List<RefreshToken> findByRefreshToken(String refreshToken);
}
