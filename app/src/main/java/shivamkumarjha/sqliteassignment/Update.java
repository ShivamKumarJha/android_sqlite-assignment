package shivamkumarjha.sqliteassignment;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        b = (Button) findViewById(R.id.b);
        b.setText("UPDATE");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHome dbh = new DBHome(Update.this);
                dbh.updateData(Integer.parseInt(e1.getText().toString()),
                        e2.getText().toString(),
                        Integer.parseInt(e3.getText().toString()));
                Snackbar bar = Snackbar.make(v, "Data Updated!", Snackbar.LENGTH_LONG);
                bar.show();
                dbh.close();
            }
        });
    }
}