package Lab07;

/**
 * A classe Caminhoneiro representa uma classe específica de contribuinte. Um
 * Caminhoneiro é tributado pela quantidade anual de toneladas
 * transportadas.<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class Caminhoneiro extends Rodoviarios {

    private static int countCam = 0;        //  Contador de instâncias de caminhoneiros
    private static double patrCam = 0;      //  Somatório dos bens da categoria

    private double tons;
    private static final double TAXA = 100;
    private static final double TAXA_FIXA = 500;
    private static final double LIMITE = 10;

    /**
     * Instancia um caminhoneiro com nome.
     *
     * @param name nome do caminhoneiro.
     * @throws java.lang.Exception
     */
    public Caminhoneiro(String name) throws Exception{
        super(name);
        this.tons = 0;

        countCam++;
    }

    /**
     * Método que atualiza a quantidade de toneladas transportadas.
     *
     * @param tons toneladas transportadas.
     * @throws java.lang.Exception Se a quantidade de toneladas for menor ou igual a 0
     */
    public void insertTons(double tons) throws Exception{
        if (tons <= 0)
            throw new Exception("Quantidade de toneladas tem que ser maior que 0.");
        this.tons += tons;
    }

    /**
     * Método que calcula a tributação a ser paga pelo caminhoneiro através da
     * quantidade de toneladas transportadas, multiplicada pela devida taxa
     * tributária, subtraido do desconto anual.
     *
     * @return tributação a ser paga.
     */
    @Override
    protected double calcTribute() {
        double tribute = TAXA_FIXA;

        if (tons > LIMITE) {
            tribute += (tons - LIMITE) * TAXA;
        }

        return tribute;
    }

    /**
     * Método que atualiza o valor do patrimônio dos caminhoneiros.
     *
     * @param value valor a ser adicionado.
     */
    @Override
    protected void updateCatPatrimony(double value) {
        patrCam += value;
    }

    /**
     * Método que retorna o valor médio associado aos patrimônios dos
     * caminhoneiros.
     *
     * @return valor médio associado aos patrimônios dos caminhoneiros.
     */
    @Override
    protected double getMedPatrimony() {
        return patrCam / countCam;
    }

    /**
     * Método que para recuperar o número de toneladas transportadas.
     * 
     * @return toneladas transportadas.
     */
    public double getTons() {
        return this.tons;
    }
    
    /**
     * Método para retornar o número total de caminhoneiros contribuintes.
     *
     * @return total de caminhoneiros contribuintes.
     */
    public static int getCount(){
        return countCam;
    }

}
