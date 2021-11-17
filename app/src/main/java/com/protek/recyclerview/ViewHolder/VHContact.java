package com.protek.recyclerview.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.protek.recyclerview.R;

public class VHContact extends RecyclerView.ViewHolder {

    //DECLARE ITEM COMPONENTS:
    public LinearLayout contactContainer;
    public TextView contactName;
    public TextView contactNumber;
    public TextView contactFirstLetter;

    public VHContact(@NonNull View itemView) {
        super(itemView);

        //INITIATE ITEM COMPONENTS:
        contactContainer = itemView.findViewById(R.id.item_contact_container);
        contactName = itemView.findViewById(R.id.item_contact_name);
        contactNumber = itemView.findViewById(R.id.item_contact_number);
        contactFirstLetter = itemView.findViewById(R.id.item_contact_firstletter);

    }
}
