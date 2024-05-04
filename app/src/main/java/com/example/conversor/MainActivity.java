package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    Spinner spn;
    TextView tempVal;
    Button btn;
    conversores miObj = new conversores();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbh= findViewById(R.id.TbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("LON").setContent(R.id.tabLongitud).setIndicator("LONGITUD",null));
        tbh.addTab(tbh.newTabSpec("ALM").setContent(R.id.tabAlmacenamiento).setIndicator("ALMACENAMIENTO",null));
        tbh.addTab(tbh.newTabSpec("MON").setContent(R.id.tabMonedas).setIndicator("MONEDAS",null));
        btn=findViewById(R.id.btnConvertirLongitud);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn=findViewById(R.id.spnDeLongitud);
                int de = spn.getSelectedItemPosition();
                spn=findViewById(R.id.spnADeLongitud);
                int a =spn.getSelectedItemPosition();
                tempVal=findViewById(R.id.txtCantidadLongitud);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double respuesta = miObj.convertir(0,de,a,cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta "+ respuesta, Toast.LENGTH_SHORT).show();
            }
        });
        btn=findViewById(R.id.btnConvertirAlmacenmiento);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn=findViewById(R.id.spnAAlmacenamiento);
                int de = spn.getSelectedItemPosition();
                spn=findViewById(R.id.spnDeAlmacenamiento);
                int a =spn.getSelectedItemPosition();
                tempVal=findViewById(R.id.txtCantidadAlmacenamiento);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double respuesta = miObj.convertir(1,de,a,cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta "+ respuesta, Toast.LENGTH_SHORT).show();
            }
        });
        btn=findViewById(R.id.btnConvertirMonedas);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn=findViewById(R.id.spnDeMonedas);
                int de = spn.getSelectedItemPosition();
                spn=findViewById(R.id.spnAMonedas);
                int a =spn.getSelectedItemPosition();
                tempVal=findViewById(R.id.txtCantidadMonedas);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double respuesta = miObj.convertir(2,de,a,cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta "+ respuesta, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
class conversores{
    double[][] valores ={
            {1,100,39.3701,3.28084,1.193,1.09361,0.001,0.000621371},
            {1,8, 1024, 1.048576, 1.073741824, 1.0995116277761, 125.899906842624, 1.152921504606846976, 1.180591620717411303424, 1.208925819614629174706176},
            {1,0.93,83.1,149.25,91.39,4.95,0.88},
    };
    public double convertir(int opcion,int de, int a, double cantidad){
        return valores[opcion][a]/valores[opcion][de]*cantidad;
    }
};
