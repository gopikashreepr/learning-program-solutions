package command;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("🔘 Pressing ON button:");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("🔘 Pressing OFF button:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
