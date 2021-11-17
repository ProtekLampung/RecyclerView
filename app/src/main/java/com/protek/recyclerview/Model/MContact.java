package com.protek.recyclerview.Model;

public class MContact {

    private int contactIndex;
    private String contactName;
    private String contactNumber;

    public MContact(int contactIndex, String contactName, String contactNumber) {
        this.contactIndex = contactIndex;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public MContact() {
        //empty constructor
    }

    public int getContactIndex() {
        return contactIndex;
    }

    public void setContactIndex(int contactIndex) {
        this.contactIndex = contactIndex;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
