package com.caruaru.pe.clima.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.caruaru.pe.clima.R;
import com.caruaru.pe.clima.models.Clima;
import com.caruaru.pe.clima.transactions.GetClimaTransaction;
import com.caruaru.pe.clima.transactions.GetClimaView;
import com.caruaru.pe.clima.transactions.TransactionTask;

public class MainActivity extends AppCompatActivity implements GetClimaView {

    TextView txtClima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtClima = findViewById(R.id.txtClima);

        buscar("Caruaru,br");
    }

    public void buscar(String endereco){
        new TransactionTask(this,
                new GetClimaTransaction(this,endereco),R.string.aguarde).execute(new Void[0]);
    }

    @Override
    public void setClima(Clima clima) {

        this.txtClima.setText("Temperatura: "+clima.getTemperatura());
    }
}
