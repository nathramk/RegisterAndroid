package pe.edu.upeu.enroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.edu.upeu.enroll.bean.Person;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Person> listPerson = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);

        //String[] name={"kenyi","caleb","amilcar","sss","sss"};

        //listPerson.add(new Person(1,"Kenyi ", "Lopez", "AV: peru 785", "Masculino", "Activo"));

        int layout = android.R.layout.simple_list_item_1;

        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, layout, listPerson);

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person=(Person)parent.getItemAtPosition(position);
                Toast.makeText(getBaseContext(),"slect: " + person.toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_new_person) {
        //    return true;
        //}
        switch (item.getItemId()){
            case R.id.action_new_person:
                Intent i = new Intent(this, Register.class);
                startActivity(i);
                break;
            case R.id.action_about:
                break;
            case R.id.action_synchronize:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
