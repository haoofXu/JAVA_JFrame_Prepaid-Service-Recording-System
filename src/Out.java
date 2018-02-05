
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

public class Out {

    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE = Locale.US;

    private PrintWriter out;

    public Out(String filename) {
        try {
            OutputStream os = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(os, CHARSET_NAME);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        out.close();
    }

    public void println() {
        out.println();
    }

    public void println(Object x) {
        out.println(x);
    }

}
