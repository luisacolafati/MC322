package lab03.src.pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {

      Animacao animacao;
      
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++) {
        animacao = new Animacao(lombrigas[l]);
        tk.gravaPasso("=====");
        while (animacao.comandosAnimacao.length() >= 0) {
           animacao.passo();
           tk.gravaPasso(animacao.apresenta());
        }
      }
      
      tk.stop();
   }

}
