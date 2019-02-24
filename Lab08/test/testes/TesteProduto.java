package testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab08.Comentario;
import lab08.EstrategiaSimples;
import lab08.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thairam Michel
 */
public class TesteProduto {

    @Test
    public void testeConstrutor() throws Exception {

        Produto p1 = new Produto("asas", 1);
        assertEquals(p1.getDescricao(), "asas");
        assertEquals(p1.getPreco(), 1, 0);

        try {
            Produto p2 = new Produto("", 1);
            fail("Esperava exceção pois a string não pode ser vazia");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Nome inválido.");
        }

        try {
            Produto p2 = new Produto(null, 1);
            fail("Esperava exceção pois a string não pode ser vazia");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Nome inválido.");
        }

        try {
            Produto p2 = new Produto("garras", -1);
            fail("Esperava exceção pois o preço deve ser maior que zero.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "O preço não pode ser negativo.");
        }
    }

    @Test
    public void testeComentarios() throws Exception {
        Produto p1 = new Produto("asas", 1);
        Comentario coment = new Comentario("otimo", 2);
        Comentario coment2 = new Comentario("regular", 1);
        Comentario coment3 = new Comentario("péssimo", 0);
        p1.insertComentario(coment);
        p1.insertComentario(coment2);
        p1.insertComentario(coment3);
        assertTrue(p1.getComentarios().contains(coment));
        assertTrue(p1.getComentarios().contains(coment2));
        assertTrue(p1.getComentarios().contains(coment3));
    }
}
