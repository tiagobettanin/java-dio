import java.util.Scanner;

public class Contador1 {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();
                
        try {
            contar(parametroUm, parametroDois);
                
        }catch (ParametrosInvalidosException exception) {
            System.out.println(exception.getMessage());

        }finally{
            terminal.close();
        }    
        
    }

    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        if(parametroUm >= parametroDois){
            throw new ParametrosInvalidosException(); 
        }
                
        int contagem = parametroDois - parametroUm;
        for (int i = 0; i <= contagem; i++) {
            System.out.println(i);
        }
    }
}

class ParametrosInvalidosException extends Exception{
    public ParametrosInvalidosException(){
        super("O segundo parâmetro deve ser maior que o primeiro");
    }
    
}