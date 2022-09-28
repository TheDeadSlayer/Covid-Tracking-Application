package com.example.covidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity implements View.OnClickListener {

    EditText ID;
    EditText PhoneNumber;
    Button LoginBtn;
    Button RegisterBtn;
    private ProgressDialog prgsDialog;

    static public Person person= new Person();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPrefManager.getInstance(this).getclass();

//     if(SharedPrefManager.getInstance(this).isLoggedIn())
//     {
//            finish();
//      startActivity(new Intent(this,MainActivity.class));
//
//     }

        RegisterBtn =(Button)findViewById(R.id.button_Registration);
        ID= (EditText) findViewById(R.id.txt_IDL);
        PhoneNumber= (EditText) findViewById(R.id.txt_PhoneNumberL);
        LoginBtn=(Button) findViewById(R.id.btn_Login);

        prgsDialog= new ProgressDialog(this);
        prgsDialog.setMessage("Logging in..");
        LoginBtn.setOnClickListener(this);
        RegisterBtn.setOnClickListener(this);



    }

    public void update()
    {
        try {
            JSONObject obj= new JSONObject();


                SharedPrefManager.getInstance(getApplicationContext()).userLogin (
                        obj.getString("ID"),
                        obj.getString("NameP"),
                        obj.getInt("Age"),
                        obj.getString("Location"),
                        obj.getString("PhoneNumber"),
                        obj.getString("Institution"),
                        obj.getInt("CT"),
                        obj.getString("VaccinationStatus"),
                        obj.getString("VaccineName"),
                        obj.getString("FirstDoseDate"),
                        obj.getString("SecondDoseDate"),
                        obj.getString("TypeS"),
                        obj.getInt("SeverityLevel"),
                        obj.getInt("Contacts"),
                        obj.getString("ArrivedFrom"),
                        obj.getString("Verified"));

    } catch (JSONException e) {
        e.printStackTrace();
    }
    }


    private void userLogin()
    {
        final String Id= ID.getText().toString().trim();
        final String phoneNumber= PhoneNumber.getText().toString().trim();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, Constants.URL_ClientLogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject obj= new JSONObject(response);

                    if(!obj.getBoolean("error"))
                    {

                        SharedPrefManager.getInstance(getApplicationContext()).userLogin (
                        obj.getString("ID"),
                        obj.getString("NameP"),
                        obj.getInt("Age"),
                        obj.getString("Location"),
                        obj.getString("PhoneNumber"),
                        obj.getString("Institution"),
                        obj.getInt("CT"),
                        obj.getString("VaccinationStatus"),
                        obj.getString("VaccineName"),
                        obj.getString("FirstDoseDate"),
                        obj.getString("SecondDoseDate"),
                        obj.getString("TypeS"),
                        obj.getInt("SeverityLevel"),
                        obj.getInt("Contacts"),
                        obj.getString("ArrivedFrom"),
                        obj.getString("Verified")
                        );

                        startActivity(new Intent (getApplicationContext(),MainActivity.class));
                        finish();

                    }else  {
                        Toast.makeText(getApplicationContext(),obj.getString("message"), Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            prgsDialog.dismiss();

            Toast.makeText(
                    getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();



            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("ID",Id);
                params.put("PhoneNumber", phoneNumber);
                return params;

            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
    public void openRegistration()
    {
        Intent intent = new Intent(login.this, registration.class);
        startActivity(intent);

    }
    @Override
    public void onClick(View v) {

        if(v== LoginBtn) {
            userLogin();

        }

        if(v==RegisterBtn)
            openRegistration();
    }
}