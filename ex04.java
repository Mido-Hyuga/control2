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
class AdresseIP {
	private int[] octets;
	private String classe;
	
	//Constructeur
	public AdresseIP (int o1,int o2, int o3, int o4) {
	
	Exception nombre_non_valide = new Exception (" Les Nombres doit etre compris entre 0 et 255 ") ;
	try {
		if (o1<0 || o1 >255 || o2<0 || o2 >255 || o3<0 || o3 >255 || o4<0 || o4 >255 ) {
			throw(nombre_non_valide) ; 	
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage()) ;
	}
}

	//toString
	public String toString() {
	return octets[0] + "." + octets[1] + "." + octets[2] + "."+ octets[3] ; 
	}
	
	
	//Getter Setter
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	


}

class Main {

	public static void main(String[] args) {
	 AdresseIP A1 = new AdresseIP (255,0,250,3)  ;

	}

}
