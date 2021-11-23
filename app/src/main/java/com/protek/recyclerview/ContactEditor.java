package com.protek.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.protek.recyclerview.Model.MContact;

public class ContactEditor extends AppCompatActivity {

    //DECLARE VIEW:
    MaterialToolbar toolbar;
    ExtendedFloatingActionButton floatingActionButton;
    TextInputEditText inputContactName;
    TextInputEditText inputContactNumber;

    //CONTACT DATA
    MContact mContact;
    //MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_editor);

        //INIT VIEW:
        toolbar = findViewById(R.id.editor_toolbar);
        floatingActionButton = findViewById(R.id.editor_fab);
        inputContactName = findViewById(R.id.editor_contactname);
        inputContactNumber = findViewById(R.id.editor_contactnumber);
        //mainActivity = new MainActivity();

        //TOOLBAR NAVIGATION CLICK
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //FAB ON CLICK
        floatingActionButton.setOnClickListener(fabOnClick(inputContactName, inputContactNumber));
    }

    //FAB ON CLICK FUNCTION:
    View.OnClickListener fabOnClick(TextInputEditText inputContactName, TextInputEditText inputContactNumber) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET TEXT FROM INPUT
                String contactName = inputContactName.getText().toString();
                String contactNumber = inputContactNumber.getText().toString();

                //SAVE TO MODEL
                MContact contact = new MContact();
                contact.addContactList(new MContact(contact.getLastIndex()+1,contactName,"+62 "+contactNumber));

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