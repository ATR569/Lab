package Lab07;

/**
 * A classe Professor representa uma classe específica de contribuinte. Um
 * Professor é tributado por faixa de salário, 5% caso ganhe até 1 salário
 * mínimo, 10% até 5 salários e 20% acima de 5 salários minímos. Além disso,
 * seus descontos são calculados através de gastos com material didático(50% das
 * despesas totais é usada como descontos).<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class Professor extends Contribuinte {

    private static final double SAL_MINIMO = 954;   //  Valor base de salário mínimo

    private static final double TAXA_1 = 0.05;
    private static final double TAXA_2 = 0.1;
    private static final double TAXA_3 = 0.2;
    private static final double TAXA_DESC = 0.5;

    private static int countPrf = 0;        //  Contador de instâncias de professores
    private static double patrPrf = 0;      //  Somatório dos bens da categoria

    private double salario;
    private double despMaterial;

    /**
     * Recupera o salário do professor
     * 
     * @return salário do professor
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Retorna o total de despesas com material didático
     * 
     * @return despesas com material
     */
    public double getDespMaterial() {
        return despMaterial;
    }
    
    /**
     * Instancia um Professor com nome e salário.
     *
     * @param name Nome do professor.
     * @param salario Salário do professor.
     * @throws java.lang.Exception
     */
    public Professor(String name, double salario) throws Exception {
        super(name);

        if (salario <= 0)
            throw new Exception("O salário tem que ser maior que 0.");

        this.salario = salario;
        this.despMaterial = 0;

        countPrf++;
    }

    /**
     * Método que atualiza as despesas gastas com material didático.
     *
     * @param value valor da despesa.
     */
    public void addDespMaterial(double value) {
        this.despMaterial += value;
    }

    /**
     * Método que calcula a tributação do professor através da porcentagem
     * específica por faixa salarial e subtraído 50% das despesas totais gastas
     * com material didático.
     *
     * @return tributação a ser paga.
     */
    @Override
    protected double calcTribute() {
        if (this.salario <= SAL_MINIMO) {
            return this.salario * TAXA_1;
        } else if (this.salario <= 5 * SAL_MINIMO) {
            return this.salario * TAXA_2;
        } else {
            return this.salario * TAXA_3;
        }
    }

    /**
     * Método que retorna o valor do desconto anual.
     *
     * @return valor do desconto anual.
     */
    @Override
    public double getDescontoAnual() {
        return this.despMaterial * TAXA_DESC;
    }

    /**
     * Método que atualiza o valor do patrimônio dos professores.
     *
     *
     * @param value valor a ser adicionado.
     */
    @Override
    protected void updateCatPatrimony(double value) {
        patrPrf += value;
    }

    /**
     * Método que retorna o valor médio associado aos patrimônios dos
     * professores.
     *
     * @return valor médio associado aos patrimônios dos professores.
     */
    @Override
    protected double getMedPatrimony() {
        return patrPrf / countPrf;
    }

    /**
     * Método para retornar o número total de professores contribuintes.
     *
     * @return total de professores contribuintes.
     */
    public static int getCount() {
        return countPrf;
    }

}
