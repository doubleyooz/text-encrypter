package Crypter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.UUID;

public class Crypter {

	public ArrayList <Character> code = new ArrayList<Character>();
	private String fileName;
	private String dataPath = "C:\\Users\\Waifu\\eclipse-workspace\\Encrypter\\src\\data\\dados.txt";
	private String crypterPath = "";

	public Crypter() {
		try {
			generateCode();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Crypter(String crypterPath) {

		this.crypterPath = crypterPath;
		useCrypterFile();
		
	}

	private void generateCode() throws FileNotFoundException {		
		String reader="";
		UUID uuid = UUID.randomUUID();		
		fileName = "crypter-" + uuid.toString().substring(0, 20);
		this.crypterPath = "C:\\Users\\Waifu\\eclipse-workspace\\Encrypter\\src\\data\\" + fileName + ".txt";

		try (FileWriter fw = new FileWriter(new File(crypterPath));){
			try (BufferedReader br = new BufferedReader(new FileReader(dataPath));) {								
				//Carrega as letras salvas no arquivo
				while ((reader = (br.readLine())) != null) {
					for (int i = 0; i< reader.length(); i++) {
						reader.replace("\t",""); 
						code.add(reader.charAt(i));
					}
				}
				//Embaralha e salva no arquivo
				Collections.shuffle(code);
				PrintWriter writer = new PrintWriter(fw);
				writer.print("");
				
				for(int i = 0; i < code.size(); i ++) 
					writer.print(code.get(i));
				

				writer.close();
				fw.close();		

				System.out.println("Gravado com sucesso.");

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Endereço inválido");
			e1.printStackTrace();
		}
	}

	public void useCrypterFile() {
		String reader="";

		//Carrega as letras do arquivo		
		try (BufferedReader br = new BufferedReader(new FileReader(this.crypterPath));) {
			
			reader = br.readLine();
			code.clear();
			//Carrega as letras salvas no arquivo
			for (int i = 0; i< reader.length(); i++) {
				reader.replace("\t",""); 
				code.add(reader.charAt(i));
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
