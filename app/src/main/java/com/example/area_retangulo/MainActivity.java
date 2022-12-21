package com.example.area_retangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

    public class MainActivity extends AppCompatActivity {

        private EditText edtAltura, edtBase;
        private Button btnCalcular, btnLimpar;
        private TextView txtResultado;
        private Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtBase = (EditText)findViewById(R.id.edtBase);
        edtAltura = (EditText)findViewById(R.id.edtAltura);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);
        txtResultado = (TextView)findViewById(R.id.txtResultado);
        res=getResources();
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float base, altura, area;
                try {
                    base = Float.parseFloat(edtBase.getText().toString());
                    altura = Float.parseFloat(edtAltura.getText().toString());
                    area = (float)(base*altura);
                    txtResultado.setText(String.format(res.getString(R.string.texto_resultado)) + " " + area);
                } catch (Exception erro) {
                    Toast.makeText(getApplicationContext(), String.format(res.getString(R.string.erro)), Toast.LENGTH_LONG).show();

                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtAltura.setText("");
                edtBase.setText("");
                txtResultado.setText(String.format(res.getString(R.string.resultado)));
                edtBase.requestFocus();
            }
        });
    }
}