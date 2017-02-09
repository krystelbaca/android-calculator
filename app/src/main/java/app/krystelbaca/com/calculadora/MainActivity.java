package app.krystelbaca.com.calculadora;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cajaTexto;
    EditText cajaTexto2;
    TextView etiqueta;
    Button btnSumar;
    Button btnRestar;
    Button btnMulti;
    Button btnDividir;
    Button btnClear;
    Double n1, n2;
    Double suma, resta, multi, division;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaTexto = (EditText) findViewById(R.id.editText);
        cajaTexto2 = (EditText) findViewById(R.id.editText2);
        etiqueta = (TextView) findViewById(R.id.textView2);
        btnSumar = (Button) findViewById(R.id.sumarbtn);
        btnRestar = (Button) findViewById(R.id.restarbtn);
        btnMulti = (Button) findViewById(R.id.multibtn);
        btnDividir = (Button) findViewById(R.id.dividirbtn);
        btnClear = (Button) findViewById(R.id.clearbtn);

        final View.OnClickListener oyente = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etiqueta.setText("Resultado");


                n1 = Double.parseDouble(cajaTexto.getText().toString());
                n2 = Double.parseDouble(cajaTexto2.getText().toString());
                switch (v.getId()) {
                    case R.id.sumarbtn:
                        suma = n1 + n2;
                        etiqueta.setText(String.valueOf(suma));
                        break;

                    case R.id.restarbtn:
                        resta = n1 - n2;
                        etiqueta.setText(String.valueOf(resta));
                        break;

                    case R.id.multibtn:
                        multi = n1 * n2;
                        etiqueta.setText(String.valueOf(multi));
                        break;

                    case R.id.dividirbtn:
                        try{
                            division = n1 / n2;
                        }catch (ArithmeticException e){
                            division = 0d;
                            Toast.makeText(MainActivity.this, "No se puede", Toast.LENGTH_SHORT).show();
                        }
                        etiqueta.setText(String.valueOf(division));

                        break;

                    case R.id.clearbtn:
                        cajaTexto.setText("");
                        cajaTexto2.setText("");

                }

            }
        };

        btnClear.setOnClickListener(oyente);
        btnSumar.setOnClickListener(oyente);
        btnRestar.setOnClickListener(oyente);
        btnMulti.setOnClickListener(oyente);
        btnDividir.setOnClickListener(oyente);


    }


}
