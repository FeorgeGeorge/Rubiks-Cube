public class Cube {
    Piece[] content;

    public Cube() {
        content = new Piece[26];
        int index = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 && y == 0 && z == 0) {
                        continue;
                    }
                    Color[] colors = new Color[3];
                    switch (x) {
                        case(1): colors[0] = Color.O; break;
                        case(-1): colors[0] = Color.R; break;
                        case(0): colors[0] = Color.NoC; break;
                    }

                    switch (y) {
                        case(1): colors[1] = Color.B; break;
                        case(-1): colors[1] = Color.G; break;
                        case(0): colors[1] = Color.NoC; break;
                    }

                    switch (z) {
                        case(1): colors[2] = Color.W; break;
                        case(-1): colors[2] = Color.Y; break;
                        case(0): colors[2] = Color.NoC; break;
                    }
                        content[index] = new Piece(new int[] {x,y,z}, colors);
                    index += 1;
                }
            }
        }
    }

    public void move(int axis, int side) {
        for (Piece x: content) {
            if (x.getCoords()[axis] == side) {
                x.rotateBy(axis);
            }
        }
    }

    @Override
    public String toString() {
        String[][] top = new String[3][3];
        String[][] bottom = new String[3][3];
        String[][] right = new String[3][3];
        String[][] left = new String[3][3];
        String[][] front = new String[3][3];
        String[][] back = new String[3][3];

        // read through the cube
        for (Piece piece: content) {
            int[] coords = piece.getCoords();
            Color[] colors = piece.getColors();
            int x = coords[0];
            int y = coords[1];
            int z = coords[2];

            switch (z) {
                case (1):
                    top[y+1][x+1] = colors[2].toString(); break;
                case (-1): bottom[1-y][x+1] = colors[2].toString(); break;
            }

            switch (y) {
                case(1): front[1-z][x+1] = colors[1].toString(); break;
                case(-1): back[1-z][1-x] = colors[1].toString(); break;
            }

            switch (x) {
                case(1): right[1-z][1-y] = colors[0].toString(); break;
                case(-1): left[1-z][y+1] = colors[0].toString(); break;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (String[] list : top) {
            StringBuilder line = new StringBuilder(" ".repeat(3));
            for (String s : list) {
                line.append(s);
            }
            line.append("\n");
            answer.append(line);
        }

        // start saving the string.
        String[][][] sides = new String[][][] {left, front, right, back};

        for (int i = 0; i < 3; i++) {
            StringBuilder line = new StringBuilder();
            for (String[][] side : sides) {
                for (int j = 0; j < 3; j++) {
                    line.append(side[i][j]);
                }
            }
            line.append("\n");
            answer.append(line);
        }

        for (String[] list : bottom) {
            StringBuilder line = new StringBuilder(" ".repeat(3));
            for (String s : list) {
                line.append(s);
            }
            line.append("\n");
            answer.append(line);
        }

        return answer.toString();
    }
}
