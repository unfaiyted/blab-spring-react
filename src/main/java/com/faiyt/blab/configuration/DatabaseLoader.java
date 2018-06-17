package com.faiyt.blab.configuration;

import com.faiyt.blab.models.Channel;
import com.faiyt.blab.models.Space;
import com.faiyt.blab.repositories.ChannelRepository;
import com.faiyt.blab.repositories.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final SpaceRepository spaceRepository;

    @Autowired
    public DatabaseLoader(ChannelRepository channelRepository, SpaceRepository spaceRepository) {
        this.channelRepository = channelRepository;
        this.spaceRepository = spaceRepository;
    }


    @Override
    public void run(String... strings) throws Exception {
        Space space = this.spaceRepository.save(new Space("test space") );
        this.channelRepository.save(new Channel("name","first", space));
    }




}
