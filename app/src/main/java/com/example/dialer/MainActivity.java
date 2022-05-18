package com.example.dialer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    Button call, x, y, z;
    EditText e;

    String nameX = "", nameY = "", nameZ = "";
    String contactX = "+", contactY = "+", contactZ = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            int id = extras.getInt("id");

            nameX = extras.getString("nameX");
            nameY = extras.getString("nameY");
            nameZ = extras.getString("nameZ");
            contactX = extras.getString("contactX");
            contactY = extras.getString("contactY");
            contactZ = extras.getString("contactZ");

            String nomeaux = extras.getString("name");
            String contactaux =  extras.getString("contacto");

            switch (id)
            {
                case R.id.x:
                    nameX = nomeaux;
                    contactX = contactaux;
                break;
                case R.id.y:
                    nameY = nomeaux;
                    contactY = contactaux;
                break;
                case R.id.z:
                    nameZ = nomeaux;
                    contactZ = contactaux;
                break;
            }

            Button x = findViewById(R.id.x);
            x.setText(nameX);
            x.setHint(contactX);

            Button y = findViewById(R.id.y);
            y.setText(nameY);
            y.setHint(contactY);

            Button z = findViewById(R.id.z);
            z.setText(nameZ);
            z.setHint(contactZ);
        }

        e = findViewById(R.id.editTextPhone);
        call = findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use format with "tel:" and phoneNumber created is stored in u.
                Uri u = Uri.parse("tel:" + e.getText().toString());

                Intent intent = new Intent(Intent.ACTION_DIAL, u);
                startActivity(intent);
            }
        });

        x = findViewById(R.id.x);
        x.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dialer(R.id.x);
                return false;
            }
        });

        y = findViewById(R.id.y);
        y.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dialer(R.id.y);
                return false;
            }
        });

        z = findViewById(R.id.z);
        z.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dialer(R.id.z);
                return false;
            }
        });
    }

    public void buttonClickEvent(View v)
    {
        String concat = e.getText().toString();

        switch (v.getId()) {
            case R.id.one:
                e.setText("");
                concat += "1";
                e.setText(concat);
                break;
            case R.id.two:
                e.setText("");
                concat += "2";
                e.setText(concat);
            case R.id.three:
                concat += "3";
                e.setText(concat);
                break;
            case R.id.four:
                e.setText("");
                concat += "4";
                e.setText(concat);
                break;
            case R.id.five:
                e.setText("");
                concat += "5";
                e.setText(concat);
                break;
            case R.id.six:
                e.setText("");
                concat += "6";
                e.setText(concat);
                break;
            case R.id.seven:
                e.setText("");
                concat += "7";
                e.setText(concat);
                break;
            case R.id.eight:
                e.setText("");
                concat += "8";
                e.setText(concat);
                break;
            case R.id.nine:
                e.setText("");
                concat += "9";
                e.setText(concat);
                break;
            case R.id.plus:
                e.setText("");
                concat += "+";
                e.setText(concat);
                break;
            case R.id.zero:
                e.setText("");
                concat += "0";
                e.setText(concat);
                break;
            case R.id.cardinal:
                e.setText("");
                concat += "#";
                e.setText(concat);
                break;
            case R.id.delete:
                e.setText("");
                if (concat != null && concat.length() > 0) {
                    concat = concat.substring(0, concat.length() - 1);
                }
                e.setText(concat);
        }
    }

    public void dialer(int resource)
    {
        Button button = findViewById(resource);

        if(button.getText().equals(""))
        {
            /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Adicionar Contacto");

            final EditText name = new EditText(MainActivity.this);
            final EditText number = new EditText(MainActivity.this);

            name.setInputType(InputType.TYPE_CLASS_TEXT);
            number.setInputType(InputType.TYPE_CLASS_NUMBER);

            LinearLayout ll = new LinearLayout(MainActivity.this);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.addView(name);
            name.setHint("Nome");
            ll.addView(number);
            number.setHint("Número");
            alertDialog.setView(ll);

            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("Adicionar",  new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    button.setText(name.getText());
                    button.setHint(number.getText());
                }
            });

            AlertDialog alert = alertDialog.create();
            alert.show();*/

            Intent intent = new Intent(MainActivity.this, NewContact.class);
            intent.putExtra("id", resource);
            intent.putExtra("nameX", nameX);
            intent.putExtra("nameY", nameY);
            intent.putExtra("nameZ", nameZ);
            intent.putExtra("contactX", contactX);
            intent.putExtra("contactY", contactY);
            intent.putExtra("contactZ", contactZ);
            startActivity(intent);
            onPause();
        }

        else
        {
            // Use format with "tel:" and phoneNumber created is stored in u.
            Uri u = Uri.parse("tel:" + button.getHint().toString());

            Intent intent = new Intent(Intent.ACTION_DIAL, u);
            startActivity(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}