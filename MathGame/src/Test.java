import java.util.Random;

public class Test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GameList gameList = new GameList();
    Random random=new Random();
    for (int i = 0; i < 7; i++) {
      GameNode gameNode=new GameNode(random);
      gameList.addNode(gameNode);
     
    }
    System.out.println(gameList);
    System.out.println(gameList.contains(4));

  }
}
