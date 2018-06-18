package com.faiyt.blab.configuration;

import com.faiyt.blab.models.Channel;
import com.faiyt.blab.models.Space;
import com.faiyt.blab.models.user.User;
import com.faiyt.blab.models.user.UserProfile;
import com.faiyt.blab.repositories.ChannelRepository;
import com.faiyt.blab.repositories.SpaceRepository;
import com.faiyt.blab.services.user.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private ChannelRepository channelRepository;
    private SpaceRepository spaceRepository;
    private UserService userDao;

    private PasswordEncoder passwordEncoder;
    private Faker faker = new Faker();
    private Random rand = new Random();


    // Reload Data
    private static final boolean FRESHSTART = false;


    @Autowired
    public DatabaseLoader(ChannelRepository channelRepository,
                          SpaceRepository spaceRepository,
                          UserService userDao,
                          PasswordEncoder passwordEncoder
                          ) {

        this.channelRepository = channelRepository;
        this.spaceRepository = spaceRepository;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(ApplicationArguments args)  {
        if(FRESHSTART) {


            // Deletes existing records
            cleanDB();

            //How many users to create
            Integer usersToCreate = 10;
            // Average number of spaces per user
            Integer avgSpacesPerUser = 5;

            Integer avgChannelsPerSpace = 5;

            // Test Data for fake accounts
            String testUserName = "test";
            String testPassword = "test";


            // START DATA GENERATION (USERS)
            for (int i = 0; i < usersToCreate; i++) {
                User user = createUser(testUserName + i, testPassword);

                for(int j = 0; j < avgSpacesPerUser; j++) {
                    Space space = createSpace(user);
                    for(int k = 0; k <avgChannelsPerSpace; k++) {
                        Channel channel = createChannel(space);
                    } // END CHANNELS
                } // ENDS SPACES
            } // END USERS
        } // FRESH START
    }



    private void cleanDB() {
        userDao.getUsers().deleteAll();
    }

    private User createUser(String username, String password) {

        // delete if exists...old test data.
        Faker faker = new Faker();

        User user = new User(username, password, LocalDateTime.now(), LocalDateTime.now());
        String hash = passwordEncoder.encode(password);
        user.setPassword(hash);
        user.setCreatedAt(LocalDateTime.now());
        user.setProfile(new UserProfile(faker.name().fullName(),  faker.name().firstName(),
                faker.name().lastName(),  faker.internet().emailAddress(), faker.name().username()));

        user = userDao.getUsers().save(user);
        userDao.getUsers().addDefaultRole(user.getId());

        return user;
    }


    private Space createSpace(User user) {
        Space space = new Space(faker.superhero().name(), user);
        this.spaceRepository.save(space);
        return space;
    }

    private Channel createChannel(Space space) {
        Channel channel = new Channel(faker.zelda().character(), faker.superhero().descriptor(), space);
        this.channelRepository.save(channel);
        return channel;
    }







}
