package mx.edu.utng.colvera.calculadorag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    CalculadoraCientifica cientifica = new CalculadoraCientifica();
    CalculadoraNormal normal = new CalculadoraNormal();
    EditText txtNumero1;
    EditText txtNumero2;
    EditText txtResultado;
    Spinner cmbCalculadora;
    Button btnSumar;
    Button btnRestar;
    Button btnMultiplicar;
    Button btnDividir;
    Button btnLimpiar;
    Button btnFactorial;
    int op;
    Button btncreditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero1 = (EditText)findViewById(R.id.txt_numero1);
        txtNumero2 = (EditText)findViewById(R.id.txt_numero2);
        txtResultado = (EditText)findViewById(R.id.txt_resultado);
        cmbCalculadora = (Spinner)findViewById(R.id.cmb_opciones);
        btnSumar = (Button)findViewById(R.id.btn_sumar);
        btnRestar = (Button)findViewById(R.id.btn_restar);
        btnMultiplicar = (Button)findViewById(R.id.btn_multiplicar);
        btnDividir = (Button)findViewById(R.id.btn_dividir);
        btnLimpiar = (Button)findViewById(R.id.btn_limpiar);
        btnFactorial = (Button)findViewById(R.id.btn_factorial);
        cmbCalculadora.setOnItemSelectedListener(this);
        btncreditos = (Button)findViewById(R.id.btn_creditos);

        btncreditos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),CreditosActivity.class);
                startActivity(intent);

            }
        });


        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1;
                double num2;
                double total=0;

                num1 = Double.parseDouble(txtNumero1.getText().toString());
                num2 = Double.parseDouble(txtNumero2.getText().toString());

                total = cientifica.sumar(num1,num2);
                total = normal.sumar(num1,num2);

                txtResultado.setText(""+total);
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1;
                double num2;
                double total=0;

                num1 = Double.parseDouble(txtNumero1.getText().toString());
                num2 = Double.parseDouble(txtNumero2.getText().toString());

                total = cientifica.restar(num1,num2);
                total = normal.restar(num1,num2);

                txtResultado.setText(""+total);
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1;
                double num2;
                double total=0;

                num1 = Double.parseDouble(txtNumero1.getText().toString());
                num2 = Double.parseDouble(txtNumero2.getText().toString());

                total = normal.multiplicacion(num1,num2);

                txtResultado.setText(""+total);
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1;
                double num2;
                double total=0;

                num1 = Double.parseDouble(txtNumero1.getText().toString());
                num2 = Double.parseDouble(txtNumero2.getText().toString());

                total = normal.division(num1,num2);

                txtResultado.setText(""+total);
            }
        });

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1;
                double total=0;

                num1 = Double.parseDouble(txtNumero1.getText().toString());

                total = cientifica.factorial(num1);

                txtResultado.setText(""+total);
            }
        });


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtNumero1.setText("");
                txtNumero2.setText("");
                txtResultado.setText("");

            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        op = (int) cmbCalculadora.getSelectedItemId();
        switch (op){
            case 0:
                btnFactorial.setVisibility(View.GONE);
                btnDividir.setVisibility(View.VISIBLE);
                btnMultiplicar.setVisibility(View.VISIBLE);
                break;
            case 1:
                btnDividir.setVisibility(View.GONE);
                btnMultiplicar.setVisibility(View.GONE);
                btnFactorial.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
