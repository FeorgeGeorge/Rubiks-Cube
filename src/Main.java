public class Main {

    public static void main(String[] args) {
        String mainString = "Dx";
        Cube myCube = new Cube();
        System.out.println(myCube);
        ParseMoves parser = new ParseMoves(myCube, mainString);
        parser.readMoves();
        System.out.println(parser.cube);
    }
}
