package Lab07;

/**
 * A classe Rodoviarios represente uma classe específica de contribuintes, que
 * possuem coisas em comum tais como, quilometragem percorrida, taxa de
 * tributação. Além disso, seus descontos são calculados através da
 * quilometragem percorrida multiplicada pela taxa de desconto.<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public abstract class Rodoviarios extends Contribuinte {

    private double km;
    private static final double TAXA_DESCONTO = 0.01;

    /**
     * Instancia um Rodoviario com nome e número identificador e quilômetros
     * percorridos igual a zero.
     *
     * @param name nome do rodoviario.
     * @throws java.lang.Exception
     */
    public Rodoviarios(String name) throws Exception {
        super(name);
        this.km = 0;
    }

    /**
     * Método que atualiza a quantidade de quilômetros percorridos.
     *
     * @param km quilômetros percorridos.
     * @throws java.lang.Exception
     */
    public void addKm(double km) throws Exception{
        if (km <= 0)
            throw new Exception("O número de quilômetros tem que ser positivo.");
        
        this.km += km;
    }

    /**
     * Método que calcula e retorna o desconto anual, multiplicando os
     * quilômetros percorridos pela taxa de desconto.
     *
     * @return valor do desconto anual.
     */
    @Override
    public double getDescontoAnual() {
        return this.km * TAXA_DESCONTO;
    }

    /**
     * Método que retorna o número de quilômetros rodados
     * 
     * @return quilômetros rodados
     */
    public double getKm() {
        return km;
    }

}
