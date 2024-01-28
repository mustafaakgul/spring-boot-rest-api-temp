package org.concept.springbootrestapitemp.repositories;

import org.concept.springbootrestapitemp.models.Config;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends CrudRepository<Config, Long> {
}
