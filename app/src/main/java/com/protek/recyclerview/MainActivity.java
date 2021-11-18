package com.protek.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.protek.recyclerview.Adapter.AContact;
import com.protek.recyclerview.Model.MContact;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //CREATE CONTACT INSTANCE LIST
    public ArrayList<MContact> contactList;

    //DECLARE VIEW
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZE VIEW:
        recyclerView = findViewById(R.id.main_recyclerview);

        //INITIALIZE LIST
        contactList = new ArrayList<>();

        contactList.add(new MContact(0,"Pengguna","08293123"));
        contactList.add(new MContact(1,"Wow","089231239"));

        //ADAPTER INSTANCE
        AContact adapterContact = new AContact(contactList,MainActivity.this);
        //adapterContact.notify();

        //SETTING UP RECYCLER VIEW
        recyclerView.setAdapter(adapterContact);
    }

}