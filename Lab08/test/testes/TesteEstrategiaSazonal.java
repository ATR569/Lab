package testes;

import lab08.Comentario;
import lab08.EstrategiaSazonal;
import lab08.Produto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 */
public class TesteEstrategiaSazonal {
    Comentario c1, c2, c3, c4, c5;
    Produto p1;
    
    @Before
    public void setup() throws Exception{
        p1 = new Produto("Caneta", 5.55);
        c1 = new Comentario("comentario1", 1);
        c2 = new Comentario("comentario2", 2);
        c3 = new Comentario("comentario3", 0);
        c4 = new Comentario("comentario4", -1);
        c5 = new Comentario("comentario5", -2);
    }
    
    @Test
    public void testeNotaNaMosca() throws Exception{
        
        assertEquals(p1.getNaMosca(new EstrategiaSazonal()), 0, 0.00000001);
        p1.insertComentario(c1);
        assertEquals(p1.getNaMosca(new EstrategiaSazonal()), 1, 0.00000001);
        p1.insertComentario(c2);
        assertEquals(p1.getNaMosca(new EstrategiaSazonal()), 1.5, 0.00000001);
        p1.insertComentario(c2);
        assertEquals(p1.getNaMosca(new EstrategiaSazonal()), 1.6666666666, 0.00000001);
        p1.insertComentario(c2);
        assertEquals(p1.getNaMosca(new EstrategiaSazonal()), 2, 0.00000001);
        p1.insertComentario(c2);
        p1.insertComentario(c3);
        p1.insertComentario(c5);
        p1.insertComentario(c4);
        p1.insertComentario(c2);
        p1.insertComentario(c5);
        p1.insertComentario(c3);
        assertEquals(p1.getNaMosca(new EstrategiaSazonal()), 0, 0.00000001);
        p1.insertComentario(c1);
        p1.insertComentario(c2);
        p1.insertComentario(c3);
        assertEquals(p1.getNaMosca(new EstrategiaSazonal()), 1, 0.00000001);
    }
    
    @Test
    public void testeComentRelevant() throws Exception{
        
        assertNull(p1.getRelevantComents(new EstrategiaSazonal()));
        p1.insertComentario(c1);
        assertEquals(p1.getRelevantComents(new EstrategiaSazonal())[0].getComent(), "comentario1");
        p1.insertComentario(c2);
        assertEquals(p1.getRelevantComents(new EstrategiaSazonal())[0].getComent(), "comentario2");
        assertEquals(p1.getRelevantComents(new EstrategiaSazonal())[1].getComent(), "comentario1");
        p1.insertComentario(c2);
        p1.insertComentario(c4);
        p1.insertComentario(c3);
        p1.insertComentario(c5);
        assertEquals(p1.getRelevantComents(new EstrategiaSazonal())[0].getComent(), "comentario5");
        assertEquals(p1.getRelevantComents(new EstrategiaSazonal())[1].getComent(), "comentario3");
    }
}
