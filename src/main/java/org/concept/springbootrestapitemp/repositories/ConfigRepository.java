package org.concept.springbootrestapitemp.repositories;

import org.concept.springbootrestapitemp.models.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
}
