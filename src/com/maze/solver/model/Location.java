package com.maze.solver.model;

public class Location {

    private int x;
    private int y;
    private Description description;
    private Location previous;
    public Location(int x, int y, Description description) {
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Location getPrevious() {
        return previous;
    }

    // only assign if null to prevent infinite chain
    public void setPrevious(Location previous) {
        this.previous = this.previous == null ? previous : this.previous;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location) obj;
            return x == location.x && y == location.y;
        }
        return false;
    }

    public enum Description {WALL, PASSAGE, START, END, PATH}
}
