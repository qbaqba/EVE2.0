package com.eve.helper;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {

    private List listOfAllId;
    private int randomId;
    private int correctId;
    private boolean statusOfCorrectId = false;

    private String firstDigit;
    private String secondDigit;
    private String thirdDigit;
    private String fourthDigit;
    private String fouthDigit;

    public IdGenerator(List listOfAllId){
        this.listOfAllId = listOfAllId;
    }

    public int selectCorrectId(){
        while(statusOfCorrectId == false){
            createRandomId();
            statusOfCorrectId = checkRandomId(randomId, listOfAllId);
        }
        correctId = randomId;
        return correctId;
    }

    public void createRandomId(){
        firstDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        secondDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        thirdDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        fourthDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
        fouthDigit = String.valueOf(ThreadLocalRandom.current().nextInt(0,10));

        String idToString = firstDigit + secondDigit + thirdDigit + fourthDigit + fouthDigit;
        randomId = Integer.parseInt(idToString);

    }

    public boolean checkRandomId(int randomId, List listOfAllId){
        if(listOfAllId.contains(randomId)){
            return false;
        }
        else{
            return true;
        }
    }


}
