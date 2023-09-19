
/**
 * Write a description of class CornerPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CornerPlayer extends Player {
    public CornerPlayer(int symbol, String name) {
        super(symbol, name);
    }

    @Override
    public void makeMove(Board board) {
        int size = board.getSize();
        // Attempt to fill the corners in order: bottom-left, bottom-right, top-left, top-right
        int[][] corners = {{0, 0}, {0, size - 1}, {size - 1, 0}, {size - 1, size - 1}};

        for (int[] corner : corners) {
            int col = corner[0];
            int row = corner[1];
            if (board.isOpen(col, row)) {
                board.fillPosition(col, row, symbol);
                break;
            }
        }
    }
}

