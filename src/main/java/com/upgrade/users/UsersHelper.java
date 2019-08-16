package com.upgrade.users;


import com.github.javafaker.Faker;

/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class UsersHelper {

    private static Faker faker = new Faker();

    public static User getRandomUser() {
        User user = new User("candidate+" + faker.number().digits(5) + "@upgrade-challenge.com", "7654321Qa");
        return user;

    }

}


