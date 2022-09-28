package com.example.covidapp.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidapp.Negative;
import com.example.covidapp.Positive;
import com.example.covidapp.Quarantined;
import com.example.covidapp.R;
import com.example.covidapp.SharedPrefManager;
import com.example.covidapp.Suspected;
import com.example.covidapp.databinding.FragmentHomeBinding;
import com.example.covidapp.login;

import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    TextView Name;
    TextView Date1;
    TextView State;
    Date currentTime = Calendar.getInstance().getTime();
    Button StateColor;
    ImageView VacStamp;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        View myinflatedview=inflater.inflate(R.layout.fragment_home,container,false);
        Name=(TextView) myinflatedview.findViewById(R.id.txt_Name_main);
        Date1=(TextView) myinflatedview.findViewById(R.id.txt_Date_main);
        State=(TextView) myinflatedview.findViewById(R.id.txt_State_Main);
        StateColor =(Button) myinflatedview.findViewById(R.id.btn_main);
        VacStamp= (ImageView) myinflatedview.findViewById(R.id.Vac_Stamp);
        Name.setText(login.person.getName());
        Date1.setText(currentTime.toString());

        if(SharedPrefManager.getInstance(getActivity()).getVacStatus())
            VacStamp.setImageResource(R.drawable.ic_vac);

        if(login.person instanceof Positive) {
            State.setText("Postive");
            StateColor.setBackgroundColor(Color.RED);
        }
        else if(login.person instanceof Negative) {
            State.setText("Negative");
            StateColor.setBackgroundColor(Color.GREEN);
        }
        else if(login.person instanceof Quarantined) {
            State.setText("Quarantined");
            StateColor.setBackgroundColor(Color.YELLOW);
        }
        else if(login.person instanceof Suspected) {
            State.setText("Suspected");
            StateColor.setBackgroundColor(Color.GRAY);
        }
        else
        {
            State.setText("Negative");
            StateColor.setBackgroundColor(Color.GREEN);
        }

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return myinflatedview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}