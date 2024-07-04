package localizadorDeCidade;
import arq.Arquivo;
import ceps.Ceps;
public class IdentificaCep {
	private Arquivo arq;
	
	public IdentificaCep() {
		arq = new Arquivo();
	}
	
	public void identificaCidade() {
		boolean encontrado = false;
		for(Ceps i: arq.retornaCep()) {
			if(arq.cepBuscador() >= i.getCepInicial() && arq.cepBuscador() <= i.getCepFinal()) {//verifica de qual cidade é o cep buscado, c
				System.out.println(i.getCidade());
				encontrado = true;
			}
		}
		if(!encontrado) {
			System.out.println("Não foi identificado o CEP");
		}
	}
}
