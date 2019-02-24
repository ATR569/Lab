package Lab05;


import java.util.Arrays;


/**
 * A classe robô simula um robô que se movimenta em 4 direções em uma determinada sala.<br>
 * Um robô pode ser posicionado em qualquer espaço livre da sala. Para movimentar-se, o robô precisa ter energia, que é gasta 
 * cada vez que o robô se movimenta.<br><br>
 * 
 * Aluno 1 Adson Macêdo<br>
 * Aluno 2 Ramon Rodrigues<br>
 * Aluno 3 Thairam Michel<br>
 *
 */
public class Robo {

    private final int X = 0;
    private final int Y = 1;
    private final int DIR_UP = 0;
    private final int DIR_RIGHT = 1;
    private final int DIR_DOWN = 2;
    private final int DIR_LEFT = 3;

    private Sala sala;
    private int[] pos; //  Vetor com as duas coordenadas (x,y) do robô
    private int power;
    private int steps;

    /**
     * Instacia um robô em uma sala e com um nível de energia inicial
     * 
     * @param sala Sala onde se encontra o robô.
     * @param power Nível de energia inicial do robô.
     * @throws Exception Se tentar criar um robô com nível de energia menor ou igual a zero, ou se a sala for nula ou cheia.
     */
    public Robo(Sala sala, int power) throws Exception {
        if (sala == null) {
            throw new Exception("Parametros incorretos para a criacao do Robo. A Sala não pode ser inválida.");
        }

        if (sala.isFull()) {
            throw new Exception("Parametros incorretos para a criacao do Robo. A sala se encontra totalmente ocupada.");
        }

        if (power <= 0) {
            throw new Exception("Parametros incorretos para a criacao do Robo. A energia deve ser representada por um valor maior que zero.");
        }

        this.sala = sala;

        this.pos = sala.nextEmpty();

        this.steps = 0;
        this.power = power;
    }

    //  Método auxiliar para checar se a nova posição do robô é válida
    private boolean checkPosition(int x, int y){
        if (!sala.posicaoValida(x, y)) 
            return false;
        
        try {
            if (!sala.isPosicaoLivre(x, y)) 
                return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return true;
    }
    
    //  Método auxiliar para movimentar o robô de forma mais genérica
    private boolean move(int direction) {
        if (power == 0) return false;
        
        this.power--;
        this.steps++;

        //  Libero a antiga posição do robô
        this.sala.setPosicao(pos[X], pos[Y], Sala.LIVRE);

        switch (direction) {
            case DIR_UP:
                this.pos[X]--;
                break;
            case DIR_RIGHT:
                this.pos[Y]++;
                break;
            case DIR_DOWN:
                this.pos[X]++;
                break;
            case DIR_LEFT:
                this.pos[Y]--;
        }

        //  Ocupo a nova posição do robô
        this.sala.setPosicao(pos[X], pos[Y], Sala.OCUPADO);
        
        return true;
    }

    /**
     * Tenta movimentar o robô para a esquerda.
     * 
     * @return Verdadeiro se o robô conseguir se movimentar para a esquerda com sucesso.
     */
    public boolean moveLeft() {
        if (!checkPosition(pos[X], pos[Y] - 1))
            return false;
            
        return move(DIR_LEFT);
    }

    /**
     * Tenta movimentar o robô para a direita.
     *
     * @return Verdadeiro se o robô conseguir se movimentar para a direita com sucesso.
     */
    public boolean moveRight() {
        if (!checkPosition(pos[X], pos[Y] + 1))
            return false;

        return move(DIR_RIGHT);
    }

    /**
     * Tenta movimentar o robô para frente.
     *
     * @return Verdadeiro se o robô conseguir se movimentar para frente com sucesso.
     */
    public boolean moveFront() {
        if (!checkPosition(pos[X] - 1, pos[Y]))
            return false;

        return move(DIR_UP);
    }

    /**
     * Tenta movimentar o robô para trás.
     *
     * @return Verdadeiro se o robô conseguir se movimentar para trás com sucesso.
     */
    public boolean moveBack() {
        if (!checkPosition(pos[X] + 1, pos[Y]))
            return false;

        return move(DIR_DOWN);
    }

    /**
     * Método para obter a posição atual do robô.
     * 
     * @return Array com as coordenadas [x, y] do robô.
     */
    public int[] getPos() {
        return pos;
    }

    /**
     * Método para obter o nível de energia.
     * 
     * @return Nível de energia atual do robô.
     */
    public int getPower() {
        return power;
    }

    /**
     * Método para obter a contagem de passos dados pelo robô.
     * 
     * @return Número de passos dados pelo robô até o momento.
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Método para verificar se o robô é igual a um outro.
     * 
     * @param obj Um outro robô a ser comparado
     * @return Verdadeiro se o robô ocupa uma sala semelhante à sala do outro robô e se o mesmo ocupa coordenadas iguais em suas salas.
     */
    @Override
    public boolean equals(Object obj) {
        final Robo other = (Robo) obj;

        return (this.sala.equals(other.sala)) && (Arrays.equals(this.pos, other.pos));
    }

}
