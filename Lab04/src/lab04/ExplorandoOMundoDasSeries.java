package lab04;

import java.util.Scanner;

/**
 * Classe para manipular series matematicas (Usando uma classe
 * ProgressaoAritmetica e Fibonacci).
 *
 */
public class ExplorandoOMundoDasSeries {

    static private Fibonacci fb;
    static private ProgressaoAritmetica pa;

    public static void main(String[] args) throws Exception {
        int op;
        Scanner sc = new Scanner(System.in);
        
        do{
            op = getMenuOption();
            
            switch (op){
                case 1:
                    System.out.print("Digite o primeiro termo da PA: ");
                    int a1 = sc.nextInt();
                    System.out.print("Digite a razão da PA: ");
                    int razao = sc.nextInt();
                    
                    pa = new ProgressaoAritmetica(a1, razao);
                    System.out.println("Progressão Aritmética criada com sucesso!");
                    
                    break;
                case 2: 
                    fb = new Fibonacci();
                    System.out.println("Sequência de Fibonacci criada com sucesso!");
                    
                    break;
                case 3:
                    if (pa == null){
                        System.out.println("Você precisa criar uma PA primeiro!");
                    } else{
                        System.out.print("Digite o termo buscado: ");
                        int i = sc.nextInt();

                        System.out.println("Termo " + i + " da PA = " + pa.termo(i));
                    }
                    
                    break;
                case 4: 
                    if (fb == null){
                        System.out.println("Você precisa criar uma sequência de Fibonacci primeiro!");
                    } else{
                        System.out.print("Digite o elemento buscado: ");
                        int j = sc.nextInt();

                        System.out.println("Elemento " + j + " de Fibonacci = " + fb.termo(j));
                    }
                    break;
                case 5: 
                    if (fb == null || pa == null){
                        System.out.println("Você precisa criar uma pa e sequência de Fibonacci primeiro!");
                    } else{
                        System.out.print("Digite o número de termos a mostrar: ");
                        int n = sc.nextInt();

                        System.out.println(n + " primeiros termos da PA");
                        System.out.println(pa.geraTermos(n));
                        System.out.println("\n" + n + " primeiros elementos de Fibonacci");
                        System.out.println(fb.geraTermos(n));
                    }
                    
                    break;
            }
            System.out.println("");
            
        } while (op != 6);
        
    }
    /**
     * Lê a opção do menu
     * 
     * @return opção do menu
     */
    public static int getMenuOption(){
        Scanner sc = new Scanner(System.in);
        
        int op;
        
        do{
            System.out.println("==================MENU==================");
            System.out.println("(1) Criar Progressão Aritmética");
            System.out.println("(2) Criar sequência de Fibonacci");
            System.out.println("(3) Mostrar um termo da PA");
            System.out.println("(4) Mostrar um termo de Fibonacci");
            System.out.println("(5) Mostrar termos da PA e de Fibonacci");
            System.out.println("(6) Sair");
            
            System.out.print("\nDigite a opção: ");
            op = sc.nextInt();
        } while (op < 1 || op > 6);
        
        return op;
    }  

}
