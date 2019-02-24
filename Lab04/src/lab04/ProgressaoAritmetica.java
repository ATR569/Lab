package lab04;

/**
 * A classe ProgressaoAritmetica gera números de uma PA dados um termo inicial e uma razão.<br><br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class ProgressaoAritmetica {

    private int a1;
    private int razao;
    private int posicao;

    /**
     * Cria a pa a partir do termo inicial a1 e uma razão.
     *
     * @param a1 Primeiro Termo
     * @param razao Razão de crescimento da pa
     *
     */
    public ProgressaoAritmetica(int a1, int razao) {
        this.a1 = a1;
        this.razao = razao;
        this.posicao = 1;
    }

    /**
     * Calcula o primeiro termo da pa.
     *
     * @return primeiro termo
     */
    public int primeiro() {
        this.posicao = 2;
        return a1;
    }

    /**
     * Calcula o próximo termo da pa.
     *
     * @return Próximo termo
     */
    public int proximo() {
        return a1 + (posicao++ - 1) * razao;
    }

    /**
     * Calcula o iésimo termo da pa.
     *
     * @param i Termo buscado
     * @return iésimo termo da pa
     * @throws Exception Se o termo for inválido
     */
    public int termo(int i) throws Exception {
        if (i <= 0) {
            throw new Exception("O termo tem que ser positivo!");
        }

        this.posicao = i;
        return proximo();
    }

    /**
     * Calcula os n primeiros termos da pa.
     *
     * @param n Número de elementos a serem gerados
     * @return String com os n primeiros elementos da sequência
     * @throws Exception se o número de termos for menor ou igual a 0
     */
    public String geraTermos(int n) throws Exception{
        if (n <= 0) throw new Exception ("Quantidade inválida!");
        String termos = "[";

        termos += primeiro();
        for (int i = 1; i < n; i++) {
            termos += ", " + proximo();
        }

        return termos + "]";
    }
}
