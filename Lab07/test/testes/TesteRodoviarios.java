/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import Lab07.Caminhoneiro;
import Lab07.Rodoviarios;
import Lab07.Taxista;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adson Macêdo
 */
public class TesteRodoviarios {
    
    @Test
    public void testeKm() throws Exception{
        Rodoviarios r1 = new Caminhoneiro("Teste");
        
        assertEquals(r1.getKm(), 0, 0);
        r1.addKm(15);
        assertEquals(r1.getKm(), 15, 0);
        
        try{
            r1.addKm(0);
            fail("Esperava excessão, pois não se pode adicionar quilometragem igual a zero.");
        } catch(Exception e){
            assertEquals(e.getMessage(), "O número de quilômetros tem que ser positivo.");
        }
        
        try{
            r1.addKm(-1);
            fail("Esperava excessão, pois não se pode adicionar quilometragem negativa.");
        } catch(Exception e){
            assertEquals(e.getMessage(), "O número de quilômetros tem que ser positivo.");
        }
    }
    
    @Test
    public void testeDescontoAnual() throws Exception{
        Rodoviarios r1 = new Caminhoneiro("João Grilo");
        Rodoviarios r2 = new Taxista("Chicó");
        
        assertEquals(r1.getDescontoAnual(), 0, 0.001);
        
        r1.addKm(15);
        assertEquals(r1.getDescontoAnual(), 0.15, 0.001);
        r1.addKm(15.7);
        r1.addKm(12.4);
        assertEquals(r1.getDescontoAnual(), 0.431, 0.001);
        
        assertEquals(r2.getDescontoAnual(), 0, 0.001);
        r2.addKm(12.4);
        assertEquals(r2.getDescontoAnual(), 0.124, 0.001);
        r2.addKm(735.75);
        r2.addKm(1208.4);
        assertEquals(r2.getDescontoAnual(), 19.5655, 0.001);
        r1.addKm(100000);
        assertEquals(r1.getDescontoAnual(), 1000.431, 0.001);
        
    }
}
