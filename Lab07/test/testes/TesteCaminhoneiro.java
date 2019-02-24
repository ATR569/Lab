package testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Lab07.Caminhoneiro;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adson Macêdo
 */
public class TesteCaminhoneiro {
        
    @Test
    public void testeTons() throws Exception{
        Caminhoneiro c1 = new Caminhoneiro("José Geraldo Gerônimo");
        
        c1.insertTons(15);
        assertEquals(c1.getTons(), 15, 0);
        c1.insertTons(20);
        assertEquals(c1.getTons(), 35, 0);
        
        try{
            c1.insertTons(0);
            fail("Esperava exceção pois as toneladas tem que ser maior que 0.");
        } catch (Exception e){
            assertEquals(e.getMessage(), "Quantidade de toneladas tem que ser maior que 0.");
        }
        
        try{
            c1.insertTons(-10);
            fail("Esperava exceção pois as toneladas tem que ser maior que 0.");
        } catch (Exception e){
            assertEquals(e.getMessage(), "Quantidade de toneladas tem que ser maior que 0.");
        }
    }
    
    @Test
    public void testeCalcTribute() throws Exception {
        Caminhoneiro c1 = new Caminhoneiro("Sergio Reis");
        Caminhoneiro c2 = new Caminhoneiro("Michael Jackson");
        assertEquals(Caminhoneiro.getCount(), 2);

        c1.insertTons(5);
        c1.insertTons(10);
        c1.insertTons(15);
        c1.insertTons(20);
        assertEquals(c1.getTons(), 50, 0.00001);
        assertEquals(c1.getTribute(), 4500, 0.00001);
        
        c1.addKm(1600);
        assertEquals(c1.getDescontoAnual(), 16, 0);
        assertEquals(c1.getTribute(), 4484, 0);
        c1.addKm(448399.9999);
        assertEquals(c1.getTribute(), 0, 0.00001);

        c2.insertTons(8);
        c2.insertTons(12);
        c2.insertTons(90);
        c2.insertTons(110);
        assertEquals(c2.getTons(), 220, 0.00001);
        assertEquals(c2.getTribute(), 21500, 0.00001);
        
        c2.addKm(86235.59);
        assertEquals(c2.getDescontoAnual(), 862.3559, 0.00001);
        assertEquals(c2.getTribute(), 20637.6441, 0.00001);
        c2.addKm(206376441);
        assertEquals(c2.getTribute(), 0, 0.00001);
        c1.insertTons(1);
        assertEquals(c1.getTribute(), 100, 0.00001);
    }
    
}
