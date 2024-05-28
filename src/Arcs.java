import java.util.*;

/**
 * Classe qui gère une liste de plusieurs Arc
 */
public class Arcs{

	/**
	 * Liste d'Arc
	 */
	private List<Arc> arcs ;

	/**
	 * Constructeur
	 */
	public Arcs(){
		this.arcs = new ArrayList<Arc>() ;
	}

	/**
	 * Ajoute un arc à la liste
	 */
	public void ajouterArc(Arc a){
		this.arcs.add(a) ;
	}

	/**
	 * getter de arcs
	 */
	public List<Arc> getArcs(){
		return this.arcs ;
	}

	public String toString(){
		String ret = "" ;

		for(int i = 0 ; i < this.arcs.size() ; i++){
			ret = ret + this.arcs.get(i).toString() + "\n" ;
		}

		return ret ;
	}
}