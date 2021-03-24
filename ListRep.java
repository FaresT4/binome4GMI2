package FileIO;
import java.io.*;

public class ListRep {
	
	public static void main(String[] args) {
		
		listRep(new File("."));
		lireFichier(new File("/Users/oumlalaomar/Desktop/Lexique.txt"));
		ecrireFichier(new File("/Users/oumlalaomar/Desktop/ajout.txt"));
		copierFichier(new File("/Users/oumlalaomar/Desktop/Lexique.txt"),new File("/Users/oumlalaomar/Desktop/cpy.txt"));
		
		
		}
	public static void listRep(File rep) {
		File r2;
		if (rep.isDirectory()) {
			String t[]=rep.list();
			for (int i=0;i<t.length;i++) {
				r2=new File(rep.getAbsolutePath()+"\\"+t[i]);
				if (r2.isDirectory()) {
					listRep(r2);
				}else {
					System.out.println(r2.getAbsolutePath());
				}
			}
		}
	}
	
	public static void lireFichier(File rep) {
		
		try{
			
			FileReader fr =new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			while (br.ready()) {
				
				System.out.println(br.readLine());
			}
			br.close();
			fr.close();
			
			}catch (Exception e){
			
				System.out.println("Erreur "+e);
			
			}
	}
	
	public static void ecrireFichier(File rep) {
	
		try{
			
			FileWriter fw=new FileWriter(rep);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write("Ceci est mon fichier");
			bw.newLine();
			bw.write("Il est à moi...");bw.close();
			
			}catch (Exception e){
			
				System.out.println("Erreur "+e);
			
			}
	}
	
	public static void copierFichier(File rep,File dep) {
		
		try {
			
		
			FileReader fr = new FileReader(rep);
			BufferedReader br= new BufferedReader(fr);
			FileWriter fw=new FileWriter(dep);
			BufferedWriter bw= new BufferedWriter(fw);
			
			while (br.ready()) {
				
				bw.write(br.readLine());
				bw.newLine();
				
			}
			
			br.close();
			fr.close();
			bw.close();
		
		}catch (Exception e){
			
			System.out.println("Erreur "+e);
			
			}
		
		
	}

}
