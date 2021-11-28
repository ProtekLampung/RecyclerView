package com.protek.recyclerview.Data;

import com.protek.recyclerview.Model.MContact;

import java.util.ArrayList;

public class DummyData {

    //CREATE DUMMY DATA FOR TEMPORARY STORAGE:
    private static ArrayList<MContact> contactList = new ArrayList<MContact>();

    //CONSTRUCTOR
    public DummyData() {
        //
    }

    //GET LIST
    public static ArrayList<MContact> getContactList() {
        return contactList;
    }

    //CREATE CONTACT
    static int lastIndex = 0;
    public void addContact(String contactName, String contactNumber) {
        contactList.add(new MContact(lastIndex, contactName, contactNumber));
        lastIndex++;
    }

    //DELETE CONTACT
    public void deleteContact(int position) {
        contactList.remove(position);
    }

    //EDIT CONTACT
    public void editContact(int contactIndex, MContact mContact) {
        contactList.set(contactIndex, mContact);
    }

}
