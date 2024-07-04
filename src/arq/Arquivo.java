package arq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ceps.Ceps;

public class Arquivo {
	private String path = "src\\cep.txt";
	private Long cepBuscado;
	
	public Arquivo() {
		
	}
	public List<Ceps> retornaCep() {
		List<Ceps> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			
			while (line != null) {
			
				if(line.equals("--")) {//verifica os "--" se achar vai verificar o CEP e guardar para usar como parametro de procura
					line = br.readLine();
					this.cepBuscado = Long.parseLong(line);
				}else{
					
					String[] recebe = line.split(",");//pega toda a linha do txt e quebra sempre que achar ","
					String cidade = recebe[0];
					Long cepInicial = Long.parseLong(recebe[1]);
					Long cepFinal = Long.parseLong(recebe[2]);
					
					Ceps cep = new Ceps(cidade, cepInicial, cepFinal);
					list.add(cep);
				}
				line = br.readLine();
				
			}			
			return list;
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return null;
	}
	
	public Long cepBuscador() {//permite a busca do cep
		return this.cepBuscado;
	}
}
