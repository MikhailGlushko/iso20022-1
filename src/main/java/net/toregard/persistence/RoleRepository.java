package net.toregard.persistence;

import net.toregard.entities.Role;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

//@Profile({"in-memory", "mysql", "postgres", "oracle"})
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
