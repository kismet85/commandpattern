package local.commandpattern;

public class MoveCursorRightCommand implements Command {
    private Grid receiver;

    public MoveCursorRightCommand(Grid receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveRight();
    }
}