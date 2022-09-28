package com.example.covidapp.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidapp.CovidInfo;
import com.example.covidapp.FAQ;
import com.example.covidapp.FAQpage;
import com.example.covidapp.Precautions_page;
import com.example.covidapp.R;
import com.example.covidapp.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment  {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;
    CovidInfo covid=new CovidInfo();

    Button btn,btn_P;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        View myinflatedview=inflater.inflate(R.layout.fragment_slideshow,container,false);

        btn=(Button) myinflatedview.findViewById(R.id.btn_faq);
        TextView info=myinflatedview.findViewById(R.id.txt_info);
        info.setText(covid.ShowInfo());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FAQpage.class));
            }
        });

        btn_P=(Button)myinflatedview.findViewById(R.id.btn_P);

        btn_P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Precautions_page.class));
            }
        });


        return myinflatedview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}