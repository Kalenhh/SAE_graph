import java.util.* ;

/**
 * Implemente l'interface Graphe
 */
public class GrapheListe{

	/**
	 * Liste des noeuds
	 */
	private ArrayList<String> noeuds ;

	/**
	 * Liste des Arc de chaque noeud
	 */
	private ArrayList<Arcs> adjacence ;

	/**
	 * Constructeur
	 */
	public GrapheListe(){
		this.noeuds = new ArrayList<String>();
		this.adjacence = new ArrayList<Arcs>() ;
	}

	/**
	 * Ajoute un arc 
	 */
	public void ajouterArc(String depart, String destination, double cout){

		int ind_dep_node = this.getIndice(depart) ;
		int ind_dest_node = this.getIndice(destination) ;

		Arc a = new Arc(destination,cout);


		if(ind_dest_node == -1){			// le noeud de destination n'existe pas, on le rajoute
			this.noeuds.add(destination) ;
			this.adjacence.add(new Arcs());
		}


		if(ind_dep_node == -1){				// le noeud de depart n'existe pas
			this.noeuds.add(depart) ;
			ind_dep_node = this.getIndice(depart) ;

			Arcs as = new Arcs();
			as.ajouterArc(a) ;

			this.adjacence.add(as) ;
		}
		else{								// il existe
			this.adjacence.get(ind_dep_node).ajouterArc(a) ;
		}
	}

	/**
	 * Retourne la liste des suivants
	 */
	public List<Arc> suivant(String n){
		return this.adjacence.get(this.getIndice(n)).getArcs();
	}


	/**
	 * Affiche le graphe sous forme de texte
	 */
	public String toString(){
		String ret = "";

		for(int i = 0 ; i < this.noeuds.size() ; i++){
			ret = ret + this.noeuds.get(i) + " -> " + this.adjacence.get(i).toString() + "\n";
		}
		return ret ;
	}





	/**
	 * Retourne l'indice d'un noeud n dans la liste noeuds
	 */
	public int getIndice(String s){
		return this.noeuds.indexOf(s) ;
	}
}