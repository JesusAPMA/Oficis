package com.proyectoprueba.jesus.proyectoprueba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    private final int DURACION_SPLASH = 2000;
private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent1 = new Intent(Splash.this, MainActivity.class);
                Intent intent2 = new Intent(Splash.this, principal.class);
                SharedPreferences appSettings =
                        getSharedPreferences("preference_file_key",
                                Context.MODE_PRIVATE);
                String user= appSettings.getString("telefono_cliente","");
                String password=appSettings.getString("contrasena_cliente","");
                if (user=="" && password=="") {
                    startActivity(intent1);
                    finish();
                }else {
                    startActivity(intent2);
                    finish();
                }

            }

            ;
        }, DURACION_SPLASH);


    }

}