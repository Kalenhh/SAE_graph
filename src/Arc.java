
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
	 */
	public Arc(String p_dest, double p_cout){

		this.dest = p_dest ;
		this.cout = p_cout ;
	}

	public String toString(){
		return this.dest+"("+this.cout+")";
	}
}