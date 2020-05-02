package sample.model;

import javafx.scene.text.Text;

public class SpeedBar implements IChangeUI{
    private static Integer state = 4;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public void changeUI(Text text) {
        text.setText(state.toString());
    }
}
