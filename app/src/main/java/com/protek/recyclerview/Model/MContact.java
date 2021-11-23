package com.protek.recyclerview.Model;

import java.util.ArrayList;

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

    //ADD TEMPORARY DATA CONTAINER
    //DATA LIST:
    private static ArrayList<MContact> contactList = new ArrayList<MContact>();
    //INT CONTACT LAST INDEX:
    private int lastIndex = -1;
    //FUNCTION
    //GET LAST INDEX:

    public int getLastIndex() {
        return lastIndex;
    }

    //GET CONTACT LIST:
    public static ArrayList<MContact> getContactList() {
        return contactList;
    }
    //ADD:
    public void addContactList(MContact mContact) {
        contactList.add(mContact);
    }

    //EDIT:
    public void editContact(int contactIndex, MContact mContact) {
        contactList.set(contactIndex, mContact);
    }

    //DELETE:
    public void deleteContact(int contactIndex) {
        contactList.remove(contactIndex);
    }
}
