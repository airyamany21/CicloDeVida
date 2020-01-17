package curso.uabc.com.ciclodevida;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Esta clase hereda los metodos y atributos de la clase TracerActivity e implementa un listener para el boton
 * Este ejemplo tiene algo particular, el archivo XML del Layout tiene declarado el metodo OnClick en el boton,
 * por eso en la clase Java del Activity no se crea una instancia.
 *
 * */
public class MainActivity extends TracerActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se crea una lista desplegable que contiene una arreglo de datos en R.array.operating_systems
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] values = getResources().getStringArray(R.array.operating_systems);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        spinner.setAdapter(adapter);

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Metodo onClick que se encuentra realacionado con el Boton en el archivo XML
     * */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityDos.class);
        startActivity(intent);
    }
}
