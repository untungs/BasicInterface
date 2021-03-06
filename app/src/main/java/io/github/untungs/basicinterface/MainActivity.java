package io.github.untungs.basicinterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import io.github.untungs.basicinterface.company.Manager;
import io.github.untungs.basicinterface.company.Worker;

public class MainActivity extends AppCompatActivity implements Manager.OnDocumentUpdateListener {

    private Manager manager;
    private TextView textReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textReport = (TextView) findViewById(R.id.textReport);


        List<Worker> workers = Arrays.asList(new Worker("A", 100), new Worker("B", 3000), new Worker("C", 7000));
        manager = new Manager();
        manager.setWorkers(workers);
        manager.setListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.assignWork();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDocumentUpdated(String report) {
        textReport.setText(manager.report());
    }
}
