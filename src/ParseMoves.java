import parser.BaseParser;
import parser.ParseException;
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

    public void apply(int axis, int place, boolean isOpposite) {
        cube.move(axis, place);
        if (isOpposite) {
            cube.move(axis, place);
            cube.move(axis, place);
        }
    }

    public void readMoves() throws IllegalArgumentException {
        nextChar();
        while (!eof()) {
            skipWhiteSpace();
            int[] params = getParams(ch);
            nextChar();
            int axis = params[0];
            int place = params[1];
            boolean isOpposite = false;

            if (test('\'')) {
                isOpposite = true;
            }
            apply(axis, place, isOpposite);
            skipWhiteSpace();

            StringBuilder s = new StringBuilder();
            if (copyInteger(s)) {
                int x = Integer.parseInt(s.toString()) - 1;
                for (int i = 0; i < x; i++) {
                    apply(axis, place, isOpposite);
                }
            }
        }
    }
}
