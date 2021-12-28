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

class Enfant    {
	public int age  ; 
	

public Enfant(int age) {
	Exception AgeEnfantException = new Exception ("[ "+age+" ] ans n'est pas un âge valide !") ;
	try {
		if (age<1 || age>10) throw(AgeEnfantException) ; 
			
	}
	catch(Exception e) {
		System.out.println(e.getMessage()) ;
	}	
}

//class main pour le test
	public static void main (String[] args) {
		Enfant e1 = new Enfant (80) ; 
	}
}


