package shivamkumarjha.sqliteassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shivam on 24/5/17.
 */

public class DBHome extends SQLiteOpenHelper {

    public HashMap<String,ArrayList<String>> getData()
    {
        HashMap<String,ArrayList<String>> store=new HashMap<>();
        ArrayList <String> no= new ArrayList<>();
        ArrayList <String> name= new ArrayList<>();
        ArrayList <String> age= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"sno","sname","sage"};
        Cursor cur = db.query("student",cols,null,null,null,null,null,null);
        if (cur.moveToFirst()){
            do {
                no.add(cur.getInt(0)+"");
                name.add(cur.getString(1));
                age.add(cur.getInt(2)+"");
            }while (cur.moveToNext());
            db.close();
        }
        store.put("sno",no);
        store.put("sname",name);
        store.put("sage",age);
        cur.close();
        return store;
    }

    public void updateData(int s1, String s2, int s3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sname",s2);
        cv.put("sage",s3);
        db.update("student",cv,"sno=?",new String[]{s1+""});
        db.close();
    }

    public void deleteData(int s1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("student","sno=?",new String[]{s1+""});
        db.close();
    }

    public void insertData(int s1, String s2, int s3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sno",s1);
        cv.put("sname",s2);
        cv.put("sage",s3);
        db.insert("student",null,cv);
        db.close();
    }

    public boolean verification(String _username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT 1 FROM student WHERE sname=?", new String[] {_username});
        boolean exists = c.moveToFirst();
        c.close();
        return exists;
    }

    Context con;
    public DBHome(Context context) {
        super(context, "STUDENTDB", null, 1);
        con=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String t1= "create table student(sno integer, sname text, sage integer);";
        db.execSQL(t1);
        //t1 = "insert into student";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}