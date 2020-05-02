package sample.model;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerTool {

    private SpeedBar speed = new SpeedBar();
    private DoorBar doorBar = new DoorBar();
    private FloorBar floorBar = new FloorBar();
    private Integer[] taskList = new Integer[10];


    private Timer timer;

    public void PushTask(Integer taskI) {
        for(int i = 0; i < taskList.length; i++) {
            if (taskList[i] == taskI) {
                break;
            } else if (taskList[i] == null) {
                taskList[i] = taskI;
                break;
            }
        }
        if (taskList[1] == null) {
            timer = new Timer(5000 / speed.getState(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    doorBar.setState(false);
                    if (floorBar.getState() < taskList[0]) {
                        floorBar.setState(floorBar.getState() + 1);
                    } else if (floorBar.getState() > taskList[0]) {
                        floorBar.setState(floorBar.getState() - 1);
                    } else {
                        floorBar.setState(taskList[0]);

                        for (int i = 1; i < taskList.length; i++) {
                            taskList[i-1] = taskList[i];
                        }
                        try {
                            doorBar.setState(true);
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if(taskList[0] == null) {
                        timer.stop();
                    }
                }
            });
            timer.start();
        }
    }
}
