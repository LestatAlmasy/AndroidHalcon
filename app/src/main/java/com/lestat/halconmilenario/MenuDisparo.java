package com.lestat.halconmilenario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lestat.halconmilenario.serviceClass.armaments;
import com.lestat.halconmilenario.utilidades.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Path;

public class MenuDisparo extends AppCompatActivity {

    Button buscar;
    util utilFun;
    String result="", codes="";
    ClientAPI servicio;
    EditText code;
    TextView textresult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_disparo);
        getSupportActionBar().hide();

        code = (EditText)findViewById(R.id.input_code);
        buscar = (Button)findViewById(R.id.boton_buscar);
        textresult = (TextView)findViewById(R.id.textresult);

        utilFun = new util();
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                servicio = new ClientAPI();
                code = (EditText)findViewById(R.id.input_code);
                if(TextUtils.isEmpty(code.getText())){
                    Toast toastAd = new Toast(getApplicationContext());
                    toastAd.makeText(getApplicationContext(), "Ingrese codigo", Toast.LENGTH_SHORT).show();
                    toastAd.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 0);
                }
                codes = code.getText().toString();
                servicio.getService().disparar(codes, new Callback<armaments>() {
                    @Override
                    public void success(armaments armaments, Response response) {
                        Log.d("llamado disparo","llamado");
                        result = utilFun.responseService(response);
                        Log.d("Result", "r:"+result);
                        if(result.equals("no existe este armamento")){
                            textresult.setText("No existe armamento");
                            textresult.setVisibility(View.VISIBLE);
                            //APARECER TEXTVIEW
                        }else {
                            try {
                                String json = result;
                                List<armaments> listaresponse = new ArrayList<armaments>();
                                JSONArray object = new JSONArray(json);
                                for(int i=0; i<object.length();i++) {
                                    JSONObject jsonObject = object.getJSONObject(i);
                                    if((jsonObject.getInt("idDisparo")) == 1){
                                        textresult.setText("Buen disparo");
                                    }else{
                                        if((jsonObject.getInt("idDisparo")) == 2){
                                            textresult.setText("Medio el disparo");
                                        }else{
                                            if((jsonObject.getInt("idDisparo")) == 3){
                                                textresult.setText("Malo el disparo");
                                            }
                                        }
                                    }
                                }
                                //nse.add(new _ingresosBooster(json_array.getJSONObject(i)));
                                } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("error:",error.getMessage());
                    }
                });
            }
        });



    }
}
