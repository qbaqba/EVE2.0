package com.eve.helper;

import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {

    private int randomId;

    private String firstDigit;
    private String secondDigit;
    private String thirdDigit;
    private String fourthDigit;

    public int getRandomId(){
        firstDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        secondDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        thirdDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        fourthDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));

        String idToString = firstDigit + secondDigit + thirdDigit + fourthDigit;
        randomId = Integer.parseInt(idToString);

        return randomId;
    }
}
