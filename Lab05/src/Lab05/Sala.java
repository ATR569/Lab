package Lab05;


import java.util.Arrays;

/** A classe Sala cria um espaço representado por uma matriz, onde é possível realizar a inserção de obstaculos.<br>
 *  Além de inserir um robo na mesma seguindo alguns críterios.<br><br>
 * 
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 */
public class Sala {
    private boolean space[][];
    public static final boolean LIVRE = false;
    public static final boolean OCUPADO = true;
    
    /** Cria a sala
     * 
     * 
     * @param width Linha
     * @param length Coluna
     * @throws Exception Caso os parâmetros sejam valores negativos
     */
    public Sala(int width, int length) throws Exception{
        if (width <= 0 || length <= 0)
            throw new Exception("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
        
        this.space = new boolean[length][width];
    }
    
    /** Retorna a quantidade de linhas.
     * 
     * @return Quantidade de linhas
     */
    public int getNumPosicoesHorizontais(){
        return this.space[0].length;
    }

    /** Retorna a quantidade de colunas.
     * 
     * @return Quantidade de colunas
     */
    public int getNumPosicoesVerticais(){
        return this.space.length;
    }
    
    /** Verifica se a posiçao está livre.
     * 
     * @param i Linha
     * @param j Coluna
     * @return Verdadeiro se a posição está livre.
     * @throws Exception Caso a posição seja inválida.
     */
    public boolean isPosicaoLivre(int i, int j) throws Exception{
        if (!posicaoValida(i, j))
            throw new Exception("Posicao inexistente.");
        
        return space[i][j] == LIVRE;
    }

    /** Realiza a comparação de duas Salas
     * 
     * @return Verdadeiro se as salas tiverem as mesmas dimensões a posição da sala está ocupada se e somente se também está ocupada na outra sala.
     */
    @Override
    public boolean equals(Object other) {
        Sala otherSala = (Sala) other;
        
        if (this.space.length != otherSala.space.length) 
            return false;
        
        if (this.space[0].length != otherSala.space[0].length) 
            return false;

        return Arrays.deepEquals(this.space, otherSala.space);
    }

    /** Insere um obstaculo na sala.
     * 
     * @param i Linha
     * @param j Coluna
     * @return Posição com estado ocupado.
     */
    public boolean inserirObstaculo(int i, int j) {
        return setPosicao(i, j, OCUPADO);
    }

    /** Seta o estado de uma posição da sala.
     * 
     * @param i Linha
     * @param j Coluna
     * @param state Livre ou Ocupado
     * @return Estado da posição.
     */
    public boolean setPosicao(int i, int j, boolean state) {
        if (!posicaoValida(i, j))
            return false;
        
        this.space[i][j] = state;
        return true;
    }

    /** Verifica se a posição é válida.
     * 
     * @param i Linha
     * @param j Coluna
     * @return Verdadeiro se a posição está contida na sala.
     */
    public boolean posicaoValida(int i, int j) {
        return (i >= 0 && i < space.length && j >= 0 && j < space[0].length);
    }
    
    // Método auxiliar para verificar se todas as posições da sala possuem o mesmo estado.
    private boolean checkAllPositions(boolean state){
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[0].length; j++) {
                if (this.space[i][j] != state) 
                    return false;
            }
        }
        
        return true;
    }
    
    /** Verifica caso exista o próximo espaço livre.
     * 
     * @return Array representando as coordenadas x e y do próximo espaço livre.
     */
    public int[] nextEmpty(){
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[0].length; j++) {
                if (this.space[i][j] == LIVRE) {
                    this.space[i][j] = OCUPADO;
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[]{space[0].length, space.length};
    }

    /** Verifica se a sala está vazia
     * 
     * @return Verdadeiro se a sala estiver vazia.
     */
    public boolean isVazia() {
        return checkAllPositions(LIVRE);
    }
    
    /** Verifica se a sala está cheia.
     * 
     * @return Verdadeiro se a sala estiver cheia.
     */
    public boolean isFull() {
        return checkAllPositions(OCUPADO);
    }
    
}
