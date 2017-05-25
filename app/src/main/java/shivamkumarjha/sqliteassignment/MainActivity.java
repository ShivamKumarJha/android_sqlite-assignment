package shivamkumarjha.sqliteassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText e;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        e = (EditText) findViewById(R.id.e1);
        b = (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHome dbh = new DBHome(MainActivity.this);
                boolean res = dbh.verification(e.getText().toString());
                if (res)
                {
                    Snackbar bar = Snackbar.make(v, "Record Found!", Snackbar.LENGTH_LONG)
                            .setAction("Show", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(MainActivity.this,Show.class);
                                    startActivity(i);
                                }
                            });
                    bar.show();
                }
                else {
                    Snackbar bar = Snackbar.make(v, "Record NOT Found!", Snackbar.LENGTH_LONG);
                    bar.show();
                }
                dbh.close();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.insert) {
            Intent i = new Intent(MainActivity.this,Insert.class);
            startActivity(i);
        } else if (id == R.id.update) {
            Intent i = new Intent(MainActivity.this,Update.class);
            startActivity(i);
        } else if (id == R.id.delete) {
            Intent i = new Intent(MainActivity.this,Delete.class);
            startActivity(i);
        } else if (id == R.id.show) {
            Intent i = new Intent(MainActivity.this,Show.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
