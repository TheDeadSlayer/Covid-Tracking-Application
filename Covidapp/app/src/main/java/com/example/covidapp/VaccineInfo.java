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

import org.w3c.dom.Text;

public class VaccineInfo extends Fragment {

    private VaccineInfoViewModel mViewModel;

    TextView Vac,VacName,DoseNum,FDose,SDose;

    public static VaccineInfo newInstance() {
        return new VaccineInfo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View myinflatedview=inflater.inflate(R.layout.vaccine_info_fragment,container,false);

        Vac=(TextView) myinflatedview.findViewById(R.id.txt_Vac);
        VacName=(TextView) myinflatedview.findViewById(R.id.txt_VacName);
        DoseNum=(TextView) myinflatedview.findViewById(R.id.txt_DoseN);
        FDose=(TextView) myinflatedview.findViewById(R.id.txt_FDose);
        SDose=(TextView) myinflatedview.findViewById(R.id.txt_SDose);


        if(SharedPrefManager.getInstance(getActivity()).getVerify()&&login.person.IsVaccinated) {
            String str;
            if (login.person.IsVaccinated)
                str = "Yes";
            else
                str = "No";
            Vac.setText("Vaccinated: " + str);

            if (str == "Yes") {
                login.person.VacInfo();

                VacName.setText("Vaccine Name: "+login.person.getVaccineName());
                DoseNum.setText("Number of Doses: "+String.valueOf(login.person.DoseNum));
                FDose.setText("First Dose Date: "+login.person.FirstDose);
                SDose.setText("Second Dose Date: "+login.person.SecondDose);
            }
        }
        else {
            Vac.setText("No Vaccine");
            VacName.setVisibility(View.INVISIBLE);
            DoseNum.setVisibility(View.INVISIBLE);
           FDose.setVisibility(View.INVISIBLE);
            SDose.setVisibility(View.INVISIBLE);
        }


        return myinflatedview;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VaccineInfoViewModel.class);
        // TODO: Use the ViewModel
    }

}