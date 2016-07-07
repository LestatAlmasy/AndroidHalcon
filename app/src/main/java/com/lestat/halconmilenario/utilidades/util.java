package com.lestat.halconmilenario.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.client.Response;

/**
 * Created by Lestat on 07-07-2016.
 */
public class util {

    public util() {
    }

    public String responseService(Response response){
        String result = "";
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(response.getBody().in()));
            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = sb.toString();
        return result;
    }
}
