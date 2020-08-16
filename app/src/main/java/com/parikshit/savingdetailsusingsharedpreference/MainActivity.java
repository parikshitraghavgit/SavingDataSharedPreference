package com.parikshit.savingdetailsusingsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
private TextView textView;
private Button button,buttonSave,buttonDisplay;
private EditText editTextFirstName,editTextLastName,
    editTextEmail,editTextPhoneNumber,editTextQualification;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences= getSharedPreferences("SP",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        buttonSave = (Button)findViewById(R.id.buttonSave);
        buttonDisplay=(Button)findViewById(R.id.buttonShow);
        editTextFirstName = (EditText)findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText)findViewById(R.id.editTextLastName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPhoneNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
        editTextQualification = (EditText)findViewById(R.id.editTextQualification);

        textView =(TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
ShowDatePicker();
            }
        });


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });


        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowData();
            }
        });

    }

    private void SaveData(){

        String firstName,lastName,email,phoneNumber,Qualification,dateOfBirth;
        firstName = editTextFirstName.getText().toString().trim();
        lastName = editTextLastName.getText().toString().trim();
        email=editTextEmail.getText().toString().trim();
        phoneNumber= editTextPhoneNumber.getText().toString().trim();
        Qualification = editTextQualification.getText().toString().trim();
        dateOfBirth = textView.getText().toString().trim();

       //   SharedPreferences sharedPreferences = getSharedPreferences("SP",MODE_PRIVATE);
      //  SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("FN",firstName);
        editor.putString("LN",lastName);
        editor.putString("EM",email);
        editor.putString("PN",phoneNumber);
        editor.putString("QN",Qualification);
        editor.putString("DOB",dateOfBirth);

        editor.apply();
    }

    private void ShowData(){
        SharedPreferences sharedPreferences2 = getSharedPreferences("SP",MODE_PRIVATE);
        String fn,ln,em,pn,qn,dob;
        fn = sharedPreferences2.getString("FN","Not Found");
        ln = sharedPreferences2.getString("LN","Not Found");
        em = sharedPreferences2.getString("EM","Not Found");
        pn = sharedPreferences2.getString("PN","Not Found");
        qn = sharedPreferences2.getString("QN","Not Found");
        dob = sharedPreferences2.getString("DOB","Not Found");

//        Toast.makeText(MainActivity.this,
//                fn+ln+em+pn+qn+dob,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this,StoredData.class);
        intent.putExtra("FNkey",fn);
        intent.putExtra("LNkey",ln);
        intent.putExtra("EMkey",em);
        intent.putExtra("PNkey",pn);
        intent.putExtra("QNkey",qn);
        intent.putExtra("DOBkey",dob);

        startActivity(intent);

    }

    private void ShowDatePicker(){
        DatePickerDialog datePickerDialog= new DatePickerDialog(this,
                this,
                2000,
             1,
               0);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
int mon = month+1;
String monthName ="";
switch (mon){
    case 1: monthName = "January"; break;
    case 2: monthName = "February";break;
    case 3: monthName = "March";break;
    case 4: monthName = "April";break;
    case 5: monthName = "May";break;
    case 6: monthName = "June";break;
    case 7: monthName = "July";break;
    case 8: monthName = "August";break;
    case 9: monthName = "September";break;
    case 10: monthName = "October";break;
    case 11: monthName = "November";break;
    case 12: monthName = "December";

}
        String DOfB = ""+dayOfMonth+"/"+monthName+" /"+year;
textView.setText(DOfB);
    }
}
