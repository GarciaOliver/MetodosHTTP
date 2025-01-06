package com.example.prueba;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conexion {
    public String postRequest(String requestUrl, String num1, String num2) {
        HttpURLConnection urlConnection = null;
        try {
            // Crear la URL
            URL url = new URL(requestUrl);

            // Abrir conexión
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true); // Habilitar salida para datos

            // Crear el objeto JSON para enviar
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("num1", num1);
            jsonParam.put("num2", num2);

            // Escribir los datos JSON en el cuerpo de la solicitud
            try (OutputStream outputStream = urlConnection.getOutputStream()) {
                byte[] input = jsonParam.toString().getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }

            // Leer la respuesta del servidor
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return new java.util.Scanner(urlConnection.getInputStream(), "UTF-8")
                        .useDelimiter("\\A").next(); // Leer la respuesta
            } else {
                return "Error en la consulta. Código de respuesta: " + responseCode;
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
