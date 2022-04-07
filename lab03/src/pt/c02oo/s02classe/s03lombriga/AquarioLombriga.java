package lab03.src.pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {

	int tamanhoMaximoAquario;
    int tamanhoMinimoAquario;
    int tamanhoAquario;
	int tamanhoCorpoLombriga;
	int posicaoCabecaLombriga;
	boolean cabecaLombrigaViradaParaEsquerda;
	
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
	
    AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoCabecaLombriga) {
        this.tamanhoMaximoAquario = 15;
        this.tamanhoMinimoAquario = 1;
        this.tamanhoAquario = this.validaERetornaTamanhoAquario(tamanhoAquario); 
		this.tamanhoCorpoLombriga = this.validaERetornaTamanhoCorpoLombriga(tamanhoLombriga);
		this.posicaoCabecaLombriga = this.validaERetornaPosicaoLombriga(posicaoCabecaLombriga);
		this.cabecaLombrigaViradaParaEsquerda = true;
	}
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public int validaERetornaTamanhoAquario(int tamanhoAquario) {
        if (tamanhoAquario < this.tamanhoMinimoAquario) {
            return this.tamanhoMinimoAquario;
        } else if (tamanhoAquario > this.tamanhoMaximoAquario) {
            return this.tamanhoMaximoAquario;
        }
        return tamanhoAquario;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public int validaERetornaTamanhoCorpoLombriga(int tamanhoLombriga){
        int tamanhoCorpoLombriga = (tamanhoLombriga < this.tamanhoAquario) ? tamanhoLombriga : this.tamanhoAquario;
        return tamanhoCorpoLombriga - 1; //não considerando a cabeça da lombriga na contagem do tamanho de seu corpo
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public int validaERetornaPosicaoLombriga(int posicaoCabecaLombriga) {
        return (posicaoCabecaLombriga >= 1 && posicaoCabecaLombriga <= this.tamanhoAquario) ? posicaoCabecaLombriga : 1;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean ehParteDoCorpoDaLombriga (int posicaoAquario) {
        if (this.cabecaLombrigaViradaParaEsquerda) {
            return posicaoAquario > this.posicaoCabecaLombriga && posicaoAquario <= (this.posicaoCabecaLombriga + this.tamanhoCorpoLombriga);
        } else {
            return posicaoAquario >= (this.posicaoCabecaLombriga - this.tamanhoCorpoLombriga) && posicaoAquario < this.posicaoCabecaLombriga;
        }
    }
	
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
	
    public void crescer() {
		if (this.cabecaLombrigaViradaParaEsquerda) {
            if ((this.posicaoCabecaLombriga + this.tamanhoCorpoLombriga) < this.tamanhoAquario) {
                this.tamanhoCorpoLombriga++;
            }
        }

		else if(this.posicaoCabecaLombriga - this.posicaoCabecaLombriga > 1)
            this.tamanhoCorpoLombriga++;
	}
	
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
	
    public void virar() {
        if (this.cabecaLombrigaViradaParaEsquerda)
            this.posicaoCabecaLombriga += this.tamanhoCorpoLombriga;
        else
            this.posicaoCabecaLombriga -= this.tamanhoCorpoLombriga;
        this.cabecaLombrigaViradaParaEsquerda = !this.cabecaLombrigaViradaParaEsquerda;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void mover() {
        boolean deveMover = this.cabecaLombrigaViradaParaEsquerda ? this.posicaoCabecaLombriga != 1 : this.posicaoCabecaLombriga != this.tamanhoAquario;
        if (deveMover)
            this.posicaoCabecaLombriga = this.cabecaLombrigaViradaParaEsquerda ? this.posicaoCabecaLombriga - 1 : this.posicaoCabecaLombriga + 1;
        else
            this.virar();
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public String apresentar() {
        String representacaoGraficaAquarioLombriga = "";
        for (int i = 1; i <= this.tamanhoAquario; i++) {
            if (i == this.posicaoCabecaLombriga)
                representacaoGraficaAquarioLombriga += "0";
            else if (ehParteDoCorpoDaLombriga(i)){
                representacaoGraficaAquarioLombriga += "@";
            }
            else
                representacaoGraficaAquarioLombriga += "#";
        }
        return representacaoGraficaAquarioLombriga;
        
    }
}