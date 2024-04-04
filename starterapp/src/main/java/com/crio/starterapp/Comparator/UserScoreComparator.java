package com.crio.starterapp.Comparator;

import com.crio.starterapp.Entity.User;
import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;

public class UserScoreComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getScore() - user2.getScore();
    }
}
