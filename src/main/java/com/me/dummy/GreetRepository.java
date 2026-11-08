package com.me.dummy;

import com.me.AccountOwner;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetRepository extends JpaRepository<@NonNull AccountOwner, @NonNull Long> {
}
