package com.protek.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.protek.recyclerview.Adapter.AContact;
import com.protek.recyclerview.Model.MContact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //CREATE CONTACT INSTANCE LIST
    public List<MContact> mContact;

    //DECLARE VIEW
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZE VIEW:
        recyclerView = findViewById(R.id.main_recyclerview);

        mContact.add(new MContact(0,"Penggua","08293123"));
    }

    @Override
    protected void onStart() {
        super.onStart();

        //ADAPTER INSTANCE
        AContact adapterContact = new AContact(mContact);

        //SETTING UP RECYCLER VIEW
        recyclerView.setAdapter(adapterContact);

    }
}