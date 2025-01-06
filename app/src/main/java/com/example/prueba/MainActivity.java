package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnPost;
    private Button btnPut;
    private Button btnDelete;
    private Button btnAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnPost= findViewById(R.id.btnPost);
        btnPut= findViewById(R.id.btnPut);
        btnDelete= findViewById(R.id.btnDelete);
        btnAll= findViewById(R.id.btnAll);

        btnPost.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, mPost.class)));
        btnPut.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, mPut.class)));
        btnDelete.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, mDelete.class)));
        btnAll.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, mAll.class)));
    }
}