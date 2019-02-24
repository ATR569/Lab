package testes;

import lab08.Comentario;
import lab08.EstrategiaSimples;
import lab08.Produto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 */
public class TesteEstrategiaSimples {
    Comentario c1, c2, c3, c4, c5;
    Produto p1;
    
    @Before
    public void setup() throws Exception{
        p1 = new Produto("asas", 10);
        c1 = new Comentario("comentario1", 1);
        c2 = new Comentario("comentario2", 2);
        c3 = new Comentario("comentario3", 0);
        c4 = new Comentario("comentario4", -1);
        c5 = new Comentario("comentario5", -2);
    }
    
    @Test
    public void testeNotaNaMosca() throws Exception{
        
        assertEquals(p1.getNaMosca(new EstrategiaSimples()), 0, 0.00000001);
        p1.insertComentario(c1);
        assertEquals(p1.getNaMosca(new EstrategiaSimples()), 1, 0.00000001);
        p1.getComentarios().add(0, c2);
        assertEquals(p1.getNaMosca(new EstrategiaSimples()), 1.5, 0.00000001);
        p1.getComentarios().add(0, c2);
        assertEquals(p1.getNaMosca(new EstrategiaSimples()), 1.66666666666666, 0.00000001);
        p1.getComentarios().add(0, c2);
        assertEquals(p1.getNaMosca(new EstrategiaSimples()), 1.75, 0.00000001);
        p1.insertComentario(c2);
        p1.insertComentario(c3);
        p1.insertComentario(c5);
        p1.insertComentario(c4);
        p1.insertComentario(c2);
        p1.insertComentario(c5);
        p1.insertComentario(c3);
        assertEquals(p1.getNaMosca(new EstrategiaSimples()), 0.545454545454545454, 0.00000001);
        p1.insertComentario(c1);
        p1.insertComentario(c2);
        p1.insertComentario(c3);
        assertEquals(p1.getNaMosca(new EstrategiaSimples()), 0.642857142857, 0.00000001);
    }
    
    @Test
    public void testeComentRelevant() throws Exception{
        Comentario c6 = new Comentario("comentario6", 2);
        Comentario c7 = new Comentario("comentario7", 1);
        Comentario c8 = new Comentario("comentario8", 0);
        Comentario c9 = new Comentario("comentario9", -1);
        Comentario c10 = new Comentario("comentario10", -2);
        
        
        assertNull(p1.getRelevantComents(new EstrategiaSimples()));
        p1.insertComentario(c1);
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[0].getComent(), "comentario1");
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[1].getComent(), "comentario1");
        p1.insertComentario(c2);
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[0].getComent(), "comentario1");
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[1].getComent(), "comentario2");
        p1.insertComentario(c6);
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[0].getComent(), "comentario1");
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[1].getComent(), "comentario6");
        p1.insertComentario(c2);
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[0].getComent(), "comentario1");
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[1].getComent(), "comentario2");
        p1.insertComentario(c3);
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[0].getComent(), "comentario3");
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[1].getComent(), "comentario2");
        p1.insertComentario(c3);
        p1.insertComentario(c2);
        p1.insertComentario(c5);
        p1.insertComentario(c1);
        p1.insertComentario(c6);
        p1.insertComentario(c7);
        p1.insertComentario(c3);
        p1.insertComentario(c10);
        p1.insertComentario(c8);
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[0].getComent(), "comentario10");
        assertEquals(p1.getRelevantComents(new EstrategiaSimples())[1].getComent(), "comentario6");
    }
}
