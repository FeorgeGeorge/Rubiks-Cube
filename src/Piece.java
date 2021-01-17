public class Piece {
    private int[] coords; // [x,y,z]   -1 <= x,y,z <= 1
    private Color[] colors;

    public Piece(int[] coords, Color[] colors) {
        this.coords = coords;
        this.colors = colors;
    }

    public int[] getCoords() {
        return coords;
    }

    public Color[] getColors() {
        return colors;
    }

    public void rotateBy(int axis) { // 0 for X, 1 for Y, 2 for Z
        // swap colors
        Color hold = colors[(axis + 1) % 3];
        colors[(axis + 1) % 3] = colors[(axis + 2) % 3];
        colors[(axis + 2) % 3] = hold;

        // apply rotation on coordinates;
        int c = coords[(axis + 1) % 3];
        coords[(axis + 1) % 3] = -coords[(axis + 2) % 3];
        coords[(axis + 2) % 3] = c;
        /* todo: the rotation directions depend on axis.
            Down and Top moves are affected;
        */
    }


}
