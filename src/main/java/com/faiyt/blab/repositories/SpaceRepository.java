package com.faiyt.blab.repositories;

import com.faiyt.blab.models.Space;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpaceRepository extends CrudRepository<Space, Long> {
}
