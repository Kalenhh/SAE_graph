
/**
 * Main pour tester la partie 1
 */
public class Prog{
	public static void main(String[] args){

		GrapheListe gl = new GrapheListe() ;


		gl.ajouterArc("A","B",12) ;
		gl.ajouterArc("A","D",87) ;
		gl.ajouterArc("C","A",19) ;
		gl.ajouterArc("D","C",10) ;
		gl.ajouterArc("D","B",23) ;
		gl.ajouterArc("B","E",11) ;
		gl.ajouterArc("E","D",43) ;

		Valeur v = BellmanFord.resoudre(gl,"A");
		System.out.println(v) ;

		System.out.println(v.calculerChemin("C")) ;
	}
}