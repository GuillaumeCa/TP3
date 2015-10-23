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
			System.out.println("Ligne " +(i+1));
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
			System.out.println(line);
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

	public static int rechercheEx(int val, int[] tab) {
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
		while (a < b) {
			int mid = (a + b)/2;
			if (b - a == 1) {
				if (tab[a] == val) return a;
				else if (tab[b] == val) return b;
				else return -1;
			} else {
				if (tab[mid] > val) {
					b = mid;
				} else {
					a = mid;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

//	3.1 Saisie dynamique des éléments dans un tableau unidimensionnel
//			de taille 4 :
		affichage1D(tableau1D(4));

//	3.1 Saisie dynamique des éléments dans un tableau
// 			bidimensionnel 3x4 :
		affichage2D(tableau2D(3,4));

//	3.2 Moyenne des éléments d'un tableau
//	3.2.1
		int[] tab = {1,2,4,7,12,15,21,34,42,45,52};
		affichage1D(tab);
		int moy = moyenne(tab);
		System.out.println("moyenne : " + moy);
		recherche(tab,moy);
//	3.2.2
		int[] tab1 = {1,23,8,3,5,32,4,6};
		System.out.println("Deplacement tableau :");
		affichage1D(tab1);
		affichage1D(deplacement(tab1));

//	3.3 Tri des elements d'un tableau
		System.out.println("Tri tableau :");
		affichage1D(tri(tab1));

//	3.4 Recherche exhaustive
		System.out.println("Indice de la première occurence de 3 : " + rechercheEx(3, tab1));

//	3.5 Dichotomie
		System.out.println("Dichotomie : " + dichotomie(4, tab));

	}
}
