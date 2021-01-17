package parser;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class StringSource {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
    }

    public boolean hasNext() {
        return pos < data.length();
    }

    public char next() {
        return data.charAt(pos++);
    }

    public ParseException error(final String message) {
        return new ParseException(pos + ": " + message);
    }


}

