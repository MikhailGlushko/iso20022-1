package net.toregard.persistence;

import net.toregard.entities.Routes;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile({"in-memory", "mysql", "postgres", "oracle"})
public interface RoutesRepository  extends JpaRepository<Routes, Long> {
}
