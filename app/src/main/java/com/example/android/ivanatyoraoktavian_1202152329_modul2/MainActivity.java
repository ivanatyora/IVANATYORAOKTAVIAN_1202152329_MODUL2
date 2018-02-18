package com.example.android.ivanatyoraoktavian_1202152329_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //ngarahin ke layoutnya
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOrder(View view) { //berasal dari button yang ada di layout activity_main.xml
        if (((RadioButton)findViewById(R.id.rbt_DineIn)).isChecked()){ //kondisi disaat yang dipilih adalah Dine In
            Intent intent = new Intent(this, DineIn.class); //pindah ke layout Dine In
            Toast.makeText(this,"Anda telah memilih Dine In",Toast.LENGTH_SHORT).show(); //pesan
            startActivity(intent);
        }else if (((RadioButton)findViewById(R.id.rbt_TakeAway)).isChecked()){ //kondisi saat yang dipilih itu Take Away
            Intent intent = new Intent(this, TakeAway.class); //pindah ke layout Take Away
            Toast.makeText(this,"Anda telah memilih Take Away",Toast.LENGTH_SHORT).show(); //pesan
            startActivity(intent);
        }else{
            Toast.makeText(this,"Pilih salah satu terlebih dahulu",Toast.LENGTH_SHORT).show(); //pesan jika tidak memilih DineIn ataupun Take Away
        }
    }
}

