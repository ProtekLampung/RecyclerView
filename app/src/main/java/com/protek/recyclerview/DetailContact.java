package com.protek.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.protek.recyclerview.Data.DummyData;
import com.protek.recyclerview.Model.MContact;

public class DetailContact extends AppCompatActivity {

    //DECLARE VIEW:
    MaterialToolbar toolbar;
    TextView firstLetterName;
    TextView contactName;
    TextView contactNumber;
    ExtendedFloatingActionButton editContact;

    //Dummy Data
    DummyData dummyData;

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
        dummyData = new DummyData();

        //TOOLBAR BACK ICON PRESS
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //GET INTENT
        int position = getIntent().getIntExtra("position",0);
        int contactIndex = getIntent().getIntExtra("contactIndex",0);
        String stringContactName = getIntent().getStringExtra("contactName");
        String stringContactNumber = getIntent().getStringExtra("contactNumber");

        //SET VIEW UI
        firstLetterName.setText(stringContactName.substring(0,1));
        contactName.setText(stringContactName);
        contactNumber.setText(stringContactNumber);

        //TOOLBAR MENU DELETE:
        toolbar.setOnMenuItemClickListener(onMenuItemClick(dummyData, position));

        //XFAB EDIT CONTACT:
        editContact.setOnClickListener(
                xFabOnClick(DetailContact.this, contactIndex, stringContactName, stringContactNumber));

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

    //TOOLBAR MENU FUNCTION:
    Toolbar.OnMenuItemClickListener onMenuItemClick(DummyData data, int position) {
        return new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //SWITCH
                switch (item.getItemId()) {
                    case R.id.menu_toolbar_detail_contact_delete:
                        //DELETE CONTACT, REQUIRED INDEX:
                        data.deleteContact(position);

                        //BACK TO MAIN ACTIVITY:
                        onBackPressed();
                        return true;
                }
                return false;
            }
        };
    }

    //XFAB ON CLICK FUNCTION:
    View.OnClickListener xFabOnClick(Context context, int contactIndex, String contactName, String contactNumber) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CHANGE ACTIVITY TO EDITOR:
                Intent intent = new Intent(context, ContactEditor.class);
                intent.putExtra("contactIndex",contactIndex);
                intent.putExtra("contactName",contactName);
                intent.putExtra("contactNumber",contactNumber);
                startActivity(intent);
            }
        };
    }

}