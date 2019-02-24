package testes;

import Lab07.Taxista;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Curupira
 */
public class TesteTaxista {

    @Test
    public void testeInsertPassengers() throws Exception {
        Taxista t1 = new Taxista("Maria josé do fiat uno cinza");

        t1.insertPassengers(15);
        assertEquals(t1.getPassengers(), 15);
        t1.insertPassengers(20);
        assertEquals(t1.getPassengers(), 35);

        try {
            t1.insertPassengers(0);
            fail("Esperava exceção pois a quantidade de passageiros tem que ser maior que 0.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade de passageiros tem que ser maior que 0.");
        }

        try {
            t1.insertPassengers(-10);
            fail("Esperava exceção pois a quantidade de passageiros tem que ser maior que 0.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade de passageiros tem que ser maior que 0.");
        }
    }

    @Test
    public void testeCalcTribute() throws Exception {
        Taxista t1 = new Taxista("Dona Joana da brasilia azul");
        Taxista t2 = new Taxista("Maria do corsinha amarelo");

        assertEquals(Taxista.getCount(), 2);

        t1.insertPassengers(5);
        t1.insertPassengers(10);
        t1.insertPassengers(15);
        t1.insertPassengers(20);
        assertEquals(t1.getPassengers(), 50);
        assertEquals(t1.getTribute(), 25, 0);
        
        t1.addKm(1600);
        assertEquals(t1.getDescontoAnual(), 16, 0);
        assertEquals(t1.getTribute(), 9, 0);

        t2.insertPassengers(8);
        t2.insertPassengers(12);
        t2.insertPassengers(90);
        t2.insertPassengers(110);
        assertEquals(t2.getPassengers(), 220);
        assertEquals(t2.getTribute(), 110, 0);
        
        t2.addKm(800);
        assertEquals(t2.getDescontoAnual(), 8, 0);
        assertEquals(t2.getTribute(), 102, 0);

    }
}
