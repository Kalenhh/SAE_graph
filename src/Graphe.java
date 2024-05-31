import java.util.* ;

/**
 * Represente un graphe orienté
 */
public interface Graphe{

	/**
	 * Renvoie la liste des noeuds du graphe
	 */
	public List<String> listeNoeuds();

	/**
	 * Renvoie la liste des voisins d'un noeud n
	 * 
	 * @param n : noeud
	 */
	public List<String> suivants(String n);
}