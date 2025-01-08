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

public class mPut extends AppCompatActivity {

    private EditText txtLado;
    private TextView txtResultado;
    private Button btnProcesar;
    Conexion con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mput);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtLado=findViewById(R.id.txtLado);
        btnProcesar=findViewById(R.id.btnProcesar);
        txtResultado=findViewById(R.id.txtResultado);

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lado=txtLado.getText().toString().trim();
                con= new Conexion();
                new Thread(() -> {
                    Log.d("Conexion", "Datos enviados: lado=" + lado );
                    String respuesta = con.putRequest("http://10.0.2.2:3000/mput", lado);
                    runOnUiThread(() -> txtResultado.setText(respuesta));
                    Log.d("Conexion", "Respuesta: " + respuesta);
                }).start();
            }
        });
    }
}