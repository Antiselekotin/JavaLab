package sample.model;

import javafx.scene.text.Text;

public class FloorBar implements IChangeUI{
    private static Integer state = 1;
    private static Text text;

    public void setState(Integer state) {
        this.state = state;
        changeUI(this.text);
    }

    public Integer getState() {
        return state;
    }

    @Override
    public void changeUI(Text text) {
        text.setText(state.toString());
    }

    public FloorBar() {}
    public FloorBar(Text text) {
        this.text = text;
    }
}
