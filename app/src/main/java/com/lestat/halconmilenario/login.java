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
import com.lestat.halconmilenario.serviceClass.users;
import com.lestat.halconmilenario.utilidades.util;

import org.json.JSONObject;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class login extends AppCompatActivity {

    ClientAPI restService;
    Button customInicio;
    JSONObject resultJson;
    String correo,pass, result, user2;
    //events in = new events();
    users in = new users();
    util utilfun;
    EditText customUsuario, customPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        restService = new ClientAPI();
        utilfun = new util();
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
                        in.setUser(correo);
                        in.setPass(pass);

                        restService.getService().Login(in, new retrofit.Callback<users>() {
                            @Override
                            public void success(users users, Response response) {
                                result = utilfun.responseService(response);

                                try{
                                    resultJson = new JSONObject(result);
                                    user2 = resultJson.getString("user");

                                    if(user2.equals(in.getUser())){
                                        Toast errorCon = new Toast(getApplicationContext());
                                        errorCon.makeText(getApplicationContext(), "¡Exito! Ingresando...", Toast.LENGTH_SHORT).show();
                                        errorCon.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 0);
                                        //result = utilfun.responseService(response);
                                        Intent disparo = new Intent(login.this, MenuDisparo.class);
                                        startActivity(disparo);
                                        finish();

                                    }else{
                                        Toast errorCon = new Toast(getApplicationContext());
                                        errorCon.makeText(getApplicationContext(), "¡ERROR! Usuario no existe", Toast.LENGTH_SHORT).show();
                                        errorCon.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 0);

                                    }
                                }catch (Exception e) {
                                    customInicio.setText(R.string.inicio);
                                    Log.d("Excepcion", e.toString());
                                }
                            }
                            @Override
                            public void failure(RetrofitError error) {
                                Log.d("error:",error.getMessage());
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
