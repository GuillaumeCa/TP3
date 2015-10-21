import java.util.Scanner;

public class tableau {
	
	public static int[] tableau1D(int val){
		Scanner scan = new Scanner(System.in);
		int[] tab1D = new int[val];
		for (int i=0;i<val;i++) {
			System.out.println("Valeur " + i + " ?");
			int nb = scan.nextInt();
			tab1D[i] = nb;
		}
		
		return tab1D;
		
	}
	
	public static int[][] tableau2D(int l, int c){
		Scanner scan = new Scanner(System.in);
		int[][] tab2D = new int[l][c];
		for (int i=0;i<l;i++) {
			System.out.print("Ligne " +(i+1));
			for (int k=0;k<c;k++) {
				System.out.print(" ");
				int nb = scan.nextInt();
				tab2D[i][k] = nb;
			}
			
		}
		return tab2D;
	}
	
	public static void affichage1D(int[] tab){
		int val = tab.length;
		String text="";
		for (int i=0;i<val;i++) {
			text += tab[i] + " ";
		}
		System.out.println(text);
	}
	
	public static void affichage2D(int[][] tab) {
		int l= tab.length;
		int c =	tab[0].length;
		for (int i=0;i<l;i++) {
			String line="";
			for (int k=0;k<c;k++) {
				line += tab[i][k] + " ";
			}
			System.out.print(line);
		}
	}
	
	public static int moyenne(int[] tab){
		int val = tab.length;
		
		int sum = 0;
		for (int i=0;i<val;i++){
			sum += tab[i];
		}
		int moy = sum/val;
		return moy;
	}
	
	public static void recherche(int[] tab,int value){
		int val = tab.length;
		boolean premier = true;
		for (int i=0;i<val;i++){
			if (tab[i] == value && premier == true){
				System.out.println("indice de la valeur égale à la moyenne du tableau est : " + i);
				premier = false;
			}
		}
	}
	
	public static int[] deplacement(int[] tab) {
		int moy = moyenne(tab);
		System.out.println("moyenne : " + moy);
		int len = tab.length;
		int r = len-1;
		int i=0;
		while (i<r) {
			if (tab[i]>=moy) {
				int val = tab[i];
				tab[i] = tab[r];
				tab[r] = val;
				r--;
			}
			while (tab[i]<moy) {
				i++;
			}
			while (tab[r]>=moy) {
				r--;
			}
		}
		return tab;
	}
	
	public static int[] tri(int[] tab) {
		int l = tab.length;
		int k = 0;
		while (k < l) {
			int min = k;
			int val = tab[k];
			for (int i = k; i < l; i++) {
				if (val > tab[i]) {
					val = tab[i];
					min = i;
				}
			}

			int temp = tab[k];
			tab[k] = tab[min];
			tab[min] = temp;
			k++;
		}
		
		return tab;
	}
	
	public static int recherche(int val, int[] tab) {
		int k=0;
		while (k < tab.length) {
			if (val == tab[k]) {
				return k;
			}
			k++;
		}
		return -1;
	}
	
	public static int dichotomie(int val, int[] tab) {
		 int a = 0, b = tab.length-1;
		 int i = 0;
		 while (i < tab.length) {
			 int mid = (a + b)/2;
			 if (tab[mid] == val) {
				 return mid;
			 } else {
				 if (tab[mid] > val) {
					 b--;
				 } else {
					 a++;
				 }
			 }
			 i++;
		 }
		 return 1;
	}
	
	public static void main(String[] args) {
//		affichage1D(tableau1D(4));
//		affichage2D(tableau2D(3,4));

		int[] tab = {1,2,4,7,12,15,21,34,42,45};
		int moy = moyenne(tab);
//		System.out.println("moyenne : " + moy);
//		recherche(tab,moy);
//		affichage1D(deplacement(tab));
		affichage1D(tab);
//		affichage1D(tri(tab));
//		System.out.println(recherche(3, tab));
		System.out.println(dichotomie(45, tab));
	}
}
