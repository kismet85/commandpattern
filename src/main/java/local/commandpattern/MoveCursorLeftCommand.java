package local.commandpattern;

public class MoveCursorLeftCommand implements Command {
    private Grid receiver;

    public MoveCursorLeftCommand(Grid receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveLeft();
    }
}