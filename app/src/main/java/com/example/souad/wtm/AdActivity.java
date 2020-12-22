package com.example.souad.wtm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText Titreannonce;
    private EditText Datedebut;
    private EditText Datefin;
    private EditText Contactprincipal;
    private EditText Nomorganisme;
    private EditText NmTelephone;
    private EditText AdresseAnnonce;
    private EditText DescAnnonce;
    private Button CreateCancel;
    private Button CreateAd;
    private RadioButton EventButton;
    private RadioButton ConferenceButton;
    private RadioButton FormationButton;
    public RadioGroup Categorie;
    //private ProgressDialog progressDialog;
   private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

       firebaseAuth = FirebaseAuth.getInstance();
       /* if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }*/
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Titreannonce = (EditText) findViewById(R.id.Titreannonce);
         Datedebut= (EditText) findViewById(R.id.Datedebut);
        Datefin= (EditText) findViewById(R.id.Datefin);
        Contactprincipal= (EditText) findViewById(R.id.Contactprincipal);
        Nomorganisme= (EditText) findViewById(R.id.Nomorganisme);
        NmTelephone= (EditText) findViewById(R.id.NmTelephone);
        EventButton=(RadioButton)findViewById(R.id.EventButton);
        ConferenceButton=(RadioButton)findViewById(R.id.ConferenceButton);
        FormationButton=(RadioButton)findViewById(R.id.FormationButton);
        AdresseAnnonce= (EditText) findViewById(R.id.AdresseAnnonce);
        DescAnnonce=(EditText)findViewById(R.id.DescAnnonce);
        Categorie=(RadioGroup)findViewById(R.id.Categorie);
        CreateCancel= (Button) findViewById(R.id.CreateCancel);
        CreateAd= (Button) findViewById(R.id.CreateAd);
        CreateCancel.setOnClickListener(this);
        CreateAd.setOnClickListener(this);
        EventButton.setOnClickListener(this);
        FormationButton.setOnClickListener(this);
        ConferenceButton.setOnClickListener(this);

        }
    private void CreerAnnonce() {
        String Titre = Titreannonce.getText().toString().trim();
        String DateDebut = Datedebut.getText().toString().trim();
        String DateFin = Datefin.getText().toString().trim();
        String ContactPrincipal = Contactprincipal.getText().toString().trim();
        String Organisme = Nomorganisme.getText().toString().trim();
        String Telephone = NmTelephone.getText().toString().trim();
        String Adressee = AdresseAnnonce.getText().toString().trim();
        String Description=DescAnnonce.getText().toString().trim();
        //String Category=Categorie.toString().trim();

        if(Categorie.getCheckedRadioButtonId()!=-1){
            int id= Categorie.getCheckedRadioButtonId();
            View radioButton = Categorie.findViewById(id);
            int radioId = Categorie.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) Categorie.getChildAt(radioId);
            String Category = (String) btn.getText();

        if (TextUtils.isEmpty(Titre)) {
            Toast.makeText(this, "Entrer le titre d'annonce", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(DateDebut)) {
            Toast.makeText(this, "Entrer la Date de debut ", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(DateFin)) {
            Toast.makeText(this, "Entrer la date de fin ", Toast.LENGTH_SHORT).show();
            return;

        }
        if (!(EventButton.isChecked()) && !(ConferenceButton.isChecked()) && !(FormationButton.isChecked())) {
            Toast.makeText(this, "fghfghgh", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(ContactPrincipal)) {
            Toast.makeText(this, "Contact principal  ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Organisme)) {
            Toast.makeText(this, "Le nom de l'organisme", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Telephone)) {
            Toast.makeText(this, "Entrer le numero de telephone ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Adressee)) {
            Toast.makeText(this, "Enter l'adresse d'annonce ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Description)) {
            Toast.makeText(this, "Entrer la descrption d'annonce  ", Toast.LENGTH_SHORT).show();
            return;
        }
        //


        else {


                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Annonce");
                Annonce Ad = new Annonce(Titre, DateDebut, DateFin, ContactPrincipal, Organisme, Telephone, Adressee,Description,Category);
                String Annonce = mDatabase.push().getKey();
                DatabaseReference mConditionRef=mDatabase.child(Annonce);
                mDatabase.child(Annonce).setValue(Ad);
                Toast.makeText(this, "information save...", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(this,MainActivity.class));

        }
    }}
    public void onClick(View v) {
        if (v == CreateAd) {
            CreerAnnonce();

        }
    }

    public void toMainActivity(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

}

