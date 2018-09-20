package com.proyectoprueba.jesus.proyectoprueba;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Historial extends AppCompatActivity implements com.android.volley.Response.Listener<JSONObject>, com.android.volley.Response.ErrorListener {
    private HeaderAdapter_Historial headerAdapter_historial;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private SharedPreferences sharedPref;
    String correo_cliente, correo_prestador, fecha, hora_inicio, hora_final;
    int costo,calificacion_prestador,tipo_pago;
    Context context;
    JsonRequest jrq;
    RequestQueue rq;
    List items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
         context = this.getApplicationContext();

        sharedPref = context.getSharedPreferences("preference_file_key",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String nombre=  sharedPref.getString("nombre_cliente","");
        String email = sharedPref.getString("correo_cliente","");

        rq = Volley.newRequestQueue(this);
        String url = "https://oficis.000webhostapp.com/historial.php?user_email=" + email ;
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        items = new ArrayList();





// Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador_historial);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new HeaderAdapter_Historial(items,this);



        recycler.setAdapter(adapter);
       // items.add(new Historial_formato("putita","yes","lol",1,"10","11",1,2));
        JSONArray jsonArray= null;

        try {
            jsonArray = response.getJSONArray("datos");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try{
            //ASIGNA LOS VALORES DEL ARREGLO A SU RESPECTIVA VARIABLE

            for (int i=0;i<jsonArray.length();i++) {

                jsonObject = jsonArray.getJSONObject(i);
                
                correo_cliente=jsonObject.optString("correo_cliente");
                correo_prestador=jsonObject.optString("correo_prestador");
                fecha=jsonObject.optString("fecha");
                costo=jsonObject.optInt("costo");
                hora_inicio=jsonObject.optString("hora_inicio");
                hora_final=jsonObject.optString("hora_final");
                calificacion_prestador=jsonObject.optInt("calificacion_prestador");
                tipo_pago=jsonObject.optInt("tipo_pago");

                items.add(new Historial_formato(correo_cliente,correo_prestador,fecha,costo,hora_inicio,hora_final,calificacion_prestador,tipo_pago));


            }
        }catch(JSONException e){
            e.printStackTrace();
        }
    }


}

