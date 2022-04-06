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
        this.AquarioLombriga = null;
    }
    //--------------------------------------------------------------------------------
    void conecta(AquarioLombriga aquarioLombriga) {
        this.aquarioLombriga = aquarioLombriga;
    }
    //--------------------------------------------------------------------------------
    void passo() {
        if (this.comandosAnimacao.length > 0) {
            switch(comandosAnimacao[0]) {
                case 'C':
                    this.aquarioLombriga.crescer();
                    break;
                case 'M':
                    this.aquarioLombriga.mover();
                    break;
                case 'V':
                    this.aquarioLombriga.virar();
                    break;
            }
            this.comandosAnimacao = this.comandosAnimacao.substring(1);
        }
    }

}