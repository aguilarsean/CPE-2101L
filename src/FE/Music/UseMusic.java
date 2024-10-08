package FE.Music;

import java.util.ArrayList;

public class UseMusic {
	private static MusicArray musicArray;
	
	public static void main(String[] args) {
		musicArray = new MusicArray();
		ArrayList<Music> musics = musicArray.getMusics();
		
		for (Music music : musics) {
			if (music instanceof Pop) {
				System.out.println("Genre: Pop, " + "Title: "+ music.getSongTitle() + ",Price: " + music.getSongPrice());
			}
			
			if (music instanceof Rock) {
				System.out.println("Genre: Rock, " + "Title: "+ music.getSongTitle() + ",Price: " + music.getSongPrice());
			}
		}
	}
}
