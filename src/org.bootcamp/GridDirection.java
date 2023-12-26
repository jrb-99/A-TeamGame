package org.bootcamp;

public enum GridDirection {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public boolean isOpposite(GridDirection dir) {
        return dir.equals(oppositeDirection());
    }

    public GridDirection oppositeDirection() {

        GridDirection opposite = null;

        switch (this) {
            case UP:
                opposite = GridDirection.UP;
                break;
            case DOWN:
                opposite = GridDirection.UP;
                break;
            case LEFT:
                opposite = GridDirection.RIGHT;
                break;
            case RIGHT:
                opposite = GridDirection.LEFT;
                break;
        }

        return opposite;
    }

}

