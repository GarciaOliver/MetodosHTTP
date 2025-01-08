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

import java.util.ArrayList;

public class mDelete extends AppCompatActivity {

    TextView txtLista;
    TextView txtAviso;
    EditText txtCedula;
    Button btnEliminar;
    Conexion con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mdelete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtLista=findViewById(R.id.txtLista);
        txtLista=findViewById(R.id.txtAviso);
        txtCedula=findViewById(R.id.txtCedula);
        btnEliminar=findViewById(R.id.btnEliminar);

        ArrayList<String[]> personas = new ArrayList<>();

        personas.add(new String[]{"0123456789", "Juan Pérez"});
        personas.add(new String[]{"0987654321", "María López"});
        personas.add(new String[]{"1234567890", "Carlos García"});

        String lista="Lista de personas\n";
        for (String[] persona : personas) {
            lista += "Cédula: " + persona[0] + ", Nombre: " + persona[1] + "\n";
        }

        txtLista.setText(lista);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cedulaEliminar = txtCedula.getText().toString().trim();
                con= new Conexion();

                for (int i = 0; i < personas.size(); i++) {
                    if (personas.get(i)[0].equals(cedulaEliminar)) {
                        personas.remove(i);

                        String Newlista="Lista de personas\n";
                        for (String[] persona : personas) {
                            Newlista += "Cédula: " + persona[0] + ", Nombre: " + persona[1] + "\n";
                        }
                        txtLista.setText(Newlista);

                        new Thread(() -> {
                            Log.d("Conexion", "Datos enviados: Cedula=" + cedulaEliminar);
                            String respuesta = con.deleteRequest("http://10.0.2.2:3000/mdelete", cedulaEliminar);
                            runOnUiThread(() -> txtAviso.setText(respuesta));
                            Log.d("Conexion", "Respuesta: " + respuesta);
                        }).start();
                        break;
                    }else{
                        txtAviso.setText("No se encontraron coincidencias");
                    }
                }


            }
        });


    }
}