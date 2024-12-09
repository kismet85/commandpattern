package local.commandpattern;

public class GenerateCodeCommand implements Command {
    private Grid receiver;

    public GenerateCodeCommand(Grid receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.createCode();
    }
}