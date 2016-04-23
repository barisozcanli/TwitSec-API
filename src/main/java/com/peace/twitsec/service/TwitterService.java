package com.peace.twitsec.service;

import com.peace.twitsec.data.mongo.model.Follower;
import com.peace.twitsec.data.mongo.model.User;

import java.util.List;

public interface TwitterService {

    List<Long> getFollowerIds(User user);

    void tweet(User user, String message);

    void sendDirectMessage(User user, long userId, String message);

    void sendDirectMessage(User user, List<Follower> userIdList, String message);

    List<twitter4j.User> getUserProfiles(User user, List<Follower> userList);
}
