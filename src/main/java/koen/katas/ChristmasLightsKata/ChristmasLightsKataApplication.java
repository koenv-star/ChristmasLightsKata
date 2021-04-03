package koen.katas.ChristmasLightsKata;

public class ChristmasLightsKataApplication {

    public static void main(String[] args) {

        Grid grid = new Grid();

        grid.turnOnLightCo1toCo2(new Coordinate(887, 9), new Coordinate(959, 629));
        grid.turnOnLightCo1toCo2(new Coordinate(454, 398), new Coordinate(844, 448));
        grid.turnOfLightCo1toCo2(new Coordinate(539, 243), new Coordinate(559, 965));
        grid.turnOfLightCo1toCo2(new Coordinate(370, 819), new Coordinate(676, 868));
        grid.turnOfLightCo1toCo2(new Coordinate(145, 40), new Coordinate(370, 997));
        grid.turnOfLightCo1toCo2(new Coordinate(301, 3), new Coordinate(808, 453));
        grid.turnOnLightCo1toCo2(new Coordinate(351, 678), new Coordinate(951, 908));


        System.out.println(grid.getLightsOn());
    }

}
