/*
sources:
https://www.youtube.com/watch?v=ryY7Dy3z-7Q
 */


package com.chat_app.chat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Button PostSend = (Button) findViewById(R.id.btnSend);

            URL url = new URL("https://www.server.com");

            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

            String urlParameters = "message=firstTestMessage";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("USER-AGENT", "Mozilla/5.0"); //à quoi ça sert ?
            connection.setRequestProperty("ACCEPT-LANGUAGE", "fr-FR"); //à quoi ça sert ?
            connection.setDoOutput(true);

            DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());

            dStream.writeBytes(urlParameters);
            dStream.flush();
            dStream.close();

            int responseCode = connection.getResponseCode();
            String output = "Request URL " + url;
            output += System.getProperty("line.separator") + "RequestParameters " + urlParameters;
            output += System.getProperty("line.separator") + "Response Code " + responseCode;

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";
            StringBuilder responseOutput = new StringBuilder();

            while((line = br.readLine()) != null){
                responseOutput.append(line);
            }
            br.close();

            output += System.getProperty("line.separator") + responseOutput.toString();

            PostSend.setText(output);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
