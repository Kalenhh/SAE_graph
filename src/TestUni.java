import org.junit.*;
import java.util.*;
import org.junit.Assert.*;

/**
 * Classe de test
 */
public class TestUni{
    

    @Test
    public void testajoulistArc() throws Exception{
        Arc arc1 = new Arc("A",10);
        Arcs liste1 = new Arcs();

        liste1.ajouterArc(arc1);
        List<Arc> liste2 = liste1.getArcs();


        Assert.assertEquals(liste2.get(0),arc1);
    }

    @Test
    public void testGraphListe1() throws Exception {
        GrapheListe l1 = new GrapheListe();

        l1.ajouterArc("A","B",10);

        Assert.assertEquals(l1.getIndice("A"),1);

    }

    @Test
    public void testGraphsuivant() throws Exception{
        GrapheListe l1 = new GrapheListe();
        l1.ajouterArc("A","B",10);

        List<String> l2 = l1.suivants("A");

        Assert.assertEquals(l2.get(0), "B");
    }

    @Test
    public void testgetVal() throws Exception{
        Valeur val = new Valeur();
        val.setValeur("A",10);



        Assert.assertEquals(val.getValeur("A"),10,0);
    }

    @Test
    public void testgetParent() throws Exception{
        Valeur val = new Valeur();
        val.setValeur("A",10);
        val.setValeur("B",10);

        val.setParent("A","B");

        Assert.assertEquals(val.getParent("A"),"B");

    }

    @Test
    public void testBellman() throws Exception{
        GrapheListe gl = new GrapheListe() ;
		BellmanFord bf = new BellmanFord() ;

        gl.ajouterArc("A","B",10) ;
		gl.ajouterArc("A","D",75) ;
		gl.ajouterArc("C","A",15) ;
		gl.ajouterArc("D","C",10) ;
		gl.ajouterArc("D","B",20) ;
		gl.ajouterArc("B","E",10) ;
		gl.ajouterArc("E","D",40) ;

        Valeur v ;

        v = bf.resoudre(gl,"A");

        List<String> liste = v.calculerChemin("C");

        Assert.assertEquals(liste.get(0),"A" );
        Assert.assertEquals(liste.get(1),"B" );
        Assert.assertEquals(liste.get(2),"E" );
        Assert.assertEquals(liste.get(3),"D" );
        Assert.assertEquals(liste.get(4),"C" );

    }

    @Test
    public void testDijkstra() throws Exception{
        GrapheListe gl = new GrapheListe() ;
		Dijkstra dj = new Dijkstra() ;

        gl.ajouterArc("A","B",10) ;
		gl.ajouterArc("A","D",75) ;
		gl.ajouterArc("C","A",15) ;
		gl.ajouterArc("D","C",10) ;
		gl.ajouterArc("D","B",20) ;
		gl.ajouterArc("B","E",10) ;
		gl.ajouterArc("E","D",40) ;

        Valeur v ;

        v = dj.resoudre(gl,"A");

        List<String> liste = v.calculerChemin("C");

        Assert.assertEquals(liste.get(0),"A" );
        Assert.assertEquals(liste.get(1),"B" );
        Assert.assertEquals(liste.get(2),"E" );
        Assert.assertEquals(liste.get(3),"D" );
        Assert.assertEquals(liste.get(4),"C" );

    }



    

}