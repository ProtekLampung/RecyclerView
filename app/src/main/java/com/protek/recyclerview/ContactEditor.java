package com.protek.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.protek.recyclerview.Data.DummyData;
import com.protek.recyclerview.Model.MContact;

public class ContactEditor extends AppCompatActivity {

    //DECLARE VIEW:
    MaterialToolbar toolbar;
    ExtendedFloatingActionButton floatingActionButton;
    TextInputEditText inputContactName;
    TextInputEditText inputContactNumber;

    //CONTACT DATA
    DummyData dummyData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_editor);

        //INIT VIEW:
        toolbar = findViewById(R.id.editor_toolbar);
        floatingActionButton = findViewById(R.id.editor_fab);
        inputContactName = findViewById(R.id.editor_contactname);
        inputContactNumber = findViewById(R.id.editor_contactnumber);
        dummyData = new DummyData();

        //TOOLBAR NAVIGATION CLICK
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //GET INTENT
        int contactIndex = getIntent().getIntExtra("contactIndex",-1);
        String stringContactName = getIntent().getStringExtra("contactName");
        String stringContactNumber = getIntent().getStringExtra("contactNumber");

        //IF INTENT EXTRA EXIST:
        if (contactIndex != -1) {
            //SET VIEW UI:
            inputContactName.setText(stringContactName);
            inputContactNumber.setText(stringContactNumber.substring(4));

            //SET FAB ON CLICK:
            floatingActionButton.setOnClickListener(fabOnClickEditData(dummyData, inputContactName, inputContactNumber, contactIndex));

        }
        //DEFAULT FAB ON CLICK:
        else {
            floatingActionButton.setOnClickListener(fabOnClickNewData(dummyData, inputContactName, inputContactNumber));
        }

    }

    //FAB ON CLICK FUNCTION:
    //SAVE NEW DATA:
    View.OnClickListener fabOnClickNewData(DummyData data, TextInputEditText inputContactName, TextInputEditText inputContactNumber) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET TEXT FROM INPUT
                String contactName = inputContactName.getText().toString();
                String contactNumber = inputContactNumber.getText().toString();

                //SAVE TO NEW CONTACT
                data.addContact(contactName, "+62 "+contactNumber);

                //CHANGE ACTIVITY TO MAIN:
                onBackPressed();
            }
        };
    }

    //EDIT DATA
    View.OnClickListener fabOnClickEditData(DummyData data, TextInputEditText inputContactName, TextInputEditText inputContactNumber, int contactIndex) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET TEXT FROM INPUT
                String contactName = inputContactName.getText().toString();
                String contactNumber = inputContactNumber.getText().toString();

                //SAVE TO NEW CONTACT
                data.editContact(contactIndex, new MContact(contactIndex, contactName, "+62 "+contactNumber));

                //CHANGE ACTIVITY TO MAIN:
                onBackPressed();
            }
        };
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //BACK TO MAIN ACTIVITY & TERMINATE EDITOR ACTIVITY:
        Intent intent = new Intent(ContactEditor.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}