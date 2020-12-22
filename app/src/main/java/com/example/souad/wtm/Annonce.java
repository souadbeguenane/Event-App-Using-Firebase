package com.example.souad.wtm;

/**
 * Created by souad on 20/02/17.
 */

public class Annonce {
    public String Titre;
    public String DateDebut;
    public String DateFin;

    public String ContactPrincipal;
    public String Organisme;
    public String Telephone;
    public String Adressee;
    public String Description;
    public String Category;

    /*public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();*/

    public Annonce(){

    }
    public Annonce(String Title,String DateDebut,String DateFin,String ContactPrincipal,String Organisme,String Telephone,String Adressee,String Description,String Category){
        this.Titre=Title;
        this.DateDebut=DateDebut;
        this.DateFin=DateFin;

        this.ContactPrincipal=ContactPrincipal;
        this.Organisme=Organisme;
        this.Telephone=Telephone;
        this.Adressee=Adressee;
        this.Description=Description;
        this.Category=Category;


    }

    public String getTitle(){
        return Titre;
    }
    public void setTitle(String Titre){
        this.Titre=Titre;
    }
    public  String getLieu(){return Adressee;}
    public void setLieu(String Adressee){
        this.Adressee=Adressee;
    }
    public  String getDate(){return DateDebut;}
    public void setDate(String DateDebut){
        this.DateDebut=DateDebut;

    }

   /* public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Title", Titre);
        result.put("DateDebut", DateDebut);
        result.put("DateFin",DateFin);
        result.put("ContactPrincipal",ContactPrincipal);
        result.put("Organisme",Organisme);
        result.put("Telephone", Telephone);
        result.put("Adressee", Adressee);
        result.put("Description", Description);
        result.put("Category", Category);




        return result;
    }*/





}
