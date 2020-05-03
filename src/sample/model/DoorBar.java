package sample.model;

import javafx.scene.text.Text;

public class DoorBar implements IChangeUI {
    private static boolean state = true;
    private static Text text;

    public void setState(boolean state) {
        this.state = state;
        changeUI(this.text);
    }

    public DoorBar() {}

    public DoorBar(Text text) {
        this.text = text;
    }

    @Override
    public void changeUI(Text text) {
        if (state) {
            text.setText("Открыта");
        } else {
            text.setText("Закрыта");
        }
    }
}
