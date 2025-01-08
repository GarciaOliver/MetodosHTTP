package com.example.prueba;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mPost extends AppCompatActivity {

    private EditText txtNum1;
    private EditText txtNum2;
    private TextView txtResult;
    private Button btnSumar;
    Conexion con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mpost);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNum1=findViewById(R.id.txtNum1);
        txtNum2=findViewById(R.id.txtNum2);
        btnSumar=findViewById(R.id.btnSumar);
        txtResult=findViewById(R.id.txtResult);


        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero1=txtNum1.getText().toString().trim();
                String numero2=txtNum2.getText().toString().trim();
                con= new Conexion();
                new Thread(() -> {
                    Log.d("Conexion", "Datos enviados: num1=" + numero1 + ", num2=" + numero2);
                    String respuesta = con.postRequest("http://10.0.2.2:3000/mpost", numero1, numero2);
                    runOnUiThread(() -> txtResult.setText(respuesta));
                    Log.d("Conexion", "Respuesta: " + respuesta);
                }).start();
            }
        });
    }
}