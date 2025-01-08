package com.example.prueba;

import android.util.Log;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Conexion {
    public String postRequest(String requestUrl, String num1, String num2) {
        HttpURLConnection urlConnection = null;
        try {

            URL url = new URL(requestUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "text/plain");
            urlConnection.setDoOutput(true);

            String data = "num1=" + URLEncoder.encode(num1, "UTF-8") +
                    "&num2=" + URLEncoder.encode(num2, "UTF-8");

            try (OutputStream outputStream = urlConnection.getOutputStream()) {
                outputStream.write(data.getBytes("UTF-8"));
            }

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

    public String putRequest(String requestUrl, String lado){
        HttpURLConnection urlConnection = null;
        try {

            URL url = new URL(requestUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("PUT");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "text/plain");
            urlConnection.setDoOutput(true);

            String data = "lado=" + URLEncoder.encode(lado, "UTF-8");

            try (OutputStream outputStream = urlConnection.getOutputStream()) {
                outputStream.write(data.getBytes("UTF-8"));
            }

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

    public String deleteRequest(String requestUrl, String cedula){
        HttpURLConnection urlConnection = null;
        try {

            URL url = new URL(requestUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("PUT");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "text/plain");
            urlConnection.setDoOutput(true);

            String data = "cedula=" + URLEncoder.encode(cedula, "UTF-8");

            try (OutputStream outputStream = urlConnection.getOutputStream()) {
                outputStream.write(data.getBytes("UTF-8"));
            }

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

    public String allRequest(String requestUrl, String metodo){
        HttpURLConnection urlConnection = null;
        try {

            URL url = new URL(requestUrl);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(metodo);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "text/plain");
            urlConnection.setDoOutput(true);

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
