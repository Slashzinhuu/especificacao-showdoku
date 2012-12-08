package showdoku.campo;

import java.io.IOException;

import showdoku.campo.excecoes.DimensoesInvalidasException;
import showdoku.dao.DaoCampos;

public class Campo {
	
	int[][] campo;
	int[][] rosto;
	
	public Campo (){
		campo = new int[9][9];
		rosto = new int[9][9];
	}

	public void preencheCampo(int[][] copia) throws DimensoesInvalidasException {
		if (copia.length != 9 || copia[0].length != 9){
			throw new DimensoesInvalidasException();
		}
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				campo[i][j] = copia[i][j];
			}
		}
		this.preencheRosto();
	}
	
	private void preencheRosto(){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (campo[i][j] != 0){
					rosto[i][j] = 1;
				}else{
					rosto[i][j] = 0;
				}
			}
		}
	}
	
	public void imprimeCampo(){
		for (int i = 0; i < 9; i++){
			System.out.println();
			for (int j = 0; j < 9; j++){
				System.out.print(campo[i][j] + " ");
				if (j==2 || j==5){
					System.out.print(" ");
				}
			}
			if (i == 2 || i == 5){
				System.out.println();
			}
		}
	}
	
	public void imprimeRosto(){
		for (int i = 0; i < 9; i++){
			System.out.println();
			for (int j = 0; j < 9; j++){
				System.out.print(rosto[i][j] + " ");
				if (j==2 || j==5){
					System.out.print(" ");
				}
			}
			if (i == 2 || i == 5){
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Campo campo = new Campo();
		DaoCampos dao = new DaoCampos();
		int[][] copia = new int[9][9];
		try {
			copia = dao.getCampoFacil();
		} catch (IOException e1) {
			System.out.println("Erro de E/S ao carregar campo a partir da memoria."); 
			e1.printStackTrace();
		}
		
		try {
			campo.preencheCampo(copia);
		} catch (DimensoesInvalidasException e) {
			System.out.println("Ops. Ocorreu um erro ao gerar o campo!");
			e.printStackTrace();
		}
		campo.imprimeCampo();
		System.out.println();
		campo.imprimeRosto();
	}
}
