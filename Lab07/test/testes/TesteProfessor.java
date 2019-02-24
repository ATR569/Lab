package testes;

import Lab07.Professor;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteProfessor {

    @Test
    public void testeConstrutor() throws Exception {
        Professor p1 = new Professor("Toin", 10000);
        Professor p2 = new Professor("OGAIHT", 5);
        Professor p3 = new Professor("Girafales", 5000.10);

        assertEquals(p1.getName(), "Toin");
        assertEquals(p2.getName(), "OGAIHT");
        assertEquals(p3.getName(), "Girafales");
        assertEquals(p1.getNumber(), 1);
        assertEquals(p2.getNumber(), 2);
        assertEquals(p3.getNumber(), 3);
        assertEquals(Professor.getCount(), 3);
        assertEquals(p1.getSalario(), 10000, 0);
        assertEquals(p2.getSalario(), 5, 0);
        assertEquals(p3.getSalario(), 5000.10, 0);

        try {
            Professor p4 = new Professor("", 1);
            fail("Esperava exceção pois a string não pode ser vazia");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "O nome não pode ser uma string vazia.");
        }

        try {
            Professor p4 = new Professor("Daniel", -100);
            fail("Esperava exceção pois o salário deve ser maior que 0");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "O salário tem que ser maior que 0.");
        }

        try {
            Professor p4 = new Professor("Daniel", 0);
            fail("Esperava exceção pois o salário deve ser maior que 0");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "O salário tem que ser maior que 0.");
        }
    }

    @Test
    public void testeaddDespMaterial() throws Exception {
        Professor p1 = new Professor("Heron", 10000);
        Professor p2 = new Professor("Janderson", 10000);
        Professor p3 = new Professor("Danilo", 10000);

        p1.addDespMaterial(500);
        p2.addDespMaterial(800);
        p3.addDespMaterial(1000);
        assertEquals(p1.getDespMaterial(), 500, 0);
        assertEquals(p2.getDespMaterial(), 800, 0);
        assertEquals(p3.getDespMaterial(), 1000, 0);

        p1.addDespMaterial(1000);
        p2.addDespMaterial(200);
        p3.addDespMaterial(400);
        assertEquals(p1.getDespMaterial(), 1500, 0);
        assertEquals(p2.getDespMaterial(), 1000, 0);
        assertEquals(p3.getDespMaterial(), 1400, 0); 
    }
    
    @Test
    public void testeTribute() throws Exception{
        Professor p1 = new Professor("Victor Hugo", 800);
        Professor p2 = new Professor("Felipe", 4000);
        Professor p3 = new Professor("Mauricio", 10000);
        
        assertEquals(p1.getTribute(), 40 ,0);
        assertEquals(p2.getTribute(), 400 ,0);
        assertEquals(p3.getTribute(), 2000 ,0);
        
        p1.addDespMaterial(10);
        p2.addDespMaterial(600);
        p3.addDespMaterial(350);
        
        assertEquals(p1.getDescontoAnual(), 5, 0);
        assertEquals(p2.getDescontoAnual(), 300, 0);
        assertEquals(p3.getDescontoAnual(), 175, 0);
        
        p1.addDespMaterial(10);
        p2.addDespMaterial(500);
        p3.addDespMaterial(750);        
        
        assertEquals(p1.getDescontoAnual(), 10, 0);
        assertEquals(p2.getDescontoAnual(), 550, 0);
        assertEquals(p3.getDescontoAnual(), 550, 0);        
        
    }

}
