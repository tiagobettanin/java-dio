public interface AparelhoTelefonico {
    public void fazerLigacao(String numero);

    public void receberLigacao();

    public void enviarMensagem(String texto, String numero);

    public void receberMensagem(String texto, String numero);
}
