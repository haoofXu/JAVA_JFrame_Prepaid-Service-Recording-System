

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class Stdout {

    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE = Locale.US;

    private static PrintWriter out;

    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
        }
        catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }

    private Stdout() { }

    public static void close() {
        out.close();
    }

    public static void println() {
        out.println();
    }

    public static void println(Object x) {
        out.println(x);
    }

    public static void println(boolean x) {
        out.println(x);
    }

    public static void println(double x) {
        out.println(x);
    }
    public static void println(int x) {
        out.println(x);
    }

    public static void print() {
        out.flush();
    }
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }

    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }

    public static void print(double x) {
        out.print(x);
        out.flush();
    }

    public static void print(int x) {
        out.print(x);
        out.flush();
    }
}