package projectzoo;

import projectzoo.domain.Room;
import projectzoo.game.Bag;
import projectzoo.game.Player;
import projectzoo.gamecontroller.VideoGameController;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Alex", 100);
        Room entry = new Room("Hell");        //da spostare nel controller
        Bag bag1 = new Bag(30);

        VideoGameController videoGameController = new VideoGameController(player, entry ,bag1);
        videoGameController.startGame();

    }

    /*
        room1.addAdjacents("nord", "paradise");
        room2.addAdjacents("sud", "hell");
        room1.getAdjacents("sud");

    private static void zooTest() {

        Optional<Animal> tallestLion = zoo.getTallestAnimal(Lion.class);
        System.out.println("the tallest lion is " + tallestLion.get().getNickname());

        Optional<Animal> lowestEagle = zoo.getLowestAnimal(Eagle.class);
        System.out.println("the lowest eagle is " + lowestEagle.get().getNickname());

        Optional<Animal> heaviestLion = zoo.getHeaviestAnimal(Lion.class);
        System.out.println("the heaviest lion is " + heaviestLion.get().getNickname());

        Optional<Animal> lightestTiger = zoo.getLightestAnimal(Tiger.class);
        System.out.println("the lightest tiger is " + lightestTiger.get().getNickname());

        Optional<Animal> longestTailedAnimal = zoo.getLongestTailedAnimal();
        System.out.println("The longest tailed animal is " + longestTailedAnimal.get().getNickname());

        Optional<Animal> widestWingspanAnimal = zoo.getWidestWingspan();
        System.out.println("The widest wingspan animal is " + widestWingspanAnimal.get().getNickname());
    }*/
}