package testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Lab07.Caminhoneiro;
import Lab07.Contribuinte;
import Lab07.Medico;
import Lab07.Professor;
import Lab07.Taxista;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Adson Macêdo
 */
public class TesteContribuinte {
    static Taxista t1, t2, t3;
    static Caminhoneiro ca1, ca2, ca3;
    static Professor p1, p2, p3;
    static Medico m1, m2, m3, m4;
    
    @BeforeClass
    public static void Setup() throws Exception{
        t1 = new Taxista("Dona Joana da brasilia azul");
        t2 = new Taxista("Maria do corsinha amarelo");
        t3 = new Taxista("Maria josé do fiat uno cinza");

        ca1 = new Caminhoneiro("Dona Joana da brasilia azul");
        ca2 = new Caminhoneiro("Maria do corsinha amarelo");
        ca3 = new Caminhoneiro("Maria josé do fiat uno cinza");

        p1 = new Professor("Dona Joana da brasilia azul", 1000);
        p2 = new Professor("Maria do corsinha amarelo", 2000);
        p3 = new Professor("Maria josé do fiat uno cinza", 3000);

        m1 = new Medico("Dona Joana da brasilia azul");
        m2 = new Medico("Maria do corsinha amarelo");
        m3 = new Medico("Maria josé do fiat uno cinza");
    }
    
    @Test
    public void testeConstrutor() throws Exception{
        Contribuinte c1 = new Caminhoneiro("José Geraldo Gerônimo");
        Contribuinte c2 = new Caminhoneiro("Bino");
        
        assertEquals(c1.getName(), "José Geraldo Gerônimo");
        assertEquals(c2.getName(), "Bino");
        assertEquals(c1.getNumber(), 13);
        assertEquals(c2.getNumber(), 14);
        assertEquals(Caminhoneiro.getCount(), 5);
        
        try{
            Caminhoneiro c3 = new Caminhoneiro("");
            fail("Esperava exceção pois a string não pode ser vazia");
        } catch (Exception e){
            assertEquals(e.getMessage(), "O nome não pode ser uma string vazia.");
        }
        
        Contribuinte c3 = new Taxista("João");
        Contribuinte c4 = new Medico("José, meu nome é Zé!");
        Contribuinte c5 = new Professor("Toin", 10000);
        Contribuinte c6 = new Professor("Daniel Gondim", 25000);
        
        assertEquals(c4.getNumber(), 16);
        assertEquals(c5.getNumber(), 17);
        assertEquals(c6.getNumber(), 18);
        assertEquals(Taxista.getCount(), 4);
        assertEquals(Medico.getCount(), 4);
        assertEquals(Professor.getCount(), 5);
        
        Contribuinte c7 = new Taxista("João2");
        Contribuinte c8 = new Taxista("João3");
        Contribuinte c9 = new Taxista("João4");
        Contribuinte c10 = new Taxista("João5");
        
        assertEquals(Caminhoneiro.getCount(), 5);
        assertEquals(Taxista.getCount(), 8);
        assertEquals(Professor.getCount(), 5);
        assertEquals(Medico.getCount(), 4);
        
        assertEquals(c8.getName(), "João3");
        assertEquals(c9.getName(), "João4");
        assertEquals(c10.getName(), "João5");
        assertEquals(c1.getNumber(), 13);
        assertEquals(c2.getNumber(), 14);
        assertEquals(c3.getNumber(), 15);
        assertEquals(c4.getNumber(), 16);
        assertEquals(c5.getNumber(), 17);
        assertEquals(c6.getNumber(), 18);
        assertEquals(c7.getNumber(), 19);
        assertEquals(c8.getNumber(), 20);
        assertEquals(c9.getNumber(), 21);
        assertEquals(c10.getNumber(), 22);
    }
    
