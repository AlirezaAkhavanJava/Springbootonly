package com.me.persistance;

import com.me.domain.AccountOwner;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)

public interface AccountOwnerRepository extends JpaRepository<AccountOwner, Long> {

    @Query("SELECT a FROM AccountOwner a WHERE a.username = :identifier OR a.email = :identifier")
    Optional<AccountOwner> findAccountOwnerByUsernameOrEmail(@Param("identifier") String identifier);

    boolean existsAccountOwnerByUsername(String username);

}
