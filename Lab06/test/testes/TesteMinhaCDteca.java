package testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab06.CD;
import lab06.MinhaCDteca;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Adson Macêdo
 */
public class TesteMinhaCDteca {
    MinhaCDteca cdTeca1;
    MinhaCDteca cdTeca2;
    CD cd1, cd2, cd3, cd4, cd5;
    
    
    @Before
    public void setup() throws Exception {
        cdTeca1 = new MinhaCDteca();
        cdTeca2 = new MinhaCDteca();
        cd1 = new CD("titulo1", "artista1");
        cd2 = new CD("titulo2", "artista2");
        cd3 = new CD("titulo3", "artista3");
        cd4 = new CD("titulo4", "artista4");
    }
    
    @Test
    public void testaAdicionaCD() throws Exception{
        try{
            cdTeca1.adicionaCD(cd5);
            Assert.fail("Esperava excessão pois o cd é nulo.");
        } catch (Exception e){
            Assert.assertEquals("Não é possível adicionar um cd nulo na CDteca.", e.getMessage());
        }
        
        cdTeca1.adicionaCD(cd1);
        cdTeca1.adicionaCD(cd2);
        cdTeca1.adicionaCD(cd3);
        
        Assert.assertEquals(cdTeca1.numeroDeCDs(), 3);
        Assert.assertEquals(cdTeca1.pesquisaCD("asdas"), null);
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo1"), cd1);
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo2"), cd2);
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo3"), cd3);
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo4"), null);
        
    }
    
    @Test
    public void testaAdicionaCDs() throws Exception{
        MinhaCDteca cdTeca3 = new MinhaCDteca();
        MinhaCDteca cdTeca4 = new MinhaCDteca();

        try{
            cdTeca4.adicionaCDs(null);
            Assert.fail("Esperava excessão pois a lista é nula.");
        } catch (Exception e){
            Assert.assertEquals("A lista de cds a serem adicionados não pode ser nula.", e.getMessage());
        }

        try{
            cdTeca4.adicionaCDs(cdTeca3.getCDs());
            Assert.fail("Esperava excessão pois a lista é vazia.");
        } catch (Exception e){
            Assert.assertEquals("A lista de cds deve conter ao menos um cd.", e.getMessage());
        }
        
        cdTeca3.adicionaCD(cd1);
        cdTeca3.adicionaCD(cd2);
        cdTeca3.adicionaCD(cd3);
        
        cdTeca4.adicionaCDs(cdTeca3.getCDs());
        Assert.assertEquals(cdTeca3.numeroDeCDs(), cdTeca4.numeroDeCDs());    
    }
    
    @Test
    public void testeRemoveCD() throws Exception{
        cdTeca1.adicionaCD(cd3);

        Assert.assertEquals(cdTeca1.removeCD("titulo3"), cd3);
        Assert.assertEquals(cdTeca1.removeCD("titulo3"), null);
        cdTeca1.adicionaCD(cd1);
        cdTeca1.adicionaCD(cd2);
        cdTeca1.adicionaCD(cd2);
        cdTeca1.adicionaCD(cd3);
        cdTeca1.adicionaCD(cd3);
        Assert.assertEquals(cdTeca1.removeCD("titulo4"), null);
        Assert.assertEquals(cdTeca1.removeCD("titulo1"), cd1);
        Assert.assertEquals(cdTeca1.removeCD("titulo1"), null);
        Assert.assertEquals(cdTeca1.removeCD("titulo2"), cd2);
        Assert.assertEquals(cdTeca1.removeCD("titulo2"), cd2);
        Assert.assertEquals(cdTeca1.removeCD("titulo3"), cd3);
        Assert.assertEquals(cdTeca1.removeCD("titulo3"), cd3);
        Assert.assertEquals(cdTeca1.removeCD("titulo2"), null);
        Assert.assertEquals(cdTeca1.removeCD("titulo3"), null);
    }
    
    @Test
    public void testeRemoveCDs() throws Exception{
        cdTeca1.adicionaCD(cd1);
        cdTeca1.adicionaCD(cd2);
        cdTeca1.adicionaCD(cd3);
        cdTeca1.adicionaCD(cd4);
        
        Assert.assertFalse(cdTeca2.removeCDs(cdTeca1.getCDs()));
        cdTeca2.adicionaCD(cd1);
        cdTeca2.adicionaCD(cd3);
        Assert.assertTrue(cdTeca1.removeCDs(cdTeca2.getCDs()));
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo1"), null);
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo2"), cd2);
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo3"), null);
        Assert.assertEquals(cdTeca1.pesquisaCD("titulo4"), cd4);
        
        Assert.assertFalse(cdTeca1.removeCDs(cdTeca2.getCDs()));
        Assert.assertFalse(cdTeca2.removeCDs(cdTeca1.getCDs()));
        Assert.assertTrue(cdTeca1.removeCDs(cdTeca1.getCDs()));
    }
    
    @Test
    public void numeroDeCDs() throws Exception{
        Assert.assertEquals(cdTeca1.numeroDeCDs(), 0);
        cdTeca1.adicionaCD(cd1);
        Assert.assertEquals(cdTeca1.numeroDeCDs(), 1);
        cdTeca1.adicionaCD(cd1);
        cdTeca1.adicionaCD(cd1);
        cdTeca1.adicionaCD(cd2);
        cdTeca1.adicionaCD(cd2);
        cdTeca1.adicionaCD(cd2);
        cdTeca1.adicionaCD(cd3);
        cdTeca1.adicionaCD(cd4);
        cdTeca1.adicionaCD(cd1);
        cdTeca1.adicionaCD(cd4);
        Assert.assertEquals(cdTeca1.numeroDeCDs(), 10);
        cdTeca1.removeCD("titulo1");
        Assert.assertEquals(cdTeca1.numeroDeCDs(), 9);
        cdTeca1.removeCDs(cdTeca1.getCDs());
        Assert.assertEquals(cdTeca1.numeroDeCDs(), 0);        
    }
    
    @Test
    public void testeEquals() throws Exception{
        cdTeca1.adicionaCD(cd1);
        cdTeca1.adicionaCD(cd1);
        Assert.assertNotEquals(cdTeca1, cdTeca2);
        cdTeca2.adicionaCD(cd1);
        Assert.assertNotEquals(cdTeca1, cdTeca2);
        cdTeca2.adicionaCD(cd1);
        Assert.assertEquals(cdTeca1, cdTeca2);
        cdTeca2.adicionaCD(cd2);
        Assert.assertNotEquals(cdTeca1, cdTeca2);
        cdTeca1.adicionaCD(cd2);
        Assert.assertEquals(cdTeca1, cdTeca2);    
    }
    
    
}
