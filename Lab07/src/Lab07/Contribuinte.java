package Lab07;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Contribuinte representa um contribuinte de um sistema de tributação.
 * Um contribuinte pode ter bens próprios, como carro(s) e/ou casa(s). Estes
 * serão definidos como sendo patrimônios do contribuinte e serão utilizados
 * para verificação de sinais externos de riqueza.<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public abstract class Contribuinte {
    private static int id = 1;
    private static final double LIMIAR = 1.5;   //  Limiar de riqueza

    private String name;
    private int number;
    private List<Double> cars;
    private List<Double> houses;

    /**
     * Instancia um contribuinte com nome.
     *
     * @param name nome do contribuinte.
     * @throws java.lang.Exception Se o nome for uma string vazia
     */
    public Contribuinte(String name) throws Exception{
        if (name.equals(""))
            throw new Exception("O nome não pode ser uma string vazia.");
        
        this.name = name;
        this.number = id++;
        this.cars = new ArrayList<>();
        this.houses = new ArrayList<>();
    }

    /**
     * Método que recupera o nome do contribuinte.
     *
     * @return nome do contribuinte.
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna o número identificador do contribuinte.
     *
     * @return número identificador do contribuinte.
     */
    public int getNumber() {
        return number;
    }

    //Método auxiliar que retorna o somatório dos bens do contribuinte.
    private double getTotal(List<Double> lst) {
        double total = 0;

        for (Double itn : lst) {
            total += itn;
        }

        return total;
    }

    /**
     * Método que retorna o valor associado a(s) casa(s) que o contribuinte
     * possui.
     *
     * @return valor associado a(s) casa(s).
     */
    public double getHousesValues() {
        return getTotal(houses);
    }

    /**
     * Método que retorna o valor associado ao(s) carro(s) que o contribuinte
     * possui.
     *
     * @return valor associado ao(s) carro(s).
     */
    public double getCarsValues() {
        return getTotal(cars);
    }

    /**
     * Método que recupera o valor total do patrimônio( casa(s) e/ou carro(s) )
     * do contribuinte.
     *
     * @return valor total do patrimônio.
     */
    public double getPatrimony() {
        return getHousesValues() + getCarsValues();
    }

    /**
     * Método que declara uma casa como patrimônio do contribuinte.
     *
     * @param value valor associado a casa.
     * @throws java.lang.Exception Se o valor for menor ou iguala zero
     */
    public void insertHouse(double value) throws Exception{
        if (value <= 0)
            throw new Exception("Valor tem que ser maior que 0.");
        
        this.houses.add(value);

        updateCatPatrimony(value);  //  Atualiza o somatório de patrimônio da categoria
    }

    /**
     * Método que declara um carro como patrimônio do contribuinte.
     *
     * @param value valor associado ao carro.
     * @throws java.lang.Exception Se o valor for menor ou iguala zero
     */
    public void insertCar(double value) throws Exception{
        if (value <= 0)
            throw new Exception("Valor tem que ser maior que 0.");

        this.cars.add(value);

        updateCatPatrimony(value);  //  Atualiza o somatório de patrimônio da categoria
    }

    /**
     * Verifica se o contribuinte tem sinais exteriores de riqueza
     *
     * @return true se o contribuite tem valor em bens acima do limiar de
     * riqueza da categoria
     */
    public boolean illicitEnrichment() {
        return getPatrimony() > LIMIAR * getMedPatrimony();
    }

    /**
     * Método que calcula e retorna a tributação a ser paga pelo contribuinte.
     *
     * @return valor a ser pago.
     */
    public double getTribute() {
        double tribute = calcTribute() - getDescontoAnual();

        return tribute < 0 ? 0 : tribute;
    }

    /**
     * Metodo auxiliar que calcula a tributação de cada contribuinte.
     *
     * @return tributação do contribuinte.
     */
    protected abstract double calcTribute();

    /**
     * Método auxiliar que retorna o desconto anual de cada contribuinte.
     *
     * @return desconto anual do contribuinte.
     */
    public abstract double getDescontoAnual();

    /**
     * Método que atualiza o valor do patrimônio de uma determinada categoria de
     * contribuinte.
     *
     *
     * @param value valor a ser adicionado.
     */
    protected abstract void updateCatPatrimony(double value);

    /**
     * Método que retorna o valor médio associado aos patrimônios de uma classe
     * de contribuintes.
     *
     * @return valor médio associado aos patrimônios da categoria.
     */
    protected abstract double getMedPatrimony();

}
