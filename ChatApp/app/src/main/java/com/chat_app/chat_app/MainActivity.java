/*
SOURCES
- tuto video d'envoi de requête POST : https://www.youtube.com/watch?v=ryY7Dy3z-7Q
- tuto openClassrooms : "Développez votre première application android"

A FAIRE
- associer les champs de saisie au message POST.

ATTENTION
Remettre à jour les diagrammes si mon implémentation s'éloigne des modèles :
    - plus de notification mais bouton désactivé
*/


package com.chat_app.chat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

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

        //création des variables et association avec les éléments de vue
        EditText mPseudo = (EditText)findViewById(R.id.fieldPseudoPerso);
        EditText mContact = (EditText)findViewById(R.id.fieldPseudoContact);
        final Button mPostSend = (Button) findViewById(R.id.btnSend); //"final" pour être accédé depuis l'intérieur d'une classe

        //activation du bouton si saisie dans les champs de pseudo et de contact
        mPostSend.setEnabled(false);

        mPseudo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence1, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence1, int start, int before, int count) {
                mPostSend.setEnabled(charSequence1.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable1) {}
        });

        mContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence2, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence2, int start, int before, int count) {
                mPostSend.setEnabled(charSequence2.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable2) {}
        });


        //requête POST
        try {
            URL url = new URL("http://www.serverTest.com");

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

            mPostSend.setText(output);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
