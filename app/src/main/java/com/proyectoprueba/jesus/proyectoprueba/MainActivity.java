package com.proyectoprueba.jesus.proyectoprueba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Response;
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements com.android.volley.Response.Listener<JSONObject>, com.android.volley.Response.ErrorListener {
    private String user, password;
    private EditText etUser, etPassword;
    private SharedPreferences sharedPref;
    RequestQueue rq;

    JsonRequest jrq;
    String UserRespuesta;
    String nombre_cliente, apellido_cliente, telefono_cliente, contrasena_cliente, correo_cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);
        //INSTANCIAMOS EL CONTEXT DE LA APLICACION Y DECLARAMOS EL NOMBRE DEL SHAREDPREFERENCES
        Context context = this.getApplicationContext();
        sharedPref = context.getSharedPreferences("preference_file_key", Context.MODE_PRIVATE);
        rq = Volley.newRequestQueue(this);
    }


    public void login(View v) {
        //REALIZAR LA CONSULTA A LA BASE DE DATOS CON EL ARCHIVO 'LOGIN.PHP' Y OBTENER UN JSON DE RESPUESTA
        String user = etUser.getText().toString();
        String password = etPassword.getText().toString();
        String url = "https://oficis.000webhostapp.com/login.php?user_usuario=" + user + "&pass_usuario=" + password;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);


    }
    @Override
    public void onErrorResponse(VolleyError error) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Incorrecto");
        dialogo1.setMessage("Verifique sus datos");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }

        });

        dialogo1.show();
    }

    public void aceptar() {

    }




    @Override
    public void onResponse(JSONObject response) {

        JSONArray jsonArray= null;

        try {
            jsonArray = response.getJSONArray("datos");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try{
            //ASIGNA LOS VALORES DEL ARREGLO A SU RESPECTIVA VARIABLE
            jsonObject= jsonArray.getJSONObject(0);
            nombre_cliente=  jsonObject.optString("nombre_usuario");
            apellido_cliente =jsonObject.optString("apellido_usuario");
            telefono_cliente= jsonObject.optString(" telefono_usuario");
            correo_cliente =jsonObject.optString("correo_usuario");
            contrasena_cliente= jsonObject.optString("pass_usuario");

        }catch(JSONException e){
            e.printStackTrace();
        }
        //GUARDAR LOS DATOS DEL USUARIO CON SHAREDPREFERENCES Y ABRIR EL ACTIVITY PRINCIPAL
        Intent i = new Intent(this, principal.class);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nombre_cliente",nombre_cliente);
        editor.putString("apellido_cliente",apellido_cliente);
        editor.putString("telefono_cliente",telefono_cliente);
        editor.putString("contrasena_cliente",contrasena_cliente);
        editor.putString("correo_cliente",correo_cliente);
        editor.commit();


        startActivity(i);
        finish();
    }
    public void registro(View v){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);

    }
}
