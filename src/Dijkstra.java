import java.util.*;

/**
 * Implement l'algorithme de Dijkstra
 */
public class Dijkstra implements Algorithme{

	public Valeur resoudre(GrapheListe g, String depart){
		Valeur valeurs = new Valeur();

		List<String> q = new ArrayList<String>();


		for(String n : g.listeNoeuds()){
			valeurs.setValeur(n, Double.MAX_VALUE);
			valeurs.setParent(n, null);

			q.add(n) ;
		}

		valeurs.setValeur(depart,0) ;

		String min_noeud ;
		double distance ;
		while(q.size()>0){
			min_noeud = q.get(0);
			for(String n : q){
				if(valeurs.getValeur(n)<valeurs.getValeur(min_noeud)){
					min_noeud = n ;
				}
			}
			q.remove(min_noeud);

			for(Arc arc : g.getArcs(min_noeud)){

				if(q.indexOf(arc.getDest())==-1){ // si arc n'est pas dans Q
					continue ;
				}

				distance = valeurs.getValeur(min_noeud) + arc.getCout() ;
				if(distance < valeurs.getValeur(arc.getDest())){
					valeurs.setValeur(arc.getDest(), distance);
					valeurs.setParent(arc.getDest(), min_noeud);
				}
			}
		}

		return valeurs ;
	}
}