package com.eve.helper;

public class InputVerifier {

    private int minLength;
    private int maxLength;
    private boolean confirmationStatus;

    public InputVerifier(){}

    public InputVerifier(int minLength, int maxLength){
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(boolean confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }

    public boolean checkLengthOfString(String checkedString){
        if(checkedString.length() > maxLength || checkedString.length() < minLength){
            return false;
        }
        else return true;
    }

}
