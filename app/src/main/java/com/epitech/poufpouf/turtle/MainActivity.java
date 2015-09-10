package com.epitech.poufpouf.turtle;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
{
    private Button Reset = null;
    private Button Confirm = null;
    private EditText VilleDepart = null;
    private EditText VilleArriver = null;
    private EditText HeurArriver = null;
    private EditText MinArriver = null;
    private EditText HeurDepart = null;
    private EditText MinDapart = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuration);
        Reset = (Button) findViewById(R.id.BReset);
        Confirm = (Button) findViewById(R.id.BConfirm);
        VilleDepart = (EditText) findViewById(R.id.DepartL);
        VilleArriver = (EditText) findViewById(R.id.ArriveL);
        HeurDepart  = (EditText) findViewById(R.id.DepartH);
        MinDapart  = (EditText) findViewById(R.id.DepartM);
        HeurArriver = (EditText) findViewById(R.id.arriveH);
        MinArriver = (EditText) findViewById(R.id.arriveM);

        Reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View vue)
            {
                VilleDepart.setText("");
                VilleArriver.setText("");
                HeurDepart.setText("");
                MinDapart.setText("");
                HeurArriver.setText("");
                MinArriver.setText("");
            }
        });
        Confirm = (Button) findViewById(R.id.BConfirm);
        Confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if("".equals(VilleDepart.getText().toString().trim()))
                {
                    Toast.makeText(MainActivity.this, "Merci de saisir un lieu de départ", Toast.LENGTH_SHORT).show();
                }
                else if("".equals(VilleArriver.getText().toString().trim()))
                {
                    Toast.makeText(MainActivity.this, "Merci de saisir un lieu d'arrivée", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    final Intent intent = new Intent(MainActivity.this, Trajet.class);
                    intent.putExtra("DEPART", VilleDepart.getText().toString().trim());
                    intent.putExtra("ARRIVEE", VilleArriver.getText().toString().trim());
                    MainActivity.this.startActivity(intent);
                }
                //Intent secondeActivite = new Intent(MainActivity.this, Trajet.class);
                //startActivity(secondeActivite);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }
}
