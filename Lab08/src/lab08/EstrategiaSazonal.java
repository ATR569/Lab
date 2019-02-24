/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab08;

import java.util.List;

/**
 *
 * @author Adson Macêdo
 */
public class EstrategiaSazonal implements Estrategia {

    @Override
    public double notaNaMosca(List<Comentario> lista) {
        if (lista.isEmpty())
            return 0;

        int cont = 0;
        double media = 0;
        
        for (Comentario coment : lista) {
            media += coment.getNota();
            cont++;
            
            if (cont > 2) break;
        }
        
        return media / cont;
    }

    @Override
    public Comentario [] comentRelevant(List<Comentario> lista) {
        if (lista.isEmpty())
            return null;
        
        if (lista.size() == 1)
            return new Comentario []{lista.get(0)};
        
        Comentario [] aux = new Comentario[2];
        
        aux[0] = lista.get(0);
        aux[1] = lista.get(1);
        
        return aux;
    }
    
}
