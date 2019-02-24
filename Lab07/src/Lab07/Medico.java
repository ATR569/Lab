package Lab07;

/**
 * A classe Medico representa uma classe específica de contribuinte. Um Médico é
 * tributado pela quantidade anual de pacientes atendidos. Além disso, seus
 * descontos são calculados através das despesas em congressos.<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class Medico extends Contribuinte {

    private static int countMed = 0;        //  Contador de instâncias de médicos
    private static double patrMed = 0;      //  Somatório dos bens da categoria

    private int patients;
    private double congress;
    private static final double TAXA_TRIBUTO = 10;

    /**
     * Instancia um médico com nome.
     *
     * @param name nome do médico.
     * @throws java.lang.Exception
     */
    public Medico(String name) throws Exception {
        super(name);
        this.patients = 0;
        this.congress = 0;

        countMed++;
    }

    /**
     * Método que atualiza as despesas gastas em congressos.
     *
     * @param value valor da despesa.
     * @throws java.lang.Exception Se a quantidade de congressos for menor ou igual a 0
     */
    public void insertCongress(double value) throws Exception {
        if (value <= 0)
            throw new Exception("Quantidade de congressos tem que ser maior que 0.");        
        this.congress += value;
    }

    /**
     * Método que atualiza a quantidade de pacientes atendidos.
     *
     * @param patients número de pacientes.
     * @throws java.lang.Exception Se a quantidade de pacientes for menor ou igual a 0
     */
    public void insertPatient(int patients) throws Exception {
        if (patients <= 0)
            throw new Exception("Quantidade de pacientes tem que ser maior que 0.");        
        
        this.patients += patients;
    }

    /**
     * Método que calcula a tributação do médico através do número de pacientes
     * atendidos multiplicado pela taxa tributária e subtraído as despesas
     * gastas em congressos.
     *
     * @return tributação a ser paga.
     */
    @Override
    protected double calcTribute() {
        double tribute = this.patients * TAXA_TRIBUTO;

        return tribute;
    }

    /**
     * Método que retorna o valor do desconto anual.
     *
     * @return valor do desconto anual.
     */
    @Override
    public double getDescontoAnual() {
        return this.congress;
    }

    /**
     * Método que atualiza o valor do patrimônio dos medicos.
     *
     *
     * @param value valor a ser adicionado.
     */
    @Override
    protected void updateCatPatrimony(double value) {
        patrMed += value;
    }

    /**
     * Método que retorna o valor médio associado aos patrimônios dos
     * medicos.
     *
     * @return valor médio associado aos patrimônios dos medicos.
     */
    @Override
    protected double getMedPatrimony() {
        return patrMed / countMed;
    }

    /**
     * Recupera o número de pacientes atendidos
     * 
     * @return pacientes atendidos
     */
    public int getPatients() {
        return patients;
    }

    /**
     * Retorna o valor gasto com congressos
     * 
     * @return valor gasto em congressos
     */
    public double getCongress() {
        return congress;
    }

    /**
     * Método para retornar o número total de médicos contribuintes.
     *
     * @return total de médicos contribuintes.
     */
    public static int getCount() {
        return countMed;
    }
}
