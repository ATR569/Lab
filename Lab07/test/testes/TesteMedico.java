package testes;

import Lab07.Medico;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteMedico {

    @Test
    public void testeInsertCongress() throws Exception {

        Medico m1 = new Medico("Adolfo");

        m1.insertCongress(4);
        assertEquals(m1.getCongress(), 4, 0);
        m1.insertCongress(6);
        assertEquals(m1.getCongress(), 10, 0);

        try {
            m1.insertCongress(0);
            fail("Esperava exceção pois os congressos tem que ser maior que 0.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade de congressos tem que ser maior que 0.");
        }

        try {
            m1.insertCongress(-5);
            fail("Esperava exceção pois os congressos tem que ser maior que 0.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade de congressos tem que ser maior que 0.");
        }
    }

    @Test
    public void testeInsertPatient() throws Exception {
        Medico m1 = new Medico("Marinézio");

        m1.insertPatient(10);
        assertEquals(m1.getPatients(), 10);
        m1.insertPatient(15);
        assertEquals(m1.getPatients(), 25);

        try {
            m1.insertPatient(0);
            fail("Esperava exceção pois os pacientes tem que ser maior que 0.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade de pacientes tem que ser maior que 0.");
        }

        try {
            m1.insertPatient(-10);
            fail("Esperava exceção pois os pacientes tem que ser maior que 0.");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade de pacientes tem que ser maior que 0.");
        }
    }

    @Test
    public void testeGetTribute() throws Exception {
        Medico m1 = new Medico("Dagoberto");
        Medico m2 = new Medico("Ernesto");

        m1.insertPatient(300);
        m2.insertPatient(155);
        m1.insertCongress(1000);
        m2.insertCongress(1000);

        assertEquals(m1.getTribute(), 2000, 0);
        assertEquals(m2.getTribute(), 550, 0);
        m1.insertPatient(100);
        m1.insertCongress(300);
        assertEquals(m1.getTribute(), 2700, 0);
        m2.insertPatient(45);
        m2.insertCongress(200);
        assertEquals(m2.getTribute(), 800, 0);

    }

    @Test
    public void testeDescontoAnual() throws Exception {
        Medico m1 = new Medico("Anastácio");
        Medico m2 = new Medico("Energúmeno");
        Medico m3 = new Medico("Farizeu");

        m1.insertCongress(1578.50);
        m2.insertCongress(1235.00);
        m3.insertCongress(2687.19);

        assertEquals(m1.getDescontoAnual(), 1578.50, 0);
        assertEquals(m2.getDescontoAnual(), 1235, 0);
        assertEquals(m3.getDescontoAnual(), 2687.19, 0);

        m1.insertCongress(421.50);
        m2.insertCongress(765.00);
        m3.insertCongress(312.81);

        assertEquals(m1.getDescontoAnual(), 2000, 0);
        assertEquals(m2.getDescontoAnual(), 2000, 0);
        assertEquals(m3.getDescontoAnual(), 3000, 0);

    }

}
