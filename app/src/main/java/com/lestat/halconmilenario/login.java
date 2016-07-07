package com.lestat.halconmilenario;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lestat.halconmilenario.serviceClass.events;
import com.lestat.halconmilenario.utilidades.util;

import org.json.JSONObject;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class login extends AppCompatActivity {

    ClientAPI restService;
    Button customInicio;
    String correo,pass, result;
    events in = new events();
    util utilfun;
    EditText customUsuario, customPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        restService = new ClientAPI();

        customUsuario = (EditText) findViewById(R.id.input_usuario);
        customPass = (EditText)findViewById(R.id.input_pass);

        customUsuario.setCursorVisible(true);
        customPass.setCursorVisible(true);

        customInicio = (Button)findViewById(R.id.boton_iniciar_sesion);

        customInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(customUsuario.getText())){
                    Toast toastAd = new Toast(getApplicationContext());
                    toastAd.makeText(getApplicationContext(), "Ingrese correo", Toast.LENGTH_SHORT).show();
                    toastAd.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 0);
                }else{
                    if(TextUtils.isEmpty(customPass.getText())){
                        Toast toastAd = new Toast(getApplicationContext());
                        toastAd.makeText(getApplicationContext(), "Ingrese contraseña", Toast.LENGTH_SHORT).show();
                        toastAd.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 0);
                    }else{
                        customInicio.setText("Cargando. . . ");
                        correo = customUsuario.getText().toString();
                        pass = customPass.getText().toString();
                        in.setCategoria(correo);
                        in.setDescripcion(pass);

                        restService.getService().NuevoEvento(in, new retrofit.Callback<events>() {
                            @Override
                            public void success(events events, Response response) {
                                Log.d("Error","No se que pasa");
                                //result = utilfun.responseService(response);

                            }

                            @Override
                            public void failure(RetrofitError error) {
                                customInicio.setText(R.string.inicio);
                                Toast errorCon = new Toast(getApplicationContext());
                                errorCon.makeText(getApplicationContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
                                errorCon.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 0);
                            }
                        });
                    }
                }

            }
        });

    }
}
