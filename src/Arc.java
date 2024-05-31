
/**
 * Represente un arc vers un noeud destination
 */
public class Arc {

	/**
	 * Noeud de destination
	 */
	private String dest ;

	/**
	 * Cout de l'arc
	 */
	private double cout ;

	/**
	 * Constructeur
	 * 
	 * @param p_dest ; destination
	 * @param p_cout ; valeur de l'arc
	 */
	public Arc(String p_dest, double p_cout){

		this.dest = p_dest ;
		this.cout = p_cout ;
	}

	/**
	 * Affiche l'arc
	 */
	public String toString(){
		return this.dest+"("+this.cout+")";
	}

	/**
	 * Getter de cout
	 */
	public double getCout(){
		return this.cout ;
	}

	/**
	 * Getter de destination
	 */
	public String getDest(){
		return this.dest ;
	}
}