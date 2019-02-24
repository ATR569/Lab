package lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A classe CD representa um cd de músicas.<br>
 * Um cd deve conter ao menos um artista e título, além disso possui uma trilha
 * principal e um conjunto de faixas.<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class CD {

    private String artista;
    private String titulo;
    private String trilhaPrincipal;
    private int totalFaixas;
    private List<String> faixas;
    private static final String STRING_VAZIA = "";

    /**
     * Instancia um CD com titulo e artista.
     *
     * @param titulo título do CD.
     * @param artista compositor do CD.
     */
    public CD(String titulo, String artista) throws Exception {

        if (titulo == null || titulo.equals(STRING_VAZIA)) {
            throw new Exception("Parametros incorretos para a criacao do CD. O titulo não pode ser nulo.");
        }

        if (artista == null || artista.equals(STRING_VAZIA)) {
            throw new Exception("Parametros incorretos para a criacao do CD. O artista não pode ser nulo.");
        }

        this.titulo = titulo;
        this.artista = artista;
        this.totalFaixas = 10;
        faixas = new ArrayList<>(totalFaixas);
    }

    /**
     * Instancia um CD com titulo, artista e quantidade de faixas.
     *
     * @param titulo Título do CD.
     * @param artista Compositor do CD.
     * @param quantidade Quantidade de faixas do CD.
     */
    public CD(String titulo, String artista, int quantidade) throws Exception {
        this(titulo, artista);

        if (quantidade <= 0) {
            throw new Exception("Parametros incorretos para a criacao do CD. O número de faixas tem que ser maior que zero.");
        }

        this.totalFaixas = quantidade;
        faixas = new ArrayList<>(quantidade);
    }

    /**Método para retornar o artista do cd
     *
     * @return Artista compositor do CD.
     */
    public String getArtista() {
        return artista;
    }

    /**Método para retornar o título do cd
     *
     * @return Titulo do CD.
     */
    public String getTitulo() {
        return titulo;
    }

    /**Método para recuperar a faixa principal do cd
     *
     * @return Trilha Principal do CD.
     */
    public String getTrilhaPrincipal() {
        return trilhaPrincipal;
    }

    /**
     * Define a trilha principal do CD.
     *
     * @param novaTrilhaPrincipal trilha principal passada como parâmetro.
     * @throws Exception Caso a faixa passada como parâmetro não esteja no CD.
     */
    public void setTrilhaPrincipal(String novaTrilhaPrincipal) throws Exception {
        if (!faixas.contains(novaTrilhaPrincipal)) {
            throw new Exception("Impossível, a faixa não se encontra no CD.");
        }
        this.trilhaPrincipal = novaTrilhaPrincipal;
    }

    /**Método para retornar a quantidade de faixas do cd
     *
     * @return Total de faixas do CD.
     */
    public int getQuantidadeFaixas() {
        return totalFaixas;
    }

    /**
     * Busca uma faixa por sua posição.
     *
     * @param posFaixa Posição da faixa no CD.
     * @return Faixa.
     */
    public String getFaixa(int posFaixa) {
        if (posFaixa >= totalFaixas) {
            return null;
        }

        return faixas.get(posFaixa - 1);
    }

    /**
     * Tenta inserir uma faixa no CD.
     *
     * @param nome Nome da faixa.
     * @return Verdadeiro se conseguir inserir a faixa no CD, e Falso caso contrário.
     */
    public boolean insertFaixa(String nome) {
        if (faixas.size() < totalFaixas) {
            faixas.add(nome);
            return true;
        }
        
        return false;
    }

    @Override
    public String toString() {
        String cd = "Título do CD : " + this.titulo + "\n" + "Artista : " + this.artista + "\n" + "Faixa Principal: " + this.trilhaPrincipal + "\n";

        cd += "Faixas:";

        for (int i = 0; i < faixas.size(); i++) {
            cd += (i + 1) + ": " + faixas.get(i) + "\n";
        }

        return cd;
    }

    /**
     * Método para verificar se um CD é igual a um outro.
     * 
     * @param obj Um outro CD a ser comparado.
     * @return Verdareiro se ambos os CDs possuem o mesmo título e o mesmo artitsta, e falso caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CD other = (CD) obj;
        if (!Objects.equals(this.artista, other.artista)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }
}
