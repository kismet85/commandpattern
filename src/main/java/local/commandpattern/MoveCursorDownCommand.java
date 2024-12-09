package local.commandpattern;

public class MoveCursorDownCommand implements Command {
    private Grid receiver;

    public MoveCursorDownCommand(Grid receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveDown();
    }
}