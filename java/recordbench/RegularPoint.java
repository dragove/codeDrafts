package recordbench;
public class RegularPoint implements Point {

	private int x;
	private int y;

	public RegularPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int x() {
		return x;
	}

	@Override
	public int y() {
		return y;
	}

	@Override
    public String toString() {
        return "[x=" + x + ",y=" + y + "]";
    }

}
