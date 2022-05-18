package com.example.dialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewContact extends AppCompatActivity {

    EditText name;
    EditText contact;

    Button adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        String nameX = bundle.getString("nameX");
        String nameY = bundle.getString("nameY");
        String nameZ = bundle.getString("nameZ");
        String contactX = bundle.getString("contactX");
        String contactY = bundle.getString("contactY");
        String contactZ = bundle.getString("contactZ");

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contacto);

        name.setInputType(InputType.TYPE_CLASS_TEXT);
        contact.setInputType(InputType.TYPE_CLASS_NUMBER);

        adicionar = findViewById(R.id.adicionar);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewContact.this, MainActivity.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("contacto", contact.getText().toString());
                intent.putExtra("nameX", nameX);
                intent.putExtra("nameY", nameY);
                intent.putExtra("nameZ", nameZ);
                intent.putExtra("contactX", contactX);
                intent.putExtra("contactY", contactY);
                intent.putExtra("contactZ", contactZ);
                intent.putExtra("id", id);
                startActivity(intent);
                onPause();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}