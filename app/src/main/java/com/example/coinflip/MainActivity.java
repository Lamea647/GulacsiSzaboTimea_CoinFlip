package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonFej, buttonIras;
    private TextView textViewDobasok, textViewGyozelem, textViewVereseg;
    private ImageView imageViewHeads;
    private Random random;
    private int sorsoltDobas, tippeltDobas, dobasokSzama, gyozelemSzama, veresegSzama;

    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonFej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tippeltDobas = 0;
                sorsoltDobas = random.nextInt(2); //0-1
                if (sorsoltDobas == 0){
                    Toast.makeText(MainActivity.this, "FEJ", Toast.LENGTH_SHORT).show();
                    imageViewHeads.setImageResource(R.drawable.heads);
                    dobasokSzama++;
                    textViewDobasok.setText("Dobások: " + String.valueOf(dobasokSzama));
                    gyozelemSzama++;
                    textViewGyozelem.setText("Győzelem: " + String.valueOf(gyozelemSzama));
                    ellenorzes();
                }
                else{
                    Toast.makeText(MainActivity.this, "ÍRÁS", Toast.LENGTH_SHORT).show();
                    imageViewHeads.setImageResource(R.drawable.tails);
                    dobasokSzama++;
                    textViewDobasok.setText("Dobások: " + String.valueOf(dobasokSzama));
                    veresegSzama++;
                    textViewVereseg.setText("Vereség: " + String.valueOf(veresegSzama));
                    ellenorzes();
                }
            }
        });

        buttonIras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tippeltDobas = 1;
                sorsoltDobas = random.nextInt(2); //0-1
                if (sorsoltDobas == 1){
                    Toast.makeText(MainActivity.this, "ÍRÁS", Toast.LENGTH_SHORT).show();
                    imageViewHeads.setImageResource(R.drawable.tails);
                    dobasokSzama++;
                    textViewDobasok.setText("Dobások: " + String.valueOf(dobasokSzama));
                    gyozelemSzama++;
                    textViewGyozelem.setText("Győzelem: " + String.valueOf(gyozelemSzama));
                    ellenorzes();
                }
                else{
                    Toast.makeText(MainActivity.this, "FEJ", Toast.LENGTH_SHORT).show();
                    imageViewHeads.setImageResource(R.drawable.heads);
                    dobasokSzama++;
                    textViewDobasok.setText("Dobások: " + String.valueOf(dobasokSzama));
                    veresegSzama++;
                    textViewVereseg.setText("Vereség: " + String.valueOf(veresegSzama));
                    ellenorzes();
                }
            }
        });
    }

    public void init() {
        buttonFej = findViewById(R.id.buttonFej);
        buttonIras = findViewById(R.id.buttonIras);
        textViewDobasok = findViewById(R.id.textViewDobasok);
        textViewGyozelem = findViewById(R.id.textViewGyozelem);
        textViewVereseg = findViewById(R.id.textViewVereseg);
        imageViewHeads = findViewById(R.id.imageViewHeads);
        random = new Random();
        dobasokSzama = 0;
        gyozelemSzama = 0;
        veresegSzama = 0;
        AlertDialogCreate();
    }

    public void ellenorzes(){
        if (dobasokSzama == 5){
            if (veresegSzama > gyozelemSzama){
                alertDialog.setTitle("Vereség");
                alertDialog.create();
                alertDialog.show();
            }else{
                alertDialog.setTitle("Győzelem");
                alertDialog.create();
                alertDialog.show();
            }
        }
    }

    public void AlertDialogCreate() {
        alertDialog= new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Szeretne új játékot játszani?");
        alertDialog.setNegativeButton("NEM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setPositiveButton("IGEN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetGame();
            }
        });
        alertDialog.create();
    }

    public void resetGame() {
        dobasokSzama = 0;
        gyozelemSzama = 0;
        veresegSzama = 0;
        imageViewHeads.setImageResource(R.drawable.heads);
        textViewDobasok.setText("Dobások: " + String.valueOf(dobasokSzama));
        textViewGyozelem.setText("Győzelem: " + String.valueOf(gyozelemSzama));
        textViewVereseg.setText("Vereség: " + String.valueOf(veresegSzama));
        AlertDialogCreate();
    }
}