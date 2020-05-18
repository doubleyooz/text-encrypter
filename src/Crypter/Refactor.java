package Crypter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Refactor<RunJavaTxt> {

	private Crypter c1 = new Crypter();
	private ArrayList<Character> characters = new ArrayList<Character>();	
	private String dataPath = "C:\\Users\\Waifu\\eclipse-workspace\\Encrypter\\src\\data\\dados.txt";
	
	
	public Refactor() {
		bancoDados();
	}

	public Refactor(String crypterPath) throws Exception {
		bancoDados();
		loadCryptFile(crypterPath);
	}
	
	public void loadCryptFile(String crypterPath) throws Exception {		
		String ext = crypterPath.split("[.]")[1];	
		
		if(ext.equals("txt")) {
			c1 = new Crypter(crypterPath);
		}
		else {
			throw new Exception ("Invalid file format");
		}
	}

	public String crypt(String text) {		
		String newText = "";
		
		for (int i = 0; i < text.length(); i++) {	
			int index = characters.indexOf(text.charAt(i));
			newText += c1.code.get(index);
			
		}
		return newText;
	}

	public String decrypt(String text) {		
		String newText = "";
		
		for (int i = 0; i < text.length(); i++) {	
			int index = c1.code.indexOf(text.charAt(i));
			newText += characters.get(index);			
		}
		return newText;		
	}


	public void bancoDados() {

		String javaPath = "C:\\Users\\Waifu\\eclipse-workspace\\Encrypter\\src\\RunJavaTxt.java";
		File file = new File(javaPath);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataPath));
			String reader="";
			System.out.println("start");
			try {				
				while((reader=(br.readLine()))!=null){
					
					for (int i = 0; i< reader.length(); i++) {
						reader.replace("\t",""); 
						characters.add(reader.charAt(i));
					}
				}
				br.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
