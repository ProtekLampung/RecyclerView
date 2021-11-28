package com.protek.recyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.protek.recyclerview.DetailContact;
import com.protek.recyclerview.Model.MContact;
import com.protek.recyclerview.R;
import com.protek.recyclerview.ViewHolder.VHContact;

import java.util.ArrayList;
import java.util.List;

public class AContact extends RecyclerView.Adapter<VHContact> {

    //CONTACT LIST
    ArrayList<MContact> contactArrayList;

    //Context
    Context context;

    public AContact(ArrayList<MContact> contactArrayList, Context context) {
        this.contactArrayList = contactArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VHContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //VIEW LAYOUT INFLATER
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        //RETURN VIEW HOLDER INSTANCE
        return new VHContact(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHContact holder, int position) {

        //GET CONTACT AT POSITION
        MContact contact = contactArrayList.get(position);

        //SET VIEW
        holder.contactName.setText(contact.getContactName());
        holder.contactNumber.setText(contact.getContactNumber());
        holder.contactFirstLetter.setText(contact.getContactName().substring(0,1));

        //ITEM ONCLICK:
        holder.contactContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PREPARE BUNDLE
                //INTENT
                Intent intent = new Intent(context, DetailContact.class);
                intent.putExtra("position",holder.getAdapterPosition());
                intent.putExtra("contactIndex",contact.getContactIndex());
                intent.putExtra("contactName",contact.getContactName());
                intent.putExtra("contactNumber",contact.getContactNumber());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }
}
