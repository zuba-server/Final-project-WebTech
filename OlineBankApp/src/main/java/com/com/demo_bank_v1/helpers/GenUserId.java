package com.com.demo_bank_v1.helpers;

import java.util.Random;

public class GenUserId {
    public static int generateUserId(){
        int userId;
        Random random = new Random();
        int bound = 1000;
        userId = bound * random.nextInt(bound);
        return userId;
    }
}
