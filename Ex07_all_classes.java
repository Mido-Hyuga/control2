/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle_2;

import java.text.SimpleDateFormat;
import java.util.Date ;

/**
 *
 * @author elmeh
 */
interface Ex07_all_classes{
    public abstract Date datePer();
    public abstract int numjr();
}
interface susceptibleSolde
{
    public abstract double lanceSolde(float pers1);
      public abstract double terminerSolde(float pers2);
}
class Article
{
        double prix_achat;
        double prix_vend;
        String nom;
        String fourni;

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public double getPrix_vend() {
        return prix_vend;
    }

    public void setPrix_vend(double prix_vend) {
        this.prix_vend = prix_vend;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFourni() {
        return fourni;
    }

    public void setFourni(String fourni) {
        this.fourni = fourni;
    }

    public Article(double prix_achat, double prix_vend, String nom, String fourni) {
        this.prix_achat = prix_achat;
        this.prix_vend = prix_vend;
        this.nom = nom;
        this.fourni = fourni;
    }
        public double tauxrend()
        {
            return (prix_vend - prix_achat);
        }
        public String toSting()
        {
            return "Article ==> Nom :"+ nom +" , Fornisseure: "+ fourni+" , prix de vente :"+ prix_vend +" , prix d'achat :" +prix_achat;
        }
}
class electo extends Article implements susceptibleSolde
        {
            double voltage;
            String marque;

    public electo(double voltage, String marque, double prix_achat, double prix_vend, String nom, String fourni) {
        super(prix_achat, prix_vend, nom, fourni);
        this.voltage = voltage;
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "electo==>" +super.toSting()+ " , voltage=" + voltage + ", marque=" + marque + '}';
    }

 
            @Override
    public double lanceSolde(float pers1) {
      
        return        prix_achat - (prix_achat * pers1 /100) ;
    }


            @Override
    public double terminerSolde(float pers2) {
        prix_vend =  prix_achat + (prix_achat * pers2 /100) ;
        return prix_vend;
    }     
        }
class Prime extends Article implements Ex07_all_classes
{
  Date date_per;

    public Date getDate_Per() {
        
        return date_per;
    }

    public void setDate_Per(Date date_per) {
        this.date_per = date_per;
    }

    public Prime(Date date_per, double prix_achat, double prix_vend, String nom, String fourni) {
        super(prix_achat, prix_vend, nom, fourni);
        this.date_per = date_per;
    }

    @Override
    public Date datePer() {
        return date_per;
    }

    @Override
    public int numjr() {
        Date date = new Date();
      long date1InMs = date.getTime();
      long date2InMs = date_per.getTime();

      long timeDiff = 0;
      if (date1InMs > date2InMs) {
         timeDiff = date1InMs - date2InMs;
      } else {
         timeDiff = date2InMs - date1InMs;
      }

      int daysDiff = (int)(timeDiff / (1000 * 60 * 60 * 24));

      
      return daysDiff ;
    }

    @Override
    public String toString() {
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String ba = formatter.format(date_per);
        return " prime{" + "date_per=" + ba + ", nombre de jours restant : " + numjr();
    }

   }
class Main
{
    public static void main(String[] args)
    { 
        electo e = new electo (120.5, "samsung", 3000, 4500, "elmehdi", "hyuga");
        System.out.print(e);
        Prime p = new Prime ( new Date("02/ 17/ 2001"), 3000, 4000,"elmehdi","rgdfg");
        System.out.print(p);
    }
}