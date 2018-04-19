package designMode.template;

public class TemplateObject {

	public static void main(String[] args) {
		Game footballGame = new FootballGame();
		footballGame.play();
		Game basketballGame = new BasketballGame();
		basketballGame.play();
	}

}
