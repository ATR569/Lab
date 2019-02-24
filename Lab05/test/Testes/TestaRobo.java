package Testes;


import Lab05.Sala;
import Lab05.Robo;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestaRobo {

    private Sala sala;
    private final int POWER = 10;
    private Robo robo;

    @Before
    public void criaRobo() throws Exception {
        sala = new Sala(10, 10);
        robo = new Robo(sala, POWER);
    }

    @Test
    public void testaCriaRobo() throws Exception {
        // Testa com a energia negativa
        try {
            new Robo(sala, -10);
            Assert.fail("Esperava excecao, pois o robo não pode ser criado com energia negativa.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do Robo. A energia deve ser representada por um valor maior que zero.",
                    e.getMessage());
        }
        // Testa com a energia = 0
        try {
            new Robo(sala, 0);
            Assert.fail("Esperava excecao, pois o robo não pode ser criado com energia negativa.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do Robo. A energia deve ser representada por um valor maior que zero.",
                    e.getMessage());
        }
        // Testa com a sala NULL
        try {
            new Robo(null, POWER);
            Assert.fail("Esperava excecao, pois o robo deve ser criado em uma sala válida.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do Robo. A Sala não pode ser inválida.",
                    e.getMessage());
        }

        try {
            Sala sala1 = new Sala(2, 2);
            sala1.inserirObstaculo(0, 0);
            sala1.inserirObstaculo(0, 1);
            sala1.inserirObstaculo(1, 1);
            sala1.inserirObstaculo(1, 0);
            new Robo(sala1, POWER);
            Assert.fail("Esperava excecao, pois o robo não pode ser criado em uma sala cheia.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do Robo. A sala se encontra totalmente ocupada.",
                    e.getMessage());
        }
        // Criar um robo power positivo e sala vazia, verificar que a posição dele é (0,0) e logo após que a mesma etá ocupada
        Sala sala2 = new Sala(10, 10);
        Robo r1 = new Robo(sala2, POWER);
        assertEquals(Arrays.toString(r1.getPos()), "[0, 0]");
        assertFalse(sala2.isPosicaoLivre(0, 0));

        // Verificar se após ocupar a posição (0,0) o robô será inserido na (0,1)
        Sala sala3 = new Sala(10, 10);
        sala3.inserirObstaculo(0, 0);
        Robo robo2 = new Robo(sala3, POWER);
        assertEquals(Arrays.toString(robo2.getPos()), "[0, 1]");
        
        Sala sala4 = new Sala(3,3);
        sala4.inserirObstaculo(0, 0);
        sala4.inserirObstaculo(0, 1);
        sala4.inserirObstaculo(0, 2);
        sala4.inserirObstaculo(1, 0);
        sala4.inserirObstaculo(1, 1);
        sala4.inserirObstaculo(1, 2);
        sala4.inserirObstaculo(2, 2);
        sala4.inserirObstaculo(2, 0);
        
        Robo robo4 = new Robo(sala4, POWER);
        assertEquals(Arrays.toString(robo4.getPos()), "[2, 1]");

        try {
            new Robo(sala4, POWER);
            Assert.fail("Esperava excecao, pois o robo não pode ser criado em uma sala cheia.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do Robo. A sala se encontra totalmente ocupada.",
                    e.getMessage());
        }
    }

    @Test
    public void testaMovimentos() throws Exception {

        assertFalse(robo.moveLeft());
        assertFalse(robo.moveFront());
        assertEquals(robo.getPower(), 10);
        assertEquals(robo.getSteps(), 0);
        assertTrue(robo.moveBack());
        assertEquals(Arrays.toString(robo.getPos()), "[1, 0]");
        assertTrue(robo.moveRight());
        assertEquals(Arrays.toString(robo.getPos()), "[1, 1]");
        assertTrue(robo.moveFront());
        assertTrue(robo.moveLeft());
        assertTrue(robo.getPower() < 10);
        assertTrue(robo.getSteps() > 0);

    }

    @Test
    public void testaMovimentacaoObstaculos() throws Exception {
        Sala sala1 = new Sala(10, 10);
        Robo robo1 = new Robo(sala1, POWER);
        sala1.inserirObstaculo(1, 0);
        sala1.inserirObstaculo(0, 2);
        assertEquals(Arrays.toString(robo1.getPos()), "[0, 0]");

        assertFalse(robo1.moveBack());
        assertEquals(robo1.getPower(), 10);
        assertTrue(robo1.moveRight());
        assertEquals(Arrays.toString(robo1.getPos()), "[0, 1]");

        assertEquals(robo1.getSteps(), 1);
        assertEquals(robo1.getPower(), 9);
        assertFalse(robo1.moveRight());
        assertEquals(robo1.getSteps(), 1);
        assertEquals(robo1.getPower(), 9);
        assertTrue(robo1.moveBack());
        assertEquals(Arrays.toString(robo1.getPos()), "[1, 1]");

        assertEquals(robo1.getSteps(), 2);
        assertEquals(robo1.getPower(), 8);
        assertTrue(robo1.moveRight());
        assertEquals(Arrays.toString(robo1.getPos()), "[1, 2]");

        assertEquals(robo1.getSteps(), 3);
        assertEquals(robo1.getPower(), 7);
        assertFalse(robo1.moveFront());
        assertEquals(robo1.getSteps(), 3);
        assertEquals(robo1.getPower(), 7);
        assertTrue(robo1.moveBack());
        assertEquals(Arrays.toString(robo1.getPos()), "[2, 2]");

        assertEquals(robo1.getSteps(), 4);
        assertEquals(robo1.getPower(), 6);
        assertTrue(robo1.moveLeft());
        assertEquals(Arrays.toString(robo1.getPos()), "[2, 1]");

        assertEquals(robo1.getSteps(), 5);
        assertEquals(robo1.getPower(), 5);
        sala1.inserirObstaculo(1, 1);
        sala1.inserirObstaculo(3, 1);
        sala1.inserirObstaculo(2, 2);
        sala1.inserirObstaculo(2, 0);
        assertFalse(robo1.moveFront());
        assertFalse(robo1.moveLeft());
        assertFalse(robo1.moveRight());
        assertFalse(robo1.moveBack());
        assertEquals(robo1.getSteps(), 5);
        assertEquals(robo1.getPower(), 5);

    }

    @Test
    public void testaMovimentacao() throws Exception {
        Sala sala1 = new Sala(5, 5);
        Robo robo1 = new Robo(sala1, POWER);
        
        assertEquals(robo1.getSteps(), 0);
        assertEquals(robo1.getPower(), 10);
        assertEquals(Arrays.toString(robo1.getPos()), "[0, 0]");

        robo1.moveFront();
        robo1.moveLeft();
        assertEquals(robo1.getSteps(), 0);
        assertEquals(robo1.getPower(), 10);
        assertEquals(Arrays.toString(robo1.getPos()), "[0, 0]");
        
        robo1.moveRight();
        robo1.moveRight();
        robo1.moveRight();
        robo1.moveBack();
        robo1.moveBack();
        assertEquals(robo1.getSteps(), 5);
        assertEquals(robo1.getPower(), 5);
        assertEquals(Arrays.toString(robo1.getPos()), "[2, 3]");
        
        robo1.moveRight();
        robo1.moveRight();
        robo1.moveRight();
        robo1.moveBack();
        robo1.moveBack();
        assertEquals(robo1.getSteps(), 8);
        assertEquals(robo1.getPower(), 2);
        assertEquals(Arrays.toString(robo1.getPos()), "[4, 4]");
        
        robo1.moveRight();
        robo1.moveRight();
        robo1.moveRight();
        robo1.moveBack();
        robo1.moveBack();
        assertEquals(robo1.getSteps(), 8);
        assertEquals(robo1.getPower(), 2);
        assertEquals(Arrays.toString(robo1.getPos()), "[4, 4]");

        robo1.moveLeft();
        robo1.moveLeft();
        robo1.moveBack();
        robo1.moveLeft();
        robo1.moveFront();
        robo1.moveRight();
        assertEquals(robo1.getSteps(), 10);
        assertEquals(robo1.getPower(), 0);
        assertEquals(Arrays.toString(robo1.getPos()), "[4, 2]");
        
        Robo robo2 = new Robo(sala1, 50);
        robo2.moveBack();
        robo2.moveBack();
        robo2.moveBack();
        robo2.moveBack();
        robo2.moveRight();
        robo2.moveRight();
        robo2.moveRight();
        assertEquals(robo2.getSteps(), 5);
        assertEquals(robo2.getPower(), 45);
        assertEquals(Arrays.toString(robo2.getPos()), "[4, 1]");
        
        robo2.moveLeft();
        robo2.moveLeft();
        robo2.moveBack();
        assertEquals(robo2.getSteps(), 6);
        assertEquals(robo2.getPower(), 44);
        assertEquals(Arrays.toString(robo2.getPos()), "[4, 0]");

        robo2.moveRight();
        robo2.moveFront();
        robo2.moveRight();
        assertEquals(robo2.getSteps(), 9);
        assertEquals(robo2.getPower(), 41);
        assertEquals(Arrays.toString(robo2.getPos()), "[3, 2]");

        robo2.moveBack();
        robo2.moveRight();
        robo2.moveBack();
        robo2.moveRight();
        robo2.moveRight();
        robo2.moveBack();
        assertEquals(robo2.getSteps(), 12);
        assertEquals(robo2.getPower(), 38);
        assertEquals(Arrays.toString(robo2.getPos()), "[4, 4]");

        robo2.moveFront();
        robo2.moveFront();
        robo2.moveFront();
        robo2.moveFront();
        robo2.moveRight();
        robo2.moveRight();
        robo2.moveFront();
        assertEquals(robo2.getSteps(), 16);
        assertEquals(robo2.getPower(), 34);
        assertEquals(Arrays.toString(robo2.getPos()), "[0, 4]");
    }
    
    @Test
    public void testEquals() throws Exception{
        Sala sala1 = new Sala(10, 10);
        Sala sala2 = new Sala(5, 10);
        Sala sala3 = new Sala(10, 10);
        Sala sala4 = new Sala(10, 10);
        
        sala1.inserirObstaculo(5, 5);

        Robo robo1 = new Robo(sala1, POWER);
        Robo robo2 = new Robo(sala2, POWER);
        Robo robo3 = new Robo(sala3, POWER);
        Robo robo4 = new Robo(sala4, POWER);
        
        assertNotEquals(robo3, robo2);
        assertEquals(robo3, robo4);
        assertNotEquals(robo1, robo4);
        assertNotEquals(robo1, robo3);
        assertNotEquals(robo2, robo3);
        assertEquals(robo2, robo2);
        sala3.inserirObstaculo(5, 5);
        assertEquals(robo1, robo3);
        
        robo1.moveBack();
        assertNotEquals(robo1, robo3);
        robo3.moveBack();
        assertEquals(robo1, robo3);
        assertNotEquals(robo1, robo4);
        sala1.inserirObstaculo(0, 0);
        sala1.inserirObstaculo(1, 1);
        sala1.inserirObstaculo(2, 2);
        sala1.inserirObstaculo(3, 3);
        sala1.inserirObstaculo(4, 4);
        
        sala3.inserirObstaculo(0, 0);
        sala3.inserirObstaculo(1, 1);
        sala3.inserirObstaculo(3, 3);
        sala3.inserirObstaculo(4, 4);

        assertNotEquals(robo1, robo3);
        sala3.inserirObstaculo(2, 2);
        assertEquals(robo1, robo3);
        assertNotEquals(robo1, robo4);
    }
}
