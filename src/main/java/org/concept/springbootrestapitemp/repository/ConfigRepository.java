package org.concept.springbootrestapitemp.repository;

import org.concept.springbootrestapitemp.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
}
