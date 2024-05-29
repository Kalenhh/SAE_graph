import java.util.* ;


public class BellmanFord{

	public static Valeur resoudre(GrapheListe g, String depart){
		Valeur valeurs = new Valeur() ;

		List<String> liste_noeud = g.listeNoeuds() ;

		for (String n : liste_noeud){
			valeurs.setValeur(n, Double.MAX_VALUE) ;
		}

		valeurs.setValeur(depart, 0) ;

		boolean iter_changed = true ;
		double distance ;
		String dest ;

		double old_distance ;
		double new_distance ;

		while(iter_changed){

			iter_changed = false ;

			for(String n : liste_noeud){
				for(Arc arc : g.getArcs(n)){
					distance = arc.getCout() ;
					dest = arc.getDest() ;

					old_distance = valeurs.getValeur(dest);
					new_distance = valeurs.getValeur(n)+distance;

					if(new_distance < old_distance){
						valeurs.setParent(dest,n);
						valeurs.setValeur(dest,new_distance);

						iter_changed = true ;
					}
				}
			}
		}






		return valeurs ;
	}
}