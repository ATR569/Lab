package lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe MinhaCDteca representa uma lista de cds.<br>
 * A lista contém vários métodos para manipulação da mesma dentre eles, adição,
 * remoção, pesquisa e quantidade de CDs na lista.<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class MinhaCDteca {

    // Coleção de CDs
    private List<CD> CDs = new ArrayList<>();
    
    public List<CD> getCDs(){
        return this.CDs;
    }

    /**
     * Adiciona um CD a lista.
     * 
     * @param cd CD a ser adicionado na lista.
     * @throws Exception Caso o CD recebido como pârametro seja nulo.
     */
    public void adicionaCD(CD cd) throws Exception {
        if (cd == null) {
            throw new Exception("Não é possível adicionar um cd nulo na CDteca.");
        }

        CDs.add(cd);
    }

    /**
     * Adiciona vários CDs na lista.
     * 
     * @param listaCds Lista de CDs a serem adiconados na lista.
     * @throws Exception Caso a lista de CDs seja vazia ou caso não exista nenhum CD na lista.
     */
    public void adicionaCDs(List<CD> listaCds) throws Exception {
        if (listaCds == null) {
            throw new Exception("A lista de cds a serem adicionados não pode ser nula.");
        }

        if (listaCds.isEmpty()) {
            throw new Exception("A lista de cds deve conter ao menos um cd.");
        }

        for (CD aux : listaCds) {
            adicionaCD(aux);
        }
    }

    /**
     * Remove um CD da lista.
     * 
     * @param titulo Titulo do CD a ser removido da lista.
     * @return O CD que foi removido ou null caso o CD não esteja na lista.
     */
    public CD removeCD(String titulo) {
        CD aux = pesquisaCD(titulo);

        if (aux != null) {
            CDs.remove(aux);
            return aux;
        }

        return null;
    }

    /**
     * Remove vários CDs da lista.
     * 
     * @param listaCds Lista de CDs a serem removidos da lista.
     * @return True se algum CD for removido ou false caso nenhum CD seja
     * removido.
     */
    public boolean removeCDs(List<CD> listaCds) {
        boolean result = false;
        
        if (listaCds.equals(this.CDs)){
            this.CDs.clear();
            return true;
        }    

        for (CD aux : listaCds) {
            if (this.CDs.contains(aux)) {
                result = true;
                this.CDs.remove(aux);
            }
        }

        return result;
    }

    /**
     * Verifica se dado CD está na lista.
     * 
     * @param titulo Titulo do CD que deseja verificar se está na lista.
     * @return O CD que foi buscado ou null caso o mesmo não esteja na lista.
     */
    public CD pesquisaCD(String titulo) {
        for (CD aux : this.CDs) {
            if (aux.getTitulo().equals(titulo)) {
                return aux;
            }
        }

        return null;
    }

    /**
     * Recupera a quantidade de CDs da lista.
     * 
     * @return Número de CDs da lista.
     */
    public int numeroDeCDs() {
        return CDs.size();
    }

    /**
     * Mostra os CDs presente na lista.
     * 
     * @return Artista, Título.
     */
    @Override
    public String toString() {
        String result = "";

        for (CD aux : this.CDs) {
            result += "Título: " + aux.getTitulo() + " - Artista: " + aux.getArtista() + "\n";
        }

        return result;
    }

    /**
     * Compara duas lista de CDs e verifica se as mesma são iguais
     * 
     * @param obj Um objeto do tipo MinhaCDteca para ser comparado.
     * @return True caso todo elemento da lista recebida como parâmetro seja
     * igual aos elementos da lista principal, false caso contrário.
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

        final MinhaCDteca other = (MinhaCDteca) obj;
        
        if (this.numeroDeCDs() != other.numeroDeCDs())
            return false;

        //  verifico se todos os cds de other estão em this
        for (CD aux : other.CDs) {
            if (!this.CDs.contains(aux)) {
                return false;
            }
        }

        //  verifico se todos os cds de this estão em other
        for (CD aux : this.CDs) {
            if (!other.CDs.contains(aux)) {
                return false;
            }
        }

        return true;
    }

}