    @Test
    public void testPatrimony() throws Exception{
        Contribuinte c1 = new Caminhoneiro("Mengão!!! SEGUE O LÍDER!");
        Contribuinte c2 = new Taxista("Raposa Feroz");
        Contribuinte c3 = new Professor("Mengão de novo", 1000000000);
        Contribuinte c4 = new Medico("Campinense");
        
        assertEquals(c1.getHousesValues(), 0, 0.0001);
        assertEquals(c2.getHousesValues(), 0, 0.0001);
        assertEquals(c3.getHousesValues(), 0, 0.0001);
        assertEquals(c4.getHousesValues(), 0, 0.0001);
        
        assertEquals(c1.getCarsValues(), 0, 0.0001);
        assertEquals(c2.getCarsValues(), 0, 0.0001);
        assertEquals(c3.getCarsValues(), 0, 0.0001);
        assertEquals(c4.getCarsValues(), 0, 0.0001);

        assertEquals(c1.getPatrimony(), 0, 0.0001);
        assertEquals(c2.getPatrimony(), 0, 0.0001);
        assertEquals(c3.getPatrimony(), 0, 0.0001);
        assertEquals(c4.getPatrimony(), 0, 0.0001);
        
        for (int i = 10; i <= 100; i += 10) {
            c1.insertCar(i);
        }
        assertEquals(c1.getCarsValues(), 550, 0.0001);
        assertEquals(c1.getHousesValues(), 0, 0.0001);
        assertEquals(c1.getPatrimony(), 550, 0.0001);
        
        
        for (int i = 12; i <= 100; i += 10) {
            c2.insertHouse(i);
        }
        assertEquals(c2.getCarsValues(), 0, 0.0001);
        assertEquals(c2.getHousesValues(), 468, 0.0001);
        assertEquals(c2.getPatrimony(), 468, 0.0001);
        
        for (int i = 7; i <= 50; i += 7) {
            c1.insertHouse(i);
        }
        
        assertEquals(c1.getCarsValues(), 550, 0.0001);
        assertEquals(c1.getHousesValues(), 196, 0.0001);
        assertEquals(c1.getPatrimony(), 746, 0.0001);
    }

    @Test
    public void testeIllicitEnrichment() throws Exception{
        Medico m4 = new Medico("TTTTTTTTT");
        Medico m5 = new Medico("MMMMMMMMM");
        
        m1.insertCar(15);
        m1.insertCar(17);
        
        m1.insertHouse(10);
        m1.insertHouse(24);

        m2.insertCar(7);
        m2.insertCar(11);
        m2.insertCar(10);
        
        m2.insertHouse(15);
        m2.insertHouse(8);

        m3.insertCar(5);
        m3.insertCar(12);
        
        m3.insertHouse(12);

        m4.insertCar(8);
        m4.insertCar(10);
        
        m4.insertHouse(20);
        m4.insertHouse(20);
        
        //  média 37 * 1.5 = 51;
        assertEquals(m1.getCarsValues(), 32, 0);
        assertEquals(m2.getCarsValues(), 28, 0);
        assertEquals(m3.getCarsValues(), 17, 0);
        assertEquals(m4.getCarsValues(), 18, 0);

        assertEquals(m1.getHousesValues(), 34, 0);
        assertEquals(m2.getHousesValues(), 23, 0);
        assertEquals(m3.getHousesValues(), 12, 0);
        assertEquals(m4.getHousesValues(), 40, 0);
        
        assertTrue(m1.illicitEnrichment());
        assertFalse(m2.illicitEnrichment());
        assertFalse(m3.illicitEnrichment());
        assertTrue(m4.illicitEnrichment());
        
        m5.insertCar(59);
        //  média 43.833 * 1.5 = 65.75;
        assertTrue(m1.illicitEnrichment());
        assertFalse(m2.illicitEnrichment());
        assertFalse(m3.illicitEnrichment());
        assertFalse(m4.illicitEnrichment());
        assertFalse(m5.illicitEnrichment());
        
        m5.insertHouse(1);
        assertFalse(m1.illicitEnrichment());
        assertFalse(m2.illicitEnrichment());
        assertFalse(m3.illicitEnrichment());
        assertFalse(m4.illicitEnrichment());
        assertFalse(m5.illicitEnrichment());
        
        Contribuinte c = new Medico("Socrates");
        assertTrue(m1.illicitEnrichment());
        assertFalse(m2.illicitEnrichment());
        assertFalse(m3.illicitEnrichment());
        assertTrue(m4.illicitEnrichment());
        assertTrue(m5.illicitEnrichment());
    }
    
}
