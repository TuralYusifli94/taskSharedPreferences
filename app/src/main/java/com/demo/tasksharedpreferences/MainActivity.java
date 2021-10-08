package com.demo.tasksharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String SAVED_NAME = "SAVED_NAME";
    private static final String SAVED_SURNAME = "SAVED_SURNAME";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ArrayList<Person> person = new ArrayList<>();
    private TextView textView;
    private TextView textView2;
    private EditText editTextName;
    private EditText editTextSurname;
    private Button buttonSave;
    private String name;
    private String surname;
    private String fullname;
    private ArrayList<TextView> getValues = new ArrayList<>();
    private ArrayList<String> setValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        buttonSave = findViewById(R.id.buttonSave);
        textView2 = findViewById(R.id.textView2);

        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        editor = preferences.edit();

        init();
        buttonSave.setOnClickListener(view -> {
            initValues();
            setName(name, surname);
        });
    }

    private void init() {

        setName(preferences.getString(SAVED_NAME, "empty name"), preferences.getString(SAVED_SURNAME, "empty surname"));

    }

    private void setName(String name, String surname) {
//        setValues.add(fullname);
//        for (int i = 0; i<setValues.size(); i++){
//            getValues.get(i).setText(setValues.get(i));
//
//        }
//        for (TextView a:getValues) {
//            textView.setText(String.valueOf(a));
//        }

        textView.setText(name);
        textView2.setText(surname);
        person.add(new Person(name, surname));
        editor.putString(SAVED_NAME, name);
        editor.putString(SAVED_SURNAME, surname);
        editor.commit();
    }

    private void initValues() {
        if (!editTextName.getText().toString().isEmpty()) {
            name = editTextName.getText().toString();
        } else {
            name = "noname";
        }
        if (!editTextSurname.getText().toString().isEmpty()) {
            surname = editTextSurname.getText().toString();
        } else {
            surname = "nosurname";
        }
    }

}


//    private void setValues(String name, String surname){
//        textView.setText(editTextName.getText().toString());
//        editor.putString(SAVED_NAME,editTextName.getText().toString());
//        editor.commit();
//    }