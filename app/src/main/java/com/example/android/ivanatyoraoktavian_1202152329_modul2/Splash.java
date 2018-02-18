package com.example.android.ivanatyoraoktavian_1202152329_modul2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toast.makeText(this,"IVANA TYORA OKTAVIAN_1202152329",Toast.LENGTH_SHORT).show(); //membuat pesan yang berisi IVANA TYORA OKTAVIAN_1202152329

        final Handler handler = new Handler(); //menjalankan splash screen
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class)); //pindah ke MainActivity
                finish();
            }
        }, 5000L); //lamanya splashscreen 5000 L = 5 detik
    }
}
