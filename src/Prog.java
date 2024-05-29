
/**
 * Main pour tester la partie 1
 */
public class Prog{
	public static void main(String[] args){

		GrapheListe gl = new GrapheListe() ;
		BellmanFord bf = new BellmanFord() ;
		Dijkstra dj = new Dijkstra() ;

		gl.ajouterArc("A","B",12) ;
		gl.ajouterArc("A","D",87) ;
		gl.ajouterArc("C","A",19) ;
		gl.ajouterArc("D","C",10) ;
		gl.ajouterArc("D","B",23) ;
		gl.ajouterArc("B","E",11) ;
		gl.ajouterArc("E","D",43) ;

		Valeur v ;

		System.out.println("BellmanFord") ;
		v = bf.resoudre(gl,"A");
		System.out.println(v) ;
		System.out.println(v.calculerChemin("C")) ;

		System.out.println("dijkstra") ;
		v = dj.resoudre(gl,"A");
		System.out.println(v) ;
		System.out.println(v.calculerChemin("C")) ;

	}
}