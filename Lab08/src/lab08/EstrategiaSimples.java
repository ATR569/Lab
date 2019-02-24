package lab08;

import java.util.List;

/**
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 */
public class EstrategiaSimples implements Estrategia{

    @Override
    public double notaNaMosca(List<Comentario> lista) {
        if (lista.isEmpty())
            return 0;

        double media = 0;

        for (Comentario coment : lista) {
            media += coment.getNota();
        }

        return media / lista.size();
    }

    @Override
    public Comentario [] comentRelevant(List<Comentario> lista) {
        Comentario [] aux = new Comentario[2];
        
        if (lista.isEmpty())
            return null;
        
        aux[0] = aux[1] = lista.get(0);
        
        for (Comentario coment : lista) {
            if (coment.getNota() < aux[0].getNota() || (coment.getNota() == aux[0].getNota() && coment.getData().before(aux[0].getData())))
                aux[0] = coment;

            if (coment.getNota() > aux[1].getNota() || (coment.getNota() == aux[1].getNota() && coment.getData().before(aux[1].getData())))
                aux[1] = coment;
        }
        
        return aux;
    }
    
}
