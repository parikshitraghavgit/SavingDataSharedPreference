package com.parikshit.savingdetailsusingsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StoredData extends AppCompatActivity {

    TextView textViewFn,textViewLn,textViewEm,textViewPn,textViewDob,textViewQn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stored_data);

        textViewFn = (TextView)findViewById(R.id.textViewFirstName);
        textViewLn = (TextView)findViewById(R.id.textViewLastName);
        textViewEm = (TextView)findViewById(R.id.textViewEmail);
        textViewPn = (TextView)findViewById(R.id.textViewNumber);
        textViewDob = (TextView)findViewById(R.id.textViewDob);
        textViewQn = (TextView)findViewById(R.id.textViewQualification);

        Intent intent =getIntent();
        String fn,ln,em,pn,qn,dob;
        fn = intent.getStringExtra("FNkey");
        ln = intent.getStringExtra("LNkey");
        em = intent.getStringExtra("EMkey");
        pn = intent.getStringExtra("PNkey");
        qn = intent.getStringExtra("QNkey");
        dob = intent.getStringExtra("DOBkey");

        textViewFn.setText(fn);
        textViewLn.setText(ln);
        textViewEm.setText(em);
        textViewPn.setText(pn);
        textViewDob.setText(dob);
        textViewQn.setText(qn);
    }
}
