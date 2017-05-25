package shivamkumarjha.sqliteassignment;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Delete extends AppCompatActivity {

    EditText e;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        e = (EditText) findViewById(R.id.e4);
        b = (Button) findViewById(R.id.b4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHome d = new DBHome(Delete.this);
                d.deleteData(Integer.parseInt(e.getText().toString()));
                Snackbar bar = Snackbar.make(v, "Record Deleted!", Snackbar.LENGTH_LONG);
                bar.show();
                d.close();
            }
        });
    }
}