/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author elmeh
 */
class Ville {

	String nom ; 
	double population ;
	String pays ; 
	
	
	public Ville(String nom, double population, String pays) {
		this.nom = nom;
		this.population = population;
		this.pays = pays;
	}


	public static void main (String[] args) {
		Ville v1 = new Ville ("Casablanca" , -10 , "MAROC") ; 
		Exception PopulationException = new Exception ("La populationn doit etre un nombre positif") ;
		try {
			if(v1.population<0 ) {
				throw(PopulationException) ; 	
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
		}
	}

}

