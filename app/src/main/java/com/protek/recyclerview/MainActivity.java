package com.protek.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.protek.recyclerview.Adapter.AContact;
import com.protek.recyclerview.Data.DummyData;
import com.protek.recyclerview.Model.MContact;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //CREATE CONTACT INSTANCE LIST
    public DummyData dummyData;

    //ADAPTER
    AContact adapterContact;

    //DECLARE VIEW
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    TextView textNoContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZE VIEW:
        recyclerView = findViewById(R.id.main_recyclerview);
        floatingActionButton = findViewById(R.id.main_fab);
        textNoContact = findViewById(R.id.text_nocontact);

        //FAB ON CLICK
        floatingActionButton.setOnClickListener(fabOnClick());

        //INITIALIZE LIST
        dummyData = new DummyData();
        //ArrayList<MContact> contactList = dummyData.getContactList();

        //ADAPTER INSTANCE
        adapterContact = new AContact(dummyData.getContactList(),MainActivity.this);
        //adapterContact.notify();

        //SETTING UP RECYCLER VIEW
        recyclerView.setAdapter(adapterContact);

        //INFORMATION NO CONTACT
        noContact(adapterContact,dummyData.getContactList(), textNoContact);
    }

    //FAB ONCLICK FUNCTION
    View.OnClickListener fabOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INTENT TO EDITOR PAGE
                Intent intent = new Intent(MainActivity.this, ContactEditor.class);
                startActivity(intent);
                finish();
            }
        };
    }

    //IF NO CONTACT
    void noContact(AContact adapter, ArrayList<MContact> contactList, TextView textNoContact) {
        //CONDITION:
        if (adapter.getItemCount()==0) {
            textNoContact.setVisibility(View.VISIBLE);
        }else {
            textNoContact.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}