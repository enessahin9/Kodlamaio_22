package reCapDemo1;

public class Main {

	public static void main(String[] args) {
		int sayi1 = 246;
		int sayi2 = 25;
		int sayi3 = 26;
		int enBüyük = sayi1;

		if (enBüyük < sayi2) {
			enBüyük = sayi2;
		}
		if (enBüyük < sayi3) {
			enBüyük = sayi3;
		}

		System.out.println("En büyük = " + enBüyük);
	}
}
