package basic_types;

public class Coords {
	private int X;
	private int Y;
	
	public Coords(int x, int y) {
		this.setCoords(x, y);
	}
	
	public void setCoords(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
}
