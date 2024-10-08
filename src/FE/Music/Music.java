package FE.Music;

public abstract class Music {
	protected String songTitle;
	protected double songPrice;
	
	Music(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public double getSongPrice() {
		return songPrice;
	}

	public abstract void setPrice();
	public abstract void setPrice(double songPrice);
}
