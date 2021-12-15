package Question1;

public class Roomba implements iRobot{
    private int[][] room;
    // final
    final private Spot spot = new Spot(0, 0);
    private Direction direction;

    public Roomba(int[][] room) {
        this.room = room;
        direction = Direction.DOWN;
    }

    @Override
    public boolean move() {
        if (this.direction == Direction.UP) {
            if (this.spot.x == 0 || room[this.spot.x - 1][this.spot.y] == -1) {
                return false;
            }
            this.spot.x -= 1;
        }
        if (this.direction == Direction.DOWN) {

            if (this.spot.x == room.length - 1 || room[this.spot.x + 1][this.spot.y] == -1) {
                return false;
            }
            this.spot.x += 1;
        }
        if (this.direction == Direction.LEFT ) {
            if (this.spot.y == 0 || room[this.spot.x][this.spot.y - 1] == -1) {
                return false;
            }
            this.spot.y -= 1;
        }
        if (this.direction == Direction.RIGHT) {
            if (this.spot.y == room[0].length - 1 || room[this.spot.x][this.spot.y + 1] == -1) {
                return false;
            }
            this.spot.y += 1;
        }
        return true;
    }

    @Override
    public void turnLeft() {
        if (this.direction == Direction.UP) {
            this.direction = Direction.LEFT;
        } else if (this.direction == Direction.DOWN) {
            this.direction = Direction.RIGHT;
        } else if (this.direction == Direction.LEFT) {
            this.direction = Direction.DOWN;
        } else if (this.direction == Direction.RIGHT) {
            this.direction = Direction.UP;
        }
    }

    @Override
    public void turnRight() {
        if (this.direction == Direction.UP) {
            this.direction = Direction.RIGHT;
        } else if (this.direction == Direction.DOWN) {
            this.direction = Direction.LEFT;
        } else if (this.direction == Direction.LEFT) {
            this.direction = Direction.UP;
        } else if (this.direction == Direction.RIGHT) {
            this.direction = Direction.DOWN;
        }
    }

    @Override
    public void clean() {
        room[this.spot.x][this.spot.y] = 1;
    }

    public int[][] getRoom() {
        return room;
    }

    public Spot getSpot() {
        return spot;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setRoom(int[][] room) {
        this.room = room;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
class Spot {
    int x;
    int y;
    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

