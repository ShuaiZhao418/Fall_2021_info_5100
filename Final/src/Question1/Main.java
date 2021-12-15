package Question1;

public class Main {
    public static void main(String[] args) {
        int[][] room = {
                {0, 0, 0, 0},
                {-1, 0, -1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, -1}};
        Roomba robot = new Roomba(room);
        //
        System.out.println(robot.getDirection());
        robot.turnRight();
        System.out.println(robot.getDirection());
        robot.turnLeft();
        robot.clean();
        System.out.println(robot.getDirection());
        System.out.println(robot.move());
    }
}
