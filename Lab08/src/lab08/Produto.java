package lab08;

import java.util.ArrayList;
import java.util.List;

/**
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 */
public class Produto {
    private String descricao;
    private double preco;
    private List<Comentario> comentarios;
    
    public Produto(String descricao, double preco) throws Exception{
        if (descricao == null || descricao.isEmpty())
            throw new Exception("Nome inválido.");
        
        if (preco < 0)
            throw new Exception("O preço não pode ser negativo.");
        
        this.descricao = descricao;
        this.preco = preco;
        this.comentarios = new ArrayList<>();
    }

    public void insertComentario(Comentario coment) throws Exception{
        if (coment == null)
            throw new Exception("Parâmentro inválido.");
        
        this.comentarios.add(0, coment);
    }
    
    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public double getNaMosca(Estrategia estrategia){
        return estrategia.notaNaMosca(comentarios);
    }

    public Comentario [] getRelevantComents(Estrategia estrategia){
        return estrategia.comentRelevant(comentarios);
    }
}
