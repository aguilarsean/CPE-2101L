package FE.Music;

import java.util.ArrayList;

public class MusicArray {
	private ArrayList<Music> musics = new ArrayList<>(10);
	
	MusicArray() {
		musics.add(new Pop("Uptown Funk"));
		musics.add(new Pop("Shape of You"));
		musics.add(new Pop("Dance the Night"));
		musics.add(new Pop("Happy"));
		musics.add(new Pop("Blinding Lights"));
		musics.add(new Rock("Back in Black"));
		musics.add(new Rock("Basket Case"));
		musics.add(new Rock("Smoke on the Water"));
		musics.add(new Rock("Beat it"));
		musics.add(new Rock("Smells Like Teen Spirit"));
	}
	
	public ArrayList<Music> getMusics() {	
		return musics;
	}

}
