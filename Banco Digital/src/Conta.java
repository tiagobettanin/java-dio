import java.util.Scanner;

public abstract class Conta implements iConta{
    Scanner sc = new Scanner(System.in);

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    private double saldo;
    protected Cliente cliente;
    private int senha;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        System.out.print("Informe a senha da sua conta: ");
        this.senha = sc.nextInt();

    }

    @Override
    public void sacar(double valor) {
        if( saldo < valor){
            System.out.println("Nao a saldo suficiente para efetuar a acao");
        }else{
            saldo -= valor;
        }
    }
    @Override
    public void depositar(double valor) {
        if( valor < 0){
            System.out.println("Nao eh possivel completar a acao");
        }else{
            saldo += valor;
        }
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    
    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titulas: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }


    
}
