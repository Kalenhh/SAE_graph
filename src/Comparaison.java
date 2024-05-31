import java.io.*;

/**
 * Main pour tester la partie 1
 */
public class Comparaison{


	public static void main(String[] args){

		GrapheListe gl ;
		BellmanFord bf = new BellmanFord() ;
		Dijkstra dj = new Dijkstra() ;

		Valeur v ;
		double time ;

		double time_tmp_bellman = 0;
		double time_tmp_dij = 0;
		double time_bellman = 0;
		double time_dij = 0;
		int cnt_bellman = 0;
		int cnt_dij = 0;
		int cnt_files = 0;

		File folder = new File("../graph/");
		File[] listOfGraphs = folder.listFiles();
		int a ;

		for (File graph : listOfGraphs) {

			cnt_files++;
			gl = new GrapheListe(graph.getPath()) ; 

			time = System.nanoTime() ;
			v = bf.resoudre(gl,"1");
			time_tmp_bellman = System.nanoTime()-time;
			time_bellman += time_tmp_bellman;

			time = System.nanoTime() ;
			v = dj.resoudre(gl,"1");
			time_tmp_dij = System.nanoTime()-time;
			time_dij += time_tmp_bellman;

			a = time_tmp_bellman < time_tmp_dij ? cnt_bellman++ : cnt_dij++;

			System.out.println(graph.getName()+"\t\t"+time_tmp_bellman+"\t\t"+time_tmp_dij+"\t"+cnt_bellman+"/"+cnt_dij);

		}

		System.out.println("Bellman-ford : "+time_bellman/cnt_files+"\t"+cnt_bellman);
		System.out.println("Dijkstra : "+time_dij/cnt_files+"\t"+cnt_dij);
	}
}