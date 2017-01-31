package net.toregard.persistence;

import net.toregard.entities.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile({"in-memory", "mysql", "postgres", "oracle"})
public interface  AccountRepository extends JpaRepository<Account, String> {
    public Account findByUsername(String username);
}
