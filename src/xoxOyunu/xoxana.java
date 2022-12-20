package xoxOyunu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;





public class xoxana {
	
	static ArrayList<Integer> oyuncununyeri = new ArrayList<Integer>();
	static ArrayList<Integer> bilgisayarinyeri = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		char[][] oyunTahtası = {{'|','-','-','-','-','-','|'},
				                {'|',' ','|',' ','|',' ','|'},
				                {'|','-','+','-','+','-','|'},
				                {'|',' ','|',' ','|',' ','|'},
				                {'|','-','+','-','+','-','|'},
				                {'|',' ','|',' ','|',' ','|'},
				                {'|','-','-','-','-','-','|'},
				
		};
		
		System.out.println("| - | - | - |");
		System.out.println("| 1 | 2 | 3 |");
		System.out.println("| - | - | - |");
		System.out.println("| 4 | 5 | 6 |");
		System.out.println("| - | - | - |");
		System.out.println("| 7 | 8 | 9 |");
		System.out.println("| - | - | - |");
		
		
		
		while(true) {
			Scanner scan= new Scanner(System.in);
		    System.out.println("1'den 9'a kadar X'i yerleştirmek istediğiniz bir yer seçin");
			int oyuncuyer=scan.nextInt();
			
			while(oyuncununyeri.contains(oyuncuyer) || bilgisayarinyeri.contains(oyuncuyer)){
				System.out.println("girdiğiniz kutu dolu, yeniden deneyin");
				oyuncuyer =scan.nextInt();
				}
			
			parcaYerlestir(oyunTahtası, oyuncuyer, "oyuncu");
			
			String sonuc =kazananKontrol();
			if(sonuc.length() > 0) {
				System.out.println(sonuc);
				break;
			}			
			Random rand = new Random();
			int bilgisayaryer = rand.nextInt(9)+1;
			
			while(oyuncununyeri.contains(bilgisayaryer) || bilgisayarinyeri.contains(bilgisayaryer)){
				oyuncuyer = rand.nextInt(9) + 1;
				}
			
			parcaYerlestir(oyunTahtası, bilgisayaryer, "bilgisayar");
			
			printoyunTahtası(oyunTahtası);
			
			sonuc =kazananKontrol();
			if(sonuc.length() > 0) {
				System.out.println(sonuc);
				break;
			}
			
	    }
		
	}
		
		
		
			
		
	public static void printoyunTahtası(char[][] oyunTahtası) {
		for(char[] sıra:oyunTahtası ) {
			for(char c:sıra) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void parcaYerlestir(char[][] oyunTahtası, int yer, String kullanıcı) {
		char sembol =' ';
		
		if(kullanıcı.equals("oyuncu")) {
			sembol='X';
			oyuncununyeri.add(yer);
		}else if (kullanıcı.equals("bilgisayar")) {
			sembol='O';
			bilgisayarinyeri.add(yer);
		}
		switch(yer) {
		case 1:
			oyunTahtası[1][1] = sembol;
			break;
		case 2:
			oyunTahtası[1][3] = sembol;
			break;
		case 3:
			oyunTahtası[1][5] = sembol;
			break;
		case 4:
			oyunTahtası[3][1] = sembol;
			break;
		case 5:
			oyunTahtası[3][3] = sembol;
			break;
		case 6:
			oyunTahtası[3][5] = sembol;
			break;
		case 7:
			oyunTahtası[5][1] = sembol;
			break;
		case 8:
			oyunTahtası[5][3] = sembol;
			break;
		case 9  :
			oyunTahtası[5][5] = sembol;
			break;
			default:
				break;
	}
}
	public static String kazananKontrol() {
		
		List ustsıra= Arrays.asList(1,2,3);
		List ortasıra= Arrays.asList(4,5,6);
		List altsıra= Arrays.asList(7,8,9);
		List ilksütun= Arrays.asList(1,4,7);
		List ortasütun= Arrays.asList(2,5,8);
		List sonsütun= Arrays.asList(3,6,9);
		List capraz1= Arrays.asList(1,5,9);
		List capraz2= Arrays.asList(7,5,3); 
		
		List<List> kazanmak = new ArrayList<List>();
		kazanmak.add(ustsıra);
		kazanmak.add(ortasıra);
		kazanmak.add(altsıra);
		kazanmak.add(ilksütun);
		kazanmak.add(ortasütun);
		kazanmak.add(sonsütun);
		kazanmak.add(capraz1);
		kazanmak.add(capraz2);
		
		for(List l : kazanmak) {
			if(oyuncununyeri.containsAll(l)) {
				return "TEBRİKLER KAZANDINIZ";
			}else if(bilgisayarinyeri.containsAll(l)) {
				return "bilgisayar kazandı, KAYBETTİNİZ"; 
			}else if(oyuncununyeri.size() + bilgisayarinyeri.size() == 9) {
				return "kimse kazanamadı";
				
			}
		}
		
		return "";
		
	}

}
