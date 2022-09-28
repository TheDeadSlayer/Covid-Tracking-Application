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

public class PCRTest extends Fragment {

    private PCRTestViewModel mViewModel;

    public static PCRTest newInstance() {
        return new PCRTest();
    }

    TextView Inst,CT,Res,FitFT;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View myinflatedview=inflater.inflate(R.layout.p_c_r_test_fragment,container,false);



        Inst=(TextView) myinflatedview.findViewById(R.id.txt_Inst);
        CT=(TextView) myinflatedview.findViewById(R.id.txt_CT);
        Res=(TextView) myinflatedview.findViewById(R.id.txt_Result);
        FitFT=(TextView) myinflatedview.findViewById(R.id.txt_FitFT);

        if(SharedPrefManager.getInstance(getActivity()).getVerify()) {
            Inst.setText("Institution: " + login.person.getInstitution());


            CT.setText("CT: " + String.valueOf(login.person.getCT()));
            Res.setText("Result: " + login.person.Res());
            String str;
            if (login.person.Travel())
                str = "Yes";
            else
                str = "No";
            FitFT.setText("Fit For Travel: " + str);
        }
        else{
            TextView takepcr= (TextView) myinflatedview.findViewById(R.id.txt_takepcr);
            Inst.setText("Account Unverified, Please wait for verification");
            takepcr.setVisibility(View.INVISIBLE);
            CT.setVisibility(View.INVISIBLE);
            Res.setVisibility(View.INVISIBLE);
            FitFT.setVisibility(View.INVISIBLE);
        }

        return myinflatedview;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PCRTestViewModel.class);
        // TODO: Use the ViewModel
    }

}