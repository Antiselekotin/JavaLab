package sample.model;

import javafx.scene.text.Text;

public class Lift extends DummyLift {
    private static FloorBar floorBar = new FloorBar();
    private static DoorBar doorBar = new DoorBar();
    private static TimerTool timerTool = new TimerTool();

    private Text floor;
    private Text door;

    public Lift() {
    }

    public Lift(Text floor, Text door) {
        this.floor = floor;
        this.door = door;
        floorBar = new FloorBar(floor);
        doorBar = new DoorBar(door);
    }

    public static TimerTool getTimerTool() {
        return timerTool;
    }

    public FloorBar getFloorBar() {
        return floorBar;
    }

    public DoorBar getDoorBar() {
        return doorBar;
    }

    @Override
    public StringBuilder getErrorMessage() {
        return this.ErrorMessage;
    }
}
