package shivamkumarjha.sqliteassignment;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Insert extends AppCompatActivity {

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
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().equals(""))
                {
                    e1.setError("Cannot be empty.");
                }
                else if(e2.getText().toString().equals(""))
                {
                    e2.setError("Cannot be empty.");
                }
                else if(e3.getText().toString().equals(""))
                {
                    e3.setError("Cannot be empty.");
                }
                else
                {
                    DBHome dbh = new DBHome(Insert.this);
                    dbh.insertData(Integer.parseInt(e1.getText().toString()),
                            e2.getText().toString(),
                            Integer.parseInt(e3.getText().toString()));
                    Snackbar bar = Snackbar.make(v, "Insertion successful!", Snackbar.LENGTH_LONG);
                    bar.show();
                    dbh.close();
                }
            }
        });
    }
}
