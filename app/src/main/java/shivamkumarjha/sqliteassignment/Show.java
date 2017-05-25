package shivamkumarjha.sqliteassignment;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Show extends AppCompatActivity {
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        l = (ListView) findViewById(R.id.l1);
        final DBHome d = new DBHome(Show.this);
        ArrayAdapter name = new ArrayAdapter(Show.this,android.R.layout.simple_list_item_1,d.getData().get("sname"));
        l.setAdapter(name);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar bar = Snackbar.make(view, "No\t"+d.getData().get("sno").get(position)
                        +"\tAge\t"+d.getData().get("sage").get(position), Snackbar.LENGTH_INDEFINITE);
                bar.show();
            }
        });
        d.close();
    }
}