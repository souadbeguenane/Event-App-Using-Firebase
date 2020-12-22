package com.example.souad.wtm;

import android.app.ProgressDialog;
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

public class EmailRegistrationActivity extends AppCompatActivity implements View.OnClickListener {
   private EditText NomComplet;
  ///  private EditText editTextEmail;
    //private EditText editTextPassword;
   // private EditText Confirmationmodedepasse;
    private RadioButton Homme;
    private RadioButton Femme;
    private RadioGroup RegistrationRadioGroup;
    private EditText AdresseUtilisateur;
    private EditText Phone;
    private EditText ActiviteUtilisateur;
    private Button Envoyer;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private Button Annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_registration);
        firebaseAuth = FirebaseAuth.getInstance();
        /*if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }*/
       NomComplet = (EditText) findViewById(R.id.NomComplet);
       // editTextEmail = (EditText) findViewById(R.id.editTextEmail);
       // editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        //Confirmationmodedepasse = (EditText) findViewById(R.id.Confirmationmodedepasse);
        RegistrationRadioGroup = (RadioGroup) findViewById(R.id.RegistrationRadioGroup);
        Homme = (RadioButton) findViewById(R.id.Homme);
        Femme = (RadioButton) findViewById(R.id.Femme);
        AdresseUtilisateur = (EditText) findViewById(R.id.AdresseUtilisateur);
        Phone = (EditText) findViewById(R.id.Phone);
        ActiviteUtilisateur = (EditText) findViewById(R.id.ActiviteUtilisateur);
        Envoyer = (Button) findViewById(R.id.Envoyer);
        Envoyer.setOnClickListener(this);
      Homme.setOnClickListener(this);
        Femme.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

    }

    private void Enregister() {
        String Nom = NomComplet.getText().toString().trim();
        //String email = editTextEmail.getText().toString().trim();
       // String password = editTextPassword.getText().toString().trim();
        //String EditText1 = Confirmationmodedepasse.getText().toString().trim();
        String addresse = AdresseUtilisateur.getText().toString().trim();
        String Mobile = Phone.getText().toString().trim();
        String activite = ActiviteUtilisateur.getText().toString().trim();
        String radioButtonText = Homme.getText().toString();
        String radioButtonText2 = Femme.getText().toString();


        if (TextUtils.isEmpty(Nom)) {
            Toast.makeText(this, "Entrer le Nom complet ", Toast.LENGTH_SHORT).show();
            return;

        }

       /* if (TextUtils.isEmpty(EditText1)) {
            Toast.makeText(this, "Confirmer le mot de passe", Toast.LENGTH_SHORT).show();
            return;
        }

        Pattern pattern = Pattern.compile(password, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EditText1);

        if (!matcher.matches()) {
            Toast.makeText(this, "Confirmation du mot de passe incorrect", Toast.LENGTH_SHORT).show();

        }*/
        if (!(Homme.isChecked()) && !(Femme.isChecked())) {
            Toast.makeText(this, "chose one", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(addresse)) {
            Toast.makeText(this, "Enter l'adresse", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Mobile)) {
            Toast.makeText(this, "Enter le telephone ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(activite)) {
            Toast.makeText(this, "Enter l'activité", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            progressDialog.setMessage("registring please wait");
            progressDialog.show();


            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("RegistrationInfo");
            RegistrationInfo utilisateur = new RegistrationInfo(Nom, addresse, Mobile, activite);
            String RegistrationInfo= mDatabase.push().getKey();
            DatabaseReference mConditionRef=mDatabase.child(RegistrationInfo);
            mDatabase.child(RegistrationInfo).setValue(utilisateur);
            Toast.makeText(this, "information save...", Toast.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(this,AdActivity.class));
        }
        }
    public void onClick(View v) {
        if (v == Envoyer) {
            Enregister();

        }

    }}
