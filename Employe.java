/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle_2;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author elmeh
 */
//La classe Employé:
 public abstract class Employe
 {
		private int matircule;
		private String nom;
		private String prenom;
		private Date datenaissance;

    public int getMatircule() {
        return matircule;
    }

    public void setMatircule(int matircule) {
        this.matircule = matircule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

		

		public Employe(int matricule, String nom, String prenom, Date dn)
		{
			this.matircule = matricule;
			this.nom = nom;
			this.prenom = prenom;
			this.datenaissance = dn;
		}

		@Override
		public String toString()
		{
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String date = formatter.format(datenaissance);
			return "Matricule:" + matircule + ", Nom: " + nom + ", Prénom: " + prenom + ", Date de naissance: " + date;
		}

		public abstract double GetSalaire();

 }

//La classe Ouvrier:
class Ouvrier extends Employe
{
		private Date dateentree ;
		private static final double SMIG = 3000;

    public static double getSMIG() {
        return SMIG;
    }

    public Date getDateentree() {
        return dateentree;
    }

    public void setDateentree(Date dateentree) {
        this.dateentree = dateentree;
    }

		
		public Ouvrier(int m, String n, String p, Date dn, Date de)
		{
			super(m, n, p, dn);
			dateentree = de;
		}

		@Override
		public String toString()
		{
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String date2 = formatter.format(dateentree);
			return "Employé ==>" + " " + super.toString() + ", Date d'entrée: " + date2;
		}

		@Override
		public double GetSalaire()
		{
			double salaire;
                        Date date = new Date();
			int Anciennete = date.getYear() - (dateentree.getYear()-1900);

			if (SMIG + Anciennete * 100 <= 2 * SMIG)
			{
				salaire = SMIG + Anciennete * 100;
			}
			else
			{
				salaire = SMIG * 2;
			}

			return salaire;
		}
}
//La classe Cadre:
class Cadre extends Employe
{
		private int indice;

         public int getIndice() {
        return indice;
            }

            public void setIndice(int indice) {
        this.indice = indice;
            }
                


		public Cadre(int matricule, String nom, String prenom, Date dn, int indice)
		{
			super(matricule, nom, prenom, dn);
			this.indice = indice;
		}

		@Override
		public String toString()
		{
			return "Cadre==> " + " " + super.toString() + ", Indice: " + indice;
		}

		@Override
		public double GetSalaire()
		{
			if (indice == 1)
			{
				return 12000;
			}
			else if (indice == 2)
			{
				return 14000;
			}
			else if (indice == 3)
			{
				return 16000;
			}
			else if (indice == 4)
			{
				return 18000;
			}
			else
			{
				return -1; //Problème d'indice
			}
		}
}


 class Associe extends Employe
{
		private static double ca;
		private double pourcentage;

        public static double getCa() {
            return ca;
        }

        public static void setCa(double ca) {
            Associe.ca = ca;
        }

         public double getPourcentage() {
             return pourcentage;
            }

         public void setPourcentage(double pourcentage) {
             this.pourcentage = pourcentage;
            }

		

		public Associe(int matricule, String nom, String prenom, Date dn, double p)
		{
			super(matricule, nom, prenom, dn);
			this.pourcentage = p;
		}

		@Override
		public String toString()
		{
			return  "Associe===> " + " " + super.toString() + ", Pourcentage: " + pourcentage + "%";
		}

		@Override
		public double GetSalaire()
		{
			return Double.isNaN(((ca * pourcentage / 100) / 12)) ? Double.NaN : Math.round(((ca * pourcentage / 100) / 12) * Math.pow(10, 2)) / Math.pow(10, 2);
		}
}



class test{
    public static void main(String[] args)
    {
    Ouvrier  o = new Ouvrier(1, "Bouslam ", "Elmehdi", new Date("02/ 17/ 2001") , new Date("02/ 17/ 2021"));
    System.out.println(o);
     System.out.println("le salaire de l'employer "+o.getPrenom() +" "+ o.getNom()+"est "+ o.GetSalaire());
     Cadre c = new Cadre(2, "Shiba", "XRP", new Date("02/ 17/ 2021"), 3);
			System.out.println(c);
	System.out.println("Le salaire du cadre "+ c.getPrenom() +" "+ c.getNom() +" est: " + c.GetSalaire());
     Associe.setCa(17000000);
     Associe v = new Associe(2, "hmida", "Etherum", new Date("02/ 17/ 2021"), 3);
        System.out.println(v);
			System.out.println("Le salaire d'associé est: " + v.GetSalaire());

    }
}