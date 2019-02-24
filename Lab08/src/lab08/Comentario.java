/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab08;

import java.util.Calendar;

/**
 *
 * @author Adson Macêdo
 */
public class Comentario {
    private final static int MAX_SIZE = 140;

    private String coment;
    private int nota;
    private Calendar data;

    public Comentario(String coment, int nota) throws Exception {
        if (coment == null)
            throw new Exception("O comentário não pode ser nulo.");

        if (coment.isEmpty() || coment.length() > MAX_SIZE)
            throw new Exception("O tamanho do comentário tem que estar entre 1 e 140 caracteres.");

        if (nota < -2 || nota > 2)
            throw new Exception("A nota tem que estar entre -2 e 2.");

        this.coment = coment;
        this.nota = nota;
        this.data = Calendar.getInstance();
    }

    public String getComent() {
        return coment;
    }

    public int getNota() {
        return nota;
    }

    public Calendar getData() {
        return data;
    }
    
    
}
