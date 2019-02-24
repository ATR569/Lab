package testes;


import lab06.CD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestaCD {

    private CD cd;

    @Before
    public void criaCD() throws Exception {
        cd = new CD("As melhores de Roger","Rogeraldo Apaixonado", 20);
    }

    @Test
    public void testaCriaCD() throws Exception {
        
        try {
            new CD("", "João");
            Assert.fail("Esperava exceção, pois o CD não pode ser criado com título vazio.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do CD. O titulo não pode ser nulo.",
                    e.getMessage());
        }

        try {
            new CD(null, "João");
            Assert.fail("Esperava exceção, pois o CD não pode ser criado com título nulo.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do CD. O titulo não pode ser nulo.",
                    e.getMessage());
        }

        try {
            new CD("As melhores", "");
            Assert.fail("Esperava exceção, pois o CD não pode ser criado com artista vazio.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do CD. O artista não pode ser nulo.",
                    e.getMessage());
        }

        try {
            new CD("As melhores", null);
            Assert.fail("Esperava exceção, pois o CD não pode ser criado com artista vazio.");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do CD. O artista não pode ser nulo.",
                    e.getMessage());
        }
        
        try {
            new CD("As melhores", "Rogeraldo", -1);
            Assert.fail("Esperava exceção, pois o CD não pode ser criado com um valor negativo de faixas");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Parametros incorretos para a criacao do CD. O número de faixas tem que ser maior que zero.",
                    e.getMessage());
        }        
        
        Assert.assertTrue(cd.getArtista().equals("Rogeraldo Apaixonado"));
        Assert.assertFalse(cd.getArtista().equals("Canções do Rogeraldo"));
        Assert.assertFalse(cd.getArtista() == null);
        Assert.assertFalse(cd.getArtista().equals(""));
        
        Assert.assertTrue(cd.getTitulo().equals("As melhores de Roger"));        
        Assert.assertFalse(cd.getTitulo().equals("As melhores do Rogeraldo"));        
        Assert.assertFalse(cd.getTitulo().equals(""));
        Assert.assertFalse(cd.getTitulo() == null);

        Assert.assertTrue(cd.getQuantidadeFaixas() == 20);
        Assert.assertFalse(cd.getQuantidadeFaixas() != 20);

    }
    
    @Test
    public void testaFaixa() throws Exception{
       CD cd1 = new CD("As melhores de Roger","Rogeraldo Apaixonado", 4);
       cd1.insertFaixa("A melô dos óios dela");
       
        try {
            cd1.setTrilhaPrincipal("Os beiço dela são como mé de abea");
            Assert.fail("Esperava excecao, pois a faixa não está no CD");
        } catch (Exception e) {
            Assert.assertEquals(
                    "Mensagem errada",
                    "Impossível, a faixa não se encontra no CD.",
                    e.getMessage());
        }
        
        assertNotEquals(cd1.getQuantidadeFaixas(), 5);
        assertEquals(cd1.getQuantidadeFaixas(), 4);
        
        cd1.insertFaixa("Os beiço dela são como mé de abea");
        cd1.setTrilhaPrincipal("Os beiço dela são como mé de abea");
        
        assertTrue(cd1.getTrilhaPrincipal().equals("Os beiço dela são como mé de abea"));
        assertTrue(cd1.getFaixa(1).equals("A melô dos óios dela"));
        assertFalse(cd1.getFaixa(2).equals("A melô dos óios dela"));
        
        cd1.insertFaixa("O barreiro do vei Antoim");
        cd1.insertFaixa("A rodage que dá pra minha casa");
        
        assertNull(cd1.getFaixa(5));
        
        cd1.setTrilhaPrincipal("O barreiro do vei Antoim");
        
        assertTrue(cd1.getTrilhaPrincipal().equals("O barreiro do vei Antoim"));
        
        assertFalse(cd1.insertFaixa("A melo da veia"));
        
    }
    
    @Test
    public void testeEquals() throws Exception{
        CD cd2 = new CD("titulo1", "artista1", 5);
        CD cd3 = new CD("titulo1", "artista1", 5);
        CD cd4 = new CD("titulo2", "artista2", 10);
        CD cd5 = new CD("titulo1", "artista1", 6);
        
        Assert.assertEquals(cd2, cd3);
        Assert.assertNotEquals(cd2, cd4);
        Assert.assertNotEquals(cd4, cd3);
        Assert.assertEquals(cd2, cd5);
        Assert.assertNotEquals(cd4, cd5);
    }

}
