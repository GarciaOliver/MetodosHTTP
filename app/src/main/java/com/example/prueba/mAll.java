package com.example.prueba;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mAll extends AppCompatActivity {

    private TextView txtMetodo;
    private Button btnAllPost;
    private Button btnAllPut;
    private Button btnAllGet;
    Conexion con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mall);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAllPost=findViewById(R.id.btnAllPost);
        btnAllPut=findViewById(R.id.btnAllPut);
        btnAllGet=findViewById(R.id.btnAllGet);

        btnAllPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                con= new Conexion();
                new Thread(() -> {
                    String respuesta = con.allRequest("http://10.0.2.2:3000/mall", "POST");
                    runOnUiThread(() -> txtMetodo.setText(respuesta));
                    Log.d("Conexion", "Respuesta: " + respuesta);
                }).start();
            }
        });

        btnAllPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                con= new Conexion();
                new Thread(() -> {
                    String respuesta = con.allRequest("http://10.0.2.2:3000/mall", "PUT");
                    runOnUiThread(() -> txtMetodo.setText(respuesta));
                    Log.d("Conexion", "Respuesta: " + respuesta);
                }).start();
            }
        });

        btnAllGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                con= new Conexion();
                new Thread(() -> {
                    String respuesta = con.allRequest("http://10.0.2.2:3000/mall", "GET");
                    runOnUiThread(() -> txtMetodo.setText(respuesta));
                    Log.d("Conexion", "Respuesta: " + respuesta);
                }).start();
            }
        });
    }
}