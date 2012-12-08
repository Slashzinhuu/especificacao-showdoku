package showdoku.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe que acessa o arquivo para recuperar um "campo" do Sudoku.
 * @author AnderShow
 *
 */
public class DaoCampos {
	
	private final String caminhoFacil = System.getProperty("user.dir") + System.getProperty("file.separator") + "Facil" + System.getProperty("file.separator");
	private final String caminhoNormal = System.getProperty("user.dir") + System.getProperty("file.separator") + "Normal" + System.getProperty("file.separator");
	private final String caminhoSouFoda = System.getProperty("user.dir") + System.getProperty("file.separator") + "SouFoda" + System.getProperty("file.separator");
	
	
	public int[][] getCampoFacil() throws IOException{
	    return getCampo(caminhoFacil, "camposFacil.txt");
	}
	
	public int[][] getCampoNormal() throws IOException{
		return getCampo(caminhoNormal, "camposNormal.txt");
	}
	
	public int[][] getCampoSouFoda() throws IOException{
		return getCampo(caminhoSouFoda, "camposSouFoda.txt");
	}
	
	/**
	 * Recebe duas strings que combinadas indicam onde está o arquivo. 
	 * @param caminho
	 * @param nomedoArquivo
	 * @return Retorna o campo contido no arquivo especificado
	 * @throws IOException
	 */
	private int[][] getCampo(String caminho, String nomedoArquivo) throws IOException{
		int [][] result = new int[9][9];
		BufferedReader campoReader = null;
		
					try {
		campoReader = new BufferedReader(new FileReader(caminho+nomedoArquivo));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
		String campoTxt = campoReader.readLine();
		String[] campo = campoTxt.split(" ");
		int aux=0;
	    for (int i = 0; i < 9; i++){
	    	for (int j = 0; j < 9; j++){
	    		result[i][j] = Integer.parseInt(campo[aux]);
	    		aux++;
	    	}
	    }
	    campoReader.close();
	    return result;
	}
	
}
