package com.protek.recyclerview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.protek.recyclerview.Model.MContact;
import com.protek.recyclerview.R;
import com.protek.recyclerview.ViewHolder.VHContact;

import java.util.List;

public class AContact extends RecyclerView.Adapter<VHContact> {

    //CONTACT LIST
    List<MContact> mContacts;

    public AContact(List<MContact> mContacts) {
        this.mContacts = mContacts;
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
        MContact contact = mContacts.get(position);

        //SET VIEW
        holder.contactName.setText(contact.getContactName());
        holder.contactNumber.setText(contact.getContactNumber());
        holder.contactFirstLetter.setText(contact.getContactName().charAt(0));
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
