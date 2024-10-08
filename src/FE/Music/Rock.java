package FE.Music;

public class Rock extends Music {
	Rock(String songTitle) {
		super(songTitle);
		setPrice();
	}

	@Override
	public void setPrice() {
		this.songPrice = 7.99;
	}

	@Override
	public void setPrice(double songPrice) {
		this.songPrice = songPrice;
	}
}
