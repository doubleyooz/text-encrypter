package Crypter;

public class example {

	public static void main (String[]args ) throws Exception{
		// TODO Auto-generated constructor stub
		
		
		
		System.out.println("Gerar arquivo codificador");
		Refactor nc = new Refactor();
		
		String fraseCriptografada = nc.crypt("Frase de teste");
		System.out.println("Frase Cryptografada: " + fraseCriptografada);
		
		String fraseDecriptografada = nc.decrypt(fraseCriptografada);
		System.out.println("Frase Descryptografada: " + fraseDecriptografada);
		
		
		
		//Usando arquivo crypter criado anteriormente
		
		System.out.println();
		System.out.println("Usando arquivo codificador da memória");
		
		String arquivoCriptografia = "C:\\Users\\Waifu\\eclipse-workspace\\Encrypter\\src\\data\\crypter-4d76d1f3-7f01-4467-9.txt";
		nc.loadCryptFile(arquivoCriptografia);//Caso não seja encontrado lança exception
		
		fraseCriptografada = nc.crypt("Frase de teste2");
		System.out.println("Frase Cryptografada: " + fraseCriptografada);
		
		fraseDecriptografada = nc.decrypt(fraseCriptografada);
		System.out.println("Frase Descryptografada " + fraseDecriptografada);
		System.out.println();
		
		
		
		
	}

}
