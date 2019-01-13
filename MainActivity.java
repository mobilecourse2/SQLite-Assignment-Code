package com.example.muhammad.databaseproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

EditText Name,Pass,oldname,newname,delname;
Button button,button1,button2,button3;


MyDbAdapter myDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.et1);
        Pass=findViewById(R.id.et2);
        oldname=findViewById(R.id.et3);
        newname=findViewById(R.id.et4);
        delname=findViewById(R.id.et5);

        button = findViewById(R.id.btn1);
        button1= findViewById(R.id.btn2);
        button2=findViewById(R.id.btn3);
        button3= findViewById(R.id.btn4);


        myDbAdapter = new MyDbAdapter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String t1 = Name.getText().toString();
                String t2 = Pass.getText().toString();
                if (t1.isEmpty() || t2.isEmpty()) {
                    Message.message(getApplicationContext(), "Enter Both Name and Password");
                } else {
                    long id = myDbAdapter.insertData(t1, t2);
                    if (id <= 0) {
                        Message.message(getApplicationContext(), "Insertion Unsuccessful");
                        Name.setText("");
                        Pass.setText("");
                    } else {
                        Message.message(getApplicationContext(), "Insertion Successful");
                        Name.setText("");
                        Pass.setText("");
                    }


                }
            }});

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = myDbAdapter.getData();
                Message.message(getApplicationContext(),data);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u1 = oldname.getText().toString();
                String u2 = newname.getText().toString();
                if(u1.isEmpty() || u2.isEmpty())
                {
                    Message.message(getApplicationContext(),"Enter Data");
                }
                else
                {
                    int a= myDbAdapter.updateName( u1, u2);
                    if(a<=0)
                    {
                        Message.message(getApplicationContext(),"Unsuccessful");
                         oldname.setText("");
                         newname.setText("");
                    } else {
                        Message.message(getApplicationContext(),"Updated");
                        oldname.setText("");
                        newname.setText("");
                    }
                }

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = delname.getText().toString();
                if(uname.isEmpty())
                {
                    Message.message(getApplicationContext(),"Enter Data");
                }
                else{
                    int a= myDbAdapter.delete(uname);
                    if(a<=0)
                    {
                        Message.message(getApplicationContext(),"Unsuccessful");
                        delname.setText("");
                    }
                    else
                    {
                        Message.message(getApplicationContext(), "DELETED");
                        delname.setText("");
                    }
                }







            }
        });



    }
}
