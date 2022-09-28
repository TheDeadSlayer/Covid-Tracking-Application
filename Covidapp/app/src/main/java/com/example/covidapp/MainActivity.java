package com.example.covidapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covidapp.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private AppBarConfiguration mAppBarConfiguration;

    private ActivityMainBinding binding;



    
    TextView Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);




        if(!SharedPrefManager.getInstance(this).isLoggedIn())
        {

            finish();
            startActivity(new Intent(this,login.class));

        }

//    Name=(TextView) View.findViewById(R.id.txt_Name_main) ;
//
//
//      Name.setText(SharedPrefManager.getInstance(this).getName());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        View headerView = navigationView.getHeaderView(0);

        TextView NavName = (TextView) headerView.findViewById(R.id.txt_Name_Nav);
        NavName.setText(login.person.getName());
        Button btnLogout= (Button)headerView.findViewById((R.id.btn_Logout));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(getApplicationContext(), login.class));
                    finish();


            }
        });

        TextView NavState= (TextView)headerView.findViewById(R.id.txt_Stat_Nav);
        if(login.person instanceof Positive) {
            NavState.setText("Postive");

        }
        else if(login.person instanceof Negative) {
            NavState.setText("Negative");

        }
        else if(login.person instanceof Quarantined) {
            NavState.setText("Quarantined");

        }
        else if(login.person instanceof Suspected) {
            NavState.setText("Suspected");

        }
        else
        {
            NavState.setText("Negative");

        }



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_healthstatus,R.id.nav_vaccine,R.id.nav_PCRtest,R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {

    }
}