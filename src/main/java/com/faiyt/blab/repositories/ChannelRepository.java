package com.faiyt.blab.repositories;

import com.faiyt.blab.models.Channel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CrudRepository<Channel, Long> {
}
