package lab03.src.pt.c02oo.s02classe.s03lombriga;

public class Animacao {

    int tamanhoAquario;
    int tamanhoLombriga;
    int posicaoCabecaLombriga;
    String comandosAnimacao;
    AquarioLombriga aquarioLombriga;
    
    //--------------------------------------------------------------------------------
    
    Animacao(String stringAnimacao) {
        this.tamanhoAquario = Integer.parseInt(stringAnimacao.substring(0, 2));
        this.tamanhoLombriga = Integer.parseInt(stringAnimacao.substring(2, 4));
        this.posicaoCabecaLombriga = Integer.parseInt(stringAnimacao.substring(4, 6));
        this.comandosAnimacao = stringAnimacao.substring(6);
        this.aquarioLombriga = new AquarioLombriga(this.tamanhoAquario, this.tamanhoLombriga, this.posicaoCabecaLombriga);
    }
    
    //--------------------------------------------------------------------------------
    
    public void passo() {
        if (this.comandosAnimacao.length() > 0) {
            char primeiroCaractere = comandosAnimacao.charAt(0);
            if (primeiroCaractere == 'C') {
                this.aquarioLombriga.crescer();
            } else if (primeiroCaractere == 'M') {
                this.aquarioLombriga.mover();
            } else if (primeiroCaractere == 'V') {
                this.aquarioLombriga.virar();
            }
            this.comandosAnimacao = this.comandosAnimacao.substring(1);
        }
    }

    public String apresenta() {
        return this.aquarioLombriga.apresentar();
    }

}