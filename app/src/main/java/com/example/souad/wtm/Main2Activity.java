package com.example.souad.wtm;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabaseUsers;
    Spinner spinner;
    Spinner spinnner;
    Spinner spinnnner;





    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);


        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

        }
    }




    //TabHost tabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);





        spinner = (Spinner) findViewById(R.id.spinner);
        spinnner=(Spinner)findViewById(R.id.spinnner);
        spinnnner=(Spinner)findViewById(R.id.spinnnner);
         mAuth=FirebaseAuth.getInstance();

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                /*if (firebaseAuth.getCurrentUser()==null){
                    Intent loginIntent=new Intent(Main2Activity.this,LoginActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    // startActivity(loginIntent);

                }*/


            }
        };


        mDatabase= FirebaseDatabase.getInstance().getReference().child("Annonce");

       // mDatabaseUsers.keepSynced(true);

        //mDatabase.keepSynced(true);

        mBlogList=(RecyclerView)findViewById(R.id.blog_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));



        /*TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("conference");
        spec.setContent(R.id.conference);
        spec.setIndicator("tab1");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("evenement");
        spec.setContent(R.id.evenement);
        spec.setIndicator("tab2");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("formation");
        spec.setContent(R.id.formation);
        spec.setIndicator("tab3");
        host.addTab(spec);*/



        List exempleList = new ArrayList();
        exempleList.add("categorie");
        exempleList.add("Formation");
        exempleList.add("Evenement");
        exempleList.add("Conference");


		/*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (exemple) */
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                exempleList
        );


               /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner.setAdapter(adapter);
        List exempleListt = new ArrayList();
        exempleListt.add("Lieu");
        exempleListt.add("1.Adrar");
        exempleListt.add("2.Clef");
        exempleListt.add("3.Laghouat");
        exempleListt.add("4.Oum El Bouaghi");
        exempleListt.add("5.Batna");
        exempleListt.add("6.Béjaïa");
        exempleListt.add("7.Biskra");
        exempleListt.add("8.Béchar");
        exempleListt.add("9.Blida");
        exempleListt.add("10.Bouira");
        exempleListt.add("11.Tamanrasset");
        exempleListt.add("12.Tébessa");
        exempleListt.add("13.Tlemcen");
        exempleListt.add("14.Tiaret");
        exempleListt.add("15.Tizi Ouzou");
        exempleListt.add("16.Alger");
        exempleListt.add("17.Djelfa");
        exempleListt.add("18.Jijel");
        exempleListt.add("19.Sétif");
        exempleListt.add("20.Saïda");
        exempleListt.add("21.Skikda");
        exempleListt.add("22.Sidi Bel Abbès");
        exempleListt.add("23.Annaba");
        exempleListt.add("24.Guelma");
        exempleListt.add("25.Constantine");
        exempleListt.add("26.Médéa");
        exempleListt.add("27.Mostaganem");
        exempleListt.add("28.M'Sila");
        exempleListt.add("29.Mascara");
        exempleListt.add("30.Ouargla");
        exempleListt.add("31.Oran");
        exempleListt.add("32.El Bayadh");
        exempleListt.add("33.Illizi");
        exempleListt.add("34.Bordj Bou Arreridj");
        exempleListt.add("35.Boumerdès");
        exempleListt.add("36.El Tarf");
        exempleListt.add("37.Tindouf");
        exempleListt.add("38.Tissemsilt");
        exempleListt.add("39.El Oued");
        exempleListt.add("40.Khenchela");
        exempleListt.add("41.Souk Ahras");
        exempleListt.add("42.Tipaza");
        exempleListt.add("43.Mila");
        exempleListt.add("44.Aïn Defla");
        exempleListt.add("45.Naâma");
        exempleListt.add("46.Aïn Témouchent");
        exempleListt.add("47.Ghardaïa");
        exempleListt.add("48.Relizane");



		/*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (exemple) */
        ArrayAdapter aadapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                exempleListt
        );

               /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spinnner.setAdapter(aadapter);




    }

    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);

        FirebaseRecyclerAdapter<Annonce,AnnonceViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Annonce, AnnonceViewHolder>(

                Annonce.class,
                R.layout.post_row,
                AnnonceViewHolder.class,
                mDatabase

        ) {

            protected void populateViewHolder(AnnonceViewHolder blogViewHolder, Annonce annonce, int i) {
                blogViewHolder.setTitle(annonce.getTitle());
                blogViewHolder.setLieu(annonce.getLieu());
                blogViewHolder.setDate(annonce.getDate());


            }
        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);


    }

    public static class AnnonceViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public AnnonceViewHolder(View itemView){
            super(itemView);
            mView=itemView;
        }
        public void setTitle(String Titre){
            TextView post_title=(TextView)mView.findViewById(R.id.Titre);
            post_title.setText(Titre);

        }

        public void setLieu(String lieu){
            TextView post_lieu=(TextView)mView.findViewById(R.id.lieu);
            post_lieu.setText(lieu);

        }
        public void setDate(String date){
            TextView post_date=(TextView)mView.findViewById(R.id.date);
            post_date.setText(date);
        }



    }







    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

            getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        if (item.getItemId()==R.id.action_logout){
            logout();

        }


        return super.onOptionsItemSelected(item);
    }

    private void logout() {

        mAuth.signOut();


    }


    /*public void writeNewPost(String Title,String DateDebut,String DateFin,String ContactPrincipal,String Organisme,String Telephone,String Adressee,String Description,String Category) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously


        String key = mDatabase.child("posts").push().getKey();
        Annonce post = new Annonce(Title,DateDebut,DateFin,ContactPrincipal,Organisme,Telephone,Adressee,Description,Category);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + key, postValues);3

        mDatabase.updateChildren(childUpdates);
    }*/



    public void onClick(View v) {


    }

    public void toDetailActivity(View view){
        Intent intent = new Intent(this, Detail.class);
        startActivity(intent);

    }

    public void publierButton(View view){

        if (FirebaseAuth.getInstance().getCurrentUser()==null) {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        }
        else {

            Intent intent = new Intent(this, AdActivity.class);
            startActivity(intent);
        }



    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new RegisterActivity.DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}
