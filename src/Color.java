public enum Color {
    R, W, Y, B, O, G, NoC;

    @Override
    public String toString() {
        if (this == NoC) {
            return "N";
        }
        else {return super.toString();}
    }
}
