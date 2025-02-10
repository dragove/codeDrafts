package recordbench;
public final class FinalPoint implements Point {

	private final int x;
	private final int y;

	public FinalPoint(int x, int y) {
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
