package lab04;

/**
 * A classe Fibonacci gera números da sequência de Fibonacci.<br> <br>
 *
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class Fibonacci {

    private int next;
    private long [] fibonacci;

    /**
     * Cria a sequência de Fibonacci
     */
    public Fibonacci() {
        this.next = 0;
        this.fibonacci = new long [100];
        this.fibonacci[0] = 0;
        this.fibonacci[1] = 1;
        
        for (int i = 2; i < 100; i++) {
            fibonacci[i] = -1;
        }
    }

    // Calcula o i-ésimo termo da sequência de Fibonacci 
    private long fib(int i) {
        if (fibonacci[i] >= 0) {
            return fibonacci[i];
        }
        
        fibonacci[i] = fib(i - 1) + fib(i - 2);
        
        return fibonacci[i];
    }

    /**
     * Calcula o primeiro elemento da sequência de Fibonacci
     *
     * @return Primeiro elemento da sequência de Fibonacci
     */
    public long primeiro() {
        this.next = 0;
        return proximo();
    }

    /**
     * Gera o próximo da sequência
     *
     * @return Próximo elemento da sequência
     */
    public long proximo() {
        return fib(next++);
    }

    /**
     * Gera o i-ésimo elemento da sequência
     *
     * @param i Elemento buscado
     * @return iésimo elemento da sequência
     * @throws Exception Se o termo for inválido
     */
    public long termo(int i) throws Exception {
        if (i <= 0) {
            throw new Exception("O termo tem que ser positivo!");
        }

        this.next = i - 1;

        return proximo();
    }

    /**
     * Gera os n termos da sequência
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
