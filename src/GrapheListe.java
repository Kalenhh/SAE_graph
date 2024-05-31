import java.util.* ;
import java.io.*;

/**
 * Implemente l'interface Graphe
 */
public class GrapheListe implements Graphe{

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
	 * Constructeur a partir d'un fichier
	 * @param path ; chemin relatif du fichier
	 */
	public GrapheListe(String path){

		this.noeuds = new ArrayList<String>();
		this.adjacence = new ArrayList<Arcs>() ;

		try{
			String[] line ; // ligne du fichier apres un split()
			String depart ; // noeud de depart
			String destination ; // noeud de destination
			double value ; // valeur de l'arc
			File f = new File(path);
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				line = sc.nextLine().split("\t");
				depart = line[0];
				destination = line[1];
				value = Double.parseDouble(line[2]);

				this.ajouterArc(depart,destination,value);

			}
		}
		catch(Exception e){
			System.out.println("err");
		}
	}

	/**
	 * Ajoute un arc
	 * 
	 * @param depart : noeud de depart
	 * @param destination : noeud de destination
	 * @param cout : valeur de l'arc
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
	 * Retourne la liste des Arc partant du noeud n
	 * 
	 * @param n : noeud
	 */
	public List<Arc> getArcs(String n){
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
	 * 
	 * @param n : noeud
	 */
	public int getIndice(String n){
		return this.noeuds.indexOf(n) ;
	}

	/**
	 * retourne la liste des noeuds present dans le graphe
	 */
	public List<String> listeNoeuds(){
		return this.noeuds ;
	}

	/**
	 * retourne la liste des voisins d'un noeud n
	 * 
	 * @param n : noeud
	 */
	public List<String> suivants(String n){
		List<String> l = new ArrayList<String>() ;

		for(Arc a : this.getArcs(n)){
			l.add(a.getDest());
		}
		return l ;
	}
}