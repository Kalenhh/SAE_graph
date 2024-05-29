import java.util.*;

/**
 * Represente un algorithme de recherche de chemin
 */
public interface Algorithme{

	/**
	 * Methode pour résoudre un chemin dans un graphe
	 */
	public Valeur resoudre(GrapheListe g, String depart);
}