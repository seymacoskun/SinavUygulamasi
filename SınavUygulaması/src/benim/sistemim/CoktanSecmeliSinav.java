package benim.sistemim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.PublicKey;
import java.util.Scanner;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class CoktanSecmeliSinav
{
	static Scanner konsol = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		System.out.print("Lütfen geçerli bir mail adresi giriniz: ");
		String mailAdresi = konsol.nextLine();
		
		File dosya = new File("javasorularýmýz.csv");
		Scanner s = new Scanner(dosya);
		
		//SORULARI ALDIÐIMIZ KISIM
		String[] sorular = new String[10];
		int i = 0;
		while(s.hasNextLine())
		{
			String satir = s.nextLine();
			sorular[i] = satir;
			i++;
		}
		s.close();
		
		int dogruSayisi = 0;
		for(int j = 0; j < sorular.length; j++)
		{
			String[] split = sorular[j].split(";");
			System.out.println("Soru " + (j + 1) + " " + split[0]);
			String siklar = "";
			siklar += "A) " + split[1] + "   B) " + split[2];
			
			if(!split[3].equals("")){
				siklar += "   C) " + split[3];
			}
			
			if(!split[4].equals("")){
				siklar += "   D) " + split[4];
			}
			System.out.println(siklar);
			
			String cevap = konsol.nextLine();
			if(cevap.equals(split[5]))
			{
				System.out.println("Doðru.");
				dogruSayisi++;
			} else {
				System.out.println("Yanlýþ.");
			}
			System.out.println();
		}
		dosyayaYaz(mailAdresi, dogruSayisi);
	}	
		public static void dosyayaYaz(String mailAdresi, int dogruSayisi) throws IOException
		{
			Writer r = new FileWriter("yeni.csv", true);
			r.write(mailAdresi + ";" + dogruSayisi + "\n");
			r.close();
		}
}
