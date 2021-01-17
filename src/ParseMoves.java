import parser.BaseParser;
import parser.StringSource;

public class ParseMoves extends BaseParser {
    Cube cube;

    final static int[] RIGHT = new int[]{0, 1};
    final static int[] LEFT = new int[]{0, -1};
    final static int[] FRONT = new int[]{1, 1};
    final static int[] BACK = new int[]{1, -1};
    final static int[] DOWN = new int[]{2, -1};
    final static int[] UP = new int[]{2, 1};

    private static int[] getParams(char symb) throws IllegalArgumentException {
        switch (symb) {
            case ('R'):
                return RIGHT;
            case ('L'):
                return LEFT;
            case ('F'):
                return FRONT;
            case ('B'):
                return BACK;
            case ('U'):
                return UP;
            case ('D'):
                return DOWN;
            default:
                throw new IllegalArgumentException("Not a command");
        }
    }

    public ParseMoves(Cube cube, String s) {
        super(new StringSource(s));
        this.cube = cube;
    }

    public void readMoves() {
        nextChar();
        while (!eof()) {
            skipWhiteSpace();
            try {
                int[] params = getParams(ch);
                int axis = params[0];
                int place = params[1];
                cube.move(axis, place);
                nextChar();
                if (test('\'')) {
                    cube.move(axis, place);
                    cube.move(axis, place);
                }
                skipWhiteSpace();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
