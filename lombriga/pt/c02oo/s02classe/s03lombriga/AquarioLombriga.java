package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {

	int tamanhoMaximoAquario;
    int tamanhoMinimoAquario;
    int tamanhoAquario;
	int tamanhoLombriga;
	int posicaoCabecaLombriga;
	boolean cabecaLombrigaViradaParaEsquerda;
	
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
	
    AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoCabecaLombriga) {
        this.tamanhoMaximoAquario = 15;
        this.tamanhoMinimoAquario = 1;
        this.tamanhoAquario = this.validaERetornaTamanhoAquario(tamanhoAquario); 
		this.tamanhoLombriga = (this.ehValidoTamanhoLombriga(tamanhoLombriga)) ? tamanhoLombriga : this.tamanhoAquario;
		this.posicaoCabecaLombriga = (this.posicaoCabecaLombrigaEhValida(posicaoCabecaLombriga)) ? posicaoCabecaLombriga : 1;
		this.cabecaLombrigaViradaParaEsquerda = true;
	}
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public int validaERetornaTamanhoAquario(int tamanhoAquario) {
        switch(tamanhoAquario) {
            case tamanhoAquario < this.tamanhoMinimoAquario:
                return this.tamanhoMinimoAquario;
            case tamanhoAquario > this.tamanhoMaximoAquario:
                return this.tamanhoMaximoAquario;
            default:
                return tamanhoAquario;
        }
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public boolean ehValidoTamanhoLombriga(int tamanhoLombriga){
        return tamanhoLombriga < this.tamanhoAquario;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public boolean ehValidaPosicaoCabecaLombriga(int posicaoCabecaLombriga) {
        return posicaoCabecaLombriga > 1 && posicaoCabecaLombriga < this.tamanhoAquario && this.tamanhoAquario <= this.tamanhoLombriga + posicaoCabecaLombriga;
    }
	
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
	
    public void crescer() {
		if (this.cabecaLombrigaViradaParaEsquerda && this.posicaoCabecaLombriga + this.tamanhoLombriga < this.tamanhoAquario)
			this.tamanhoLombriga++;
		else if(this.posicaoCabecaLombriga - this.posicaoCabecaLombriga > 1)
			this.tamanhoLombriga++;
	}
	
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
	
    public void virar() {
        if (this.cabecaLombrigaViradaParaEsquerda)
            this.posicaoCabecaLombriga += this.tamanhoLombriga - 1;
        else
            this.posicaoCabecaLombriga -= this.tamanhoLombriga + 1;
        this.cabecaLombrigaViradaParaEsquerda = !this.cabecaLombrigaViradaParaEsquerda;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void mover() {
        boolean deveMover = this.cabecaLombrigaViradaParaEsquerda ? this.posicaoCabecaLombriga - 1 >= 1 : this.posicaoCabecaLombriga + 1 <= this.tamanhoAquario;
        if (deveMover)
            this.posicaoCabecaLombriga = this.cabecaLombrigaViradaParaEsquerda ? this.posicaoCabecaLombriga - 1 : this.posicaoCabecaLombriga + 1;
        else
            this.virar();
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void apresentar() {
        for (int i = 1; i <= this.tamanhoAquario; i++) {
            if (i == this.posicaoCabecaLombriga)
                System.out.println('0');
            else if ((this.cabecaLombrigaViradaParaEsquerda && i <= this.posicaoCabecaLombriga + this.tamanhoLombriga - 1)
                        || !this.cabecaLombrigaViradaParaEsquerda && i >= this.posicaoCabecaLombriga - this.tamanhoLombriga + 1){
                System.out.println('@');
            }
            else
                System.out.println('#');
        }
    }
}