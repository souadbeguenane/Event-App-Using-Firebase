package com.example.souad.wtm;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class GmailRegistrationActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText NomComplet;
    private EditText AdresseUtilisateur;
    private EditText Phone;
    private EditText ActiviteUtilisateur;
    private RadioButton Homme;
    private RadioButton Femme;
    private Button Envoyer;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_registration);
        firebaseAuth = FirebaseAuth.getInstance();
        NomComplet = (EditText) findViewById(R.id.NomComplet);
        AdresseUtilisateur = (EditText) findViewById(R.id.AdresseUtilisateur);
        Phone = (EditText) findViewById(R.id.Phone);
        ActiviteUtilisateur = (EditText) findViewById(R.id.ActiviteUtilisateur);
        Envoyer = (Button) findViewById(R.id.Envoyer);
        Envoyer.setOnClickListener(this);
    }
    private void Enregister(){
        String Nom=NomComplet.getText().toString().trim();
        String addresse=AdresseUtilisateur.getText().toString().trim();
        String Mobile=Phone.getText().toString().trim();
        String activite=ActiviteUtilisateur.getText().toString().trim();
        if(TextUtils.isEmpty(Nom)){
            //email is empty
            Toast.makeText(this, "Entrer le Nom complet ",Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;

        }
        if (TextUtils.isEmpty(addresse)){
            Toast.makeText(this,"Enter l'adresse",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Mobile)){
            Toast.makeText(this,"Enter le telephone ",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(activite)){
            Toast.makeText(this,"Enter l'activité",Toast.LENGTH_SHORT).show();
            return;
        }

       /* RegistrationInfo RegistrationInfo =new RegistrationInfo(Nom,addresse,Mobile,activite);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(RegistrationInfo);
        Toast.makeText(this,"information save...",Toast.LENGTH_LONG).show();*/
    }
    @Override
    public void onClick(View v) {
        if (v==Envoyer){
            Enregister();
        }

    }
}
