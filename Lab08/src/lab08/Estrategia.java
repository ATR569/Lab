package lab08;


import java.util.List;


/**
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 */
public interface Estrategia {
    public double notaNaMosca(List<Comentario> lista);
    public Comentario [] comentRelevant(List<Comentario> lista);
}