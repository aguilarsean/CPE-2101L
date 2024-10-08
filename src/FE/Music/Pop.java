package FE.Music;

public class Pop extends Music {
	Pop(String songTitle) {
		super(songTitle);
		setPrice();
	}

	@Override
	public void setPrice() {
		this.songPrice = 4.99;
	}

	@Override
	public void setPrice(double songPrice) {
		this.songPrice = songPrice;
	}
}
