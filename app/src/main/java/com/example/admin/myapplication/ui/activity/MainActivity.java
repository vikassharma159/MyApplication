package com.example.admin.myapplication.ui.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.backend.presenter.InformationPresenter;
import com.example.admin.myapplication.model.Information;
import com.example.admin.myapplication.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends BaseActivity {
    private EditText personName;
    private Button addInformation;
    private Button showList;
    private EditText datePicker;
    private InformationPresenter informationPresenter;
    private DatePickerDialog datePickerDialog;
    private Information information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.add_person_information));
        findAllId();
        initialization();
        setListeners();
    }

    private void findAllId() {
        personName = findViewById(R.id.person_name);
        addInformation = findViewById(R.id.add_information_button);
        showList = findViewById(R.id.show_list_button);
        datePicker = findViewById(R.id.date_picker);
    }

    private void initialization() {
        informationPresenter = new InformationPresenter();
        information = new Information();
    }

    private void setListeners() {
        addInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(personName.getText().toString())) {
                    Toast.makeText(getApplicationContext(), getString(R.string.show_empty_text_message), Toast.LENGTH_SHORT).show();
                    return;
                } else if(TextUtils.isEmpty(datePicker.getText().toString())) {
                    Toast.makeText(getApplicationContext(), getString(R.string.show_empty_date_message), Toast.LENGTH_SHORT).show();
                    return;
                }
                information.setName(personName.getText().toString());
                Information tempInformation = new Information();
                tempInformation.setName(information.getName());
                tempInformation.setDate(information.getDate());
                informationPresenter.addPersonInformation(tempInformation);
                Toast.makeText(getApplicationContext(), getString(R.string.information_added_message), Toast.LENGTH_SHORT).show();
                personName.setText("");
                datePicker.setText("");
            }
        });

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT);
                        String date;
                        Date date1;
                        date = ((month + 1) + "/" + dayOfMonth + "/" + year);
                        datePicker.setText(date);
                        try {
                            date1 = simpleDateFormat.parse(date);
                            information.setDate(simpleDateFormat.format(date1));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonListActivity.class);
                startActivity(intent);
            }
        });
    }
}
