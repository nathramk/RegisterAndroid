package pe.edu.upeu.enroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import pe.edu.upeu.enroll.bean.Person;

public class Register extends AppCompatActivity {

    Button btnSave;
    EditText textNames;
    EditText textLastName;
    EditText textAddress;
    private Spinner spinersex;
    private Spinner estado;
    String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSave = (Button)findViewById(R.id.btnSave);

        textNames = (EditText)findViewById(R.id.textNames);
        textLastName = (EditText)findViewById(R.id.textLastName);
        textAddress = (EditText)findViewById(R.id.textAddress);

        spinersex = (Spinner)findViewById(R.id.spinnerSex);

        String[] sexsString ={"Masculino","Femenino"};

        ArrayAdapter<String> sexs = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sexsString);

        spinersex.setAdapter(sexs);


        spinersex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sexo = (String) parent.getItemAtPosition(position);
                Toast.makeText(getBaseContext(),"slect: " + sexo,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.listPerson.add(new Person(1, textNames.toString(),textLastName.toString(),textAddress.toString(),"masculino","ACTIVO"));
                goMain();
            }
        });

    }

    public void goMain(){
        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
    }

}
