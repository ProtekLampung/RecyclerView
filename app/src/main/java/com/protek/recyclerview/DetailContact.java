package com.protek.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.protek.recyclerview.Model.MContact;

public class DetailContact extends AppCompatActivity {

    //DECLARE VIEW:
    MaterialToolbar toolbar;
    TextView firstLetterName;
    TextView contactName;
    TextView contactNumber;
    ExtendedFloatingActionButton editContact;

    //Contact
    MContact mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        //INITIALIZE VIEW:
        toolbar = findViewById(R.id.detailcontact_toolbar);
        firstLetterName = findViewById(R.id.detailcontact_firstletter);
        contactName = findViewById(R.id.detailcontact_contactname);
        contactNumber = findViewById(R.id.detailcontact_contactnumber);
        editContact = findViewById(R.id.detailcontact_editcontact);

        //TOOLBAR BACK ICON PRESS
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //GETINTENT
        firstLetterName.setText(getIntent().getStringExtra("contactName").substring(0,1));
        contactName.setText(getIntent().getStringExtra("contactName"));
        contactNumber.setText(getIntent().getStringExtra("contactNumber"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //ON BACK PRESS - BACK TO CONTACT LIST:
        Intent intent = new Intent(DetailContact.this, MainActivity.class);
        startActivity(intent);
        //DESTROY THIS ACTIVITY STATE:
        finish();

    }
}