package Lab07;

/**
 * A classe Taxista representa uma classe específica de contribuinte. Um Taxista
 * é tributado pela quantidade anual de passageiros transportados multiplicado
 * pela taxa de tributação.<br><br>
 *
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class Taxista extends Rodoviarios {

    private static int countTax = 0;        //  Contador de instâncias de taxistas
    private static double patrTax = 0;      //  Somatório dos bens da categoria

    private int passengers;
    private static final double TAXA_TRIBUTO = 0.5;

    /**
     * Instancia um taxista com nome.
     *
     * @param name nome do taxista.
     * @throws java.lang.Exception
     */
    public Taxista(String name) throws Exception{
        super(name);
        this.passengers = 0;

        countTax++;
    }

    /**
     * Método que atualiza a quantidade de passageiros transportados.
     *
     *
     * @param passengers passageiros transportados.
     * @throws java.lang.Exception Se o número de passageiros for menor ou igual a zero.
     */
    public void insertPassengers(int passengers) throws Exception{
        if (passengers <= 0)
            throw new Exception("Quantidade de passageiros tem que ser maior que 0.");
        
        this.passengers += passengers;
    }
    
    /**
     * Método para recuperar o número de passageiros transportados.
     * 
     * @return Passageiros transportados.
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Método que calcula a tributação a ser paga pelo taxista através da
     * quantidade de passageiros transportados, multiplicada pela devida taxa
     * tributária, subtraido do desconto anual.
     *
     *
     * @return tributação a ser paga.
     */
    @Override
    protected double calcTribute() {
        double tribute = this.passengers * TAXA_TRIBUTO;

        return tribute;
    }

    /**
     * Método que atualiza o valor do patrimônio dos taxistas.
     *
     *
     * @param value valor a ser adicionado.
     */
    @Override
    protected void updateCatPatrimony(double value) {
        patrTax += value;
    }

    /**
     * Método que retorna o valor médio associado aos patrimônios dos taxistas.
     *
     * @return valor médio associado aos patrimônios dos taxistas.
     */
    @Override
    protected double getMedPatrimony() {
        return patrTax / countTax;
    }

    /**
     * Método para retornar o número total de taxistas contribuintes.
     *
     * @return total de taxistas contribuintes.
     */
    public static int getCount() {
        return countTax;
    }

}
