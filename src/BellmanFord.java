import java.util.* ;

/**
 * Implemente l'algorithme de Bellman-Ford
 */
public class BellmanFord implements Algorithme{

	/**
	 * Retourne le resultat de l'algo
	 */
	public Valeur resoudre(GrapheListe g, String depart){

		Valeur valeurs = new Valeur() ;				// Contients les noeuds, leurs parents, et leurs valeurs
		List<String> liste_noeud = g.listeNoeuds(); // Liste des noeuds presents dans le graphe
		boolean point_fixe = false ;				// Indique si le point fixe est atteint
		double distance ;						// Distance d'un arc
		String dest ;							// destination d'un arc
		double old_distance ;					// ancienne distance d'un noeud de destination
		double new_distance ;					// nouvelle distance possible d'un noeud de destination

		for (String n : liste_noeud){
			valeurs.setValeur(n, Double.MAX_VALUE) ;
		}

		valeurs.setValeur(depart, 0) ;  // valeur du point de depart

		while(!point_fixe){ // tant que l'on a pas de point fixe

			point_fixe = true ;

			for(String n : liste_noeud){
				for(Arc arc : g.getArcs(n)){
					distance = arc.getCout() ;
					dest = arc.getDest() ;

					old_distance = valeurs.getValeur(dest);
					new_distance = valeurs.getValeur(n)+distance;

					if(new_distance < old_distance){  // Une distance plus petite est trouvé
						valeurs.setParent(dest,n);
						valeurs.setValeur(dest,new_distance);

						point_fixe = false ;
					}
				}
			}
		}
		return valeurs ;
	}
}