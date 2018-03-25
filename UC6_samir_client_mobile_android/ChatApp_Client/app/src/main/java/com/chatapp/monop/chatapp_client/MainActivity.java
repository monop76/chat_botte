/*
SOURCES
- tuto video d'envoi de requête POST : https://www.youtube.com/watch?v=ryY7Dy3z-7Q
- tuto openClassrooms : "Développez votre première application android"

A FAIRE
- associer les champs de saisie au message POST
- modifier l'url de requête quand cela fonctionne
- nettoyer les imports et le code inutile

ATTENTION
- Remettre à jour les diagrammes si mon implémentation s'éloigne des modèles :
    - plus de notification mais bouton désactivé
    - mon message s'affiche dans la discussion si la requête est correctement envoyée

DETTE TECHNIQUE
- améliorer l'activation du bouton : PSEUDO || CONTACT >> PSEUDO & CONTACT
- modifier la concaténation de texte : cf les warnings dans le code
- barre de défilement
- chercher une autre méthode : clic bouton à l'extérieur de la stringRequest
- scrollbar
*/

package com.chatapp.monop.chatapp_client;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context mContext = getApplicationContext();

                //Variables creations associated to views elements
        final EditText mPseudo = (EditText) findViewById(R.id.fieldPseudoPerso); //"final" allows a class to call it
        final EditText mContact = (EditText) findViewById(R.id.fieldPseudoContact);
        final EditText mMessage = (EditText) findViewById(R.id.inputMsg);
        final TextView mDiscussion = (TextView) findViewById(R.id.discussion);
        final Button mPostSend = (Button) findViewById(R.id.btnSend);

        mDiscussion.setMovementMethod(new ScrollingMovementMethod());

        //Activation of "Envoyer" button if input detected pseudo or contact fields
        mPostSend.setEnabled(false);

        mPseudo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence1, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence1, int start, int before, int count) {
                mPostSend.setEnabled(charSequence1.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable1) {
            }
        });

        mContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence2, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence2, int start, int before, int count) {
                mPostSend.setEnabled(charSequence2.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable2) {
            }
        });

        //POST request using volley library
        mPostSend.setOnClickListener(new Button.OnClickListener(){public void onClick(View v) {

            //Instantiate the RequestQueue.
            final RequestQueue queue = Volley.newRequestQueue(mContext);

            //Provide requested URL
            final String url = "http://192.168.0.16:8080/serverWebChatAppBouchon/post_Request";

//String pour tester la lib volley
        //Request a string response from the provided URL.
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mDiscussion.setText("Réponse à la requête: " + response.substring(0, 500));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mDiscussion.setText("l'envoi de la requête vers le site : " + url + " a échoué.");
                    }
                }){

            //Setting request parameters
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("pseudo", mPseudo.toString());
                params.put("contact",mContact.toString());
                params.put("message",mMessage.toString());

                return params;
            }
        };
                //Add the request to the RequestQueue. At this step, the request is sent
                queue.add(stringRequest);

            }
        });
    }
}