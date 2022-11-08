package abstractClasses;

public abstract class GameCalculator {
	public void hesapla() {
		System.out.println("Your Score : 100");
	}

	public final void gameOver() {
		System.out.println("Game Over!");
	}
}
