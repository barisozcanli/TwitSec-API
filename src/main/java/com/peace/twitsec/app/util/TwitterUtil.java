package com.peace.twitsec.app.util;

import com.peace.twitsec.data.mongo.model.Follower;

import java.util.ArrayList;
import java.util.List;

public class TwitterUtil {

    public static List<Follower> checkLeftFollowers(List<Follower> oldFollowerList, List<Follower> newFollowerList) {

        List<Follower> leftFollowers = new ArrayList<Follower>();
        for (Follower follower : oldFollowerList) {
            if(!newFollowerList.contains(follower)) {
                leftFollowers.add(follower);
            }
        }

        return leftFollowers;
    }

    public static List<Follower> checkNewFollowers(List<Follower> oldFollowerList, List<Follower> newFollowerList) {
        List<Follower> newFollowers = new ArrayList<Follower>();

        //FIXME for the first run of the scheduler, it shouldn't recognize the followers as new
        if(oldFollowerList.size() == 0)
            return newFollowerList;

        for (Follower follower : newFollowerList) {
            if(!oldFollowerList.contains(follower)) {
                newFollowers.add(follower);
            }
        }

        return newFollowers;
    }
}