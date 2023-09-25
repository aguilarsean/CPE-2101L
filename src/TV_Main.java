import java.util.*;

interface Electronics {
	void turnOn();
	void turnOff();
	void setChannel(int newChannel);
	void setVolume(int newVolumeLevel);
	void channelUp();
	void channelDown();
	void volumeUp();
	void volumeDown();
}

public class TV_Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Electronics tv = new TV();
		
		System.out.print("Turn TV on/off (1 - on, 0 - off): ");
		int onOrOff = scanner.nextInt();
		scanner.nextLine();
		
		if (onOrOff == 1) {
			tv.turnOn();
		} else {
			tv.turnOff();
		}
		
		while(onOrOff == 1) {
			System.out.print("Choose a channel (1 to 120): ");
			int channel = scanner.nextInt();
			scanner.nextLine();
			tv.setChannel(channel);
			tv.setVolume(3);
			
			System.out.println("Press 3 to open menu");
			int menu = scanner.nextInt();
			scanner.nextLine();
			
			if(menu == 3) {
				System.out.println("");
			}
		}
	}
	
	public void onOrOff(int choice) {
		
	}
}

class TV implements Electronics {
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
		if(on) {
			channel++;
			System.out.println("Channel - " + channel);
		} else {
			System.out.println("TV is off, turn it on.");
		}
	}
	
	public  void channelDown() {
		if(on) {
			channel--;
			System.out.println("Channel - " + channel);
		} else {
			System.out.println("TV is off, turn it on.");
		}
	}
	
	public void volumeUp() {
		if(on) {
			volumeLevel++;
			System.out.println("Volume - " + volumeLevel);
		} else {
			System.out.println("TV is off, turn it on.");
		}
	}
	
	public void volumeDown() {
		if(on) {
			volumeLevel--;
			System.out.println("Volume - " + volumeLevel);
		} else {
			System.out.println("TV is off, turn it on.");
		}
	}
}