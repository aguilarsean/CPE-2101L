import java.util.*;

public class TV_Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TV tv = new TV();
		
		System.out.print("Turn TV on/off (1 - on, 0 - off): ");
		int onOrOff = scanner.nextInt();
		scanner.nextLine();
		
		if (onOrOff == 1) {
			tv.turnOn();
		} else {
			tv.turnOff();
		}s
		
		while(true) {
			System.out.println("TV Menu");
			System.out.println("1. ");
			System.out.print("Choose a channel (1 to 120): ");
			int channel = scanner.nextInt();
			scanner.nextLine();
			
			tv.setChannel(channel);
		}
	}
	
	public void onOrOff(int choice) {
		
	}
}

class TV {
    private int channel;
    private int volumeLevel;
    private boolean on;
    
    public TV() {
    	this.channel = 0;
    	this.volumeLevel = 0;
    	this.on = false;
    }
    
    public void turnOn() {
    	this.on = true;
    	System.out.println("TV is ON");
    }
    
    public void turnOff() {
        this.on = false;
        System.out.println("TV is OFF");
    }
    
    public void setChannel(int newChannel) {
        this.channel = newChannel;
        System.out.println(channel);
    }
    
    public void setVolume(int newVolumeLevel) {
        this.volumeLevel = newVolumeLevel;
        System.out.println(volumeLevel);
    }
    
    public void channelUp() {
        this.channel = channel++;
    }
    
    public void channelDown() {
    	this.channel = channel--;
    }
    
    public void volumeUp() {
        this.volumeLevel = volumeLevel++;
    }
    
    public void volumeDown() {
        this.volumeLevel = volumeLevel--;
    }
}