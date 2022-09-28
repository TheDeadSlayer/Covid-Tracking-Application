package com.example.covidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity implements  View.OnClickListener{

    private ProgressDialog prgsDialog;
    private  Button Reg;
    static public Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Reg = findViewById(R.id.Register_Btn);
        prgsDialog = new ProgressDialog(this);
        Reg.setOnClickListener(this);
    }

            private void registerUser(){

                EditText ID=findViewById(R.id.txt_ID);
                EditText Age=findViewById(R.id.Age_Register);
                EditText PhoneNum=findViewById(R.id.Phone_Register);
                EditText Name =findViewById(R.id.Name_Register);
                EditText Location=findViewById(R.id.Location_Register);
                person= new Person(ID.getText().toString(), Name.getText().toString(), Location.getText().toString(), PhoneNum.getText().toString(), Integer.parseInt(Age.getText().toString()));

//                prgsDialog.setMessage("Registering User...");
//                prgsDialog.show();
                StringRequest strReq= new StringRequest(Request.Method.POST, Constants.URL_Register, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //prgsDialog.dismiss();

                        try {
                            JSONObject json= new JSONObject(response);
                            String f= json.getString("message");

                            if(f.equals("User Registered Successfully")) {
                                startActivity(new Intent(getApplicationContext(), login.class));
                                finish();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        prgsDialog.hide();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        params.put("ID",person.getID());
                        params.put("NameP",person.getName());
                        params.put("Age",Age.getText().toString());
                        params.put("Location",person.getLocation());
                        params.put("PhoneNumber",person.getPhoneNum());
                        return params;
                    }
                };


                RequestHandler.getInstance(this).addToRequestQueue(strReq);

            }



    @Override
    public void onClick(View v) {

        if (v==Reg) {
            registerUser();
        }

    }

}