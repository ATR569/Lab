package testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab08.Comentario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adson Macêdo
 */
public class TesteComentario {
 
    @Test
    public void testeConstrutor() throws Exception{
        Comentario c1 = new Comentario("teste", 1);
        Comentario c2 = new Comentario("teste", -2);
        Comentario c3 = new Comentario("teste", 2);
        assertEquals(c1.getComent(), "teste");
        assertEquals(c1.getNota(), 1);
        assertEquals(c2.getNota(), -2);
        assertEquals(c3.getNota(), 2);
        
        try{
            Comentario c4 = new Comentario(null, 2);
            fail("Esperava excessão pois o comentário é nulo.");
        } catch(Exception e){
            assertEquals(e.getMessage(), "O comentário não pode ser nulo.");
        }

        try{
            Comentario c4 = new Comentario("", 2);
            fail("Esperava excessão pois o comentário é vazio.");
        } catch(Exception e){
            assertEquals(e.getMessage(), "O tamanho do comentário tem que estar entre 1 e 140 caracteres.");
        }

        try{
            Comentario c4 = new Comentario("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 2);
            fail("Esperava excessão pois o comentário tem mais de 140 caracteres.");
        } catch(Exception e){
            assertEquals(e.getMessage(), "O tamanho do comentário tem que estar entre 1 e 140 caracteres.");
        }
        
        try{
            Comentario c4 = new Comentario("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 3);
            fail("Esperava excessão pois a nota tem que estar entre -2 e 2.");
        } catch(Exception e){
            assertEquals(e.getMessage(), "A nota tem que estar entre -2 e 2.");
        }
        
        try{
            Comentario c4 = new Comentario("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", -3);
            fail("Esperava excessão pois a nota tem que estar entre -2 e 2.");
        } catch(Exception e){
            assertEquals(e.getMessage(), "A nota tem que estar entre -2 e 2.");
        }
    }
    
}