package com.example.covidapp;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDate;

public class HealthStatus extends Fragment {

    private HealthStatusViewModel mViewModel;

    public static HealthStatus newInstance() {
        return new HealthStatus();
    }

    TextView Instruct,Slevel,QPloc,Contacts,ArriveF,DateA,ShowSym;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View myinflatedview=inflater.inflate(R.layout.health_status_fragment,container,false);

        Instruct=(TextView) myinflatedview.findViewById(R.id.txt_Instruct);
        Slevel=(TextView) myinflatedview.findViewById(R.id.txt_Slevel);
        QPloc=(TextView) myinflatedview.findViewById(R.id.txt_QPloc);
        Contacts=(TextView) myinflatedview.findViewById(R.id.txt_Contacts);
        ArriveF=(TextView) myinflatedview.findViewById(R.id.txt_ArriveF);
        DateA=(TextView) myinflatedview.findViewById(R.id.txt_DateA);

        if(SharedPrefManager.getInstance(getActivity()).getVerify()) {
            if (login.person instanceof Positive) {
                Positive Ptemp = (Positive) login.person;
                Instruct.setText(Ptemp.Instruct());
                Slevel.setText("Severity Level: " + Ptemp.getSeverityLevel());
                QPloc.setText("Quarantine Location: " + Ptemp.SetLocation());
                Contacts.setText("Family Members: " + Ptemp.getContacts());
            } else if (login.person instanceof Negative) {
                Negative Ntemp = (Negative) login.person;
                Instruct.setText(Ntemp.Instruct());
            } else if (login.person instanceof Quarantined) {
                Quarantined Qtemp = (Quarantined) login.person;
                Instruct.setText(Qtemp.Instruct());
                ArriveF.setText("Arrived From: " + Qtemp.getArrivedFrom());
                DateA.setText("Date of Arrival: " + LocalDate.now().toString());
            } else if (login.person instanceof Suspected) {
                Suspected Stemp = (Suspected) login.person;
                login.person = (Suspected) Stemp;
                Instruct.setText(Stemp.Instruct());
            } else {

            }
        }

        else
        {
            Instruct.setText("Account Unverified, Please wait for verification");
            Slevel.setVisibility(View.INVISIBLE);
            QPloc.setVisibility(View.INVISIBLE);
            Contacts.setVisibility(View.INVISIBLE);
            ArriveF.setVisibility(View.INVISIBLE);
            DateA.setVisibility(View.INVISIBLE);
        }


        return myinflatedview;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HealthStatusViewModel.class);
        // TODO: Use the ViewModel
    }

}