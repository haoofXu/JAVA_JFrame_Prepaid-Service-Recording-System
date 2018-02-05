

import java.io.*;
import java.util.*;

public final class In {
	String[] accounts = new String [1000];
	int sizeD = 0;
	BufferedReader infileD;

    public In(String name) throws IOException {
    	sizeD = 0;
    	File file = new File(name);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);

        	infileD = new BufferedReader (new FileReader (file));
        	for (int lines = 0 ; lines < 1000 ; lines++)
        	{
        		accounts [lines] = infileD.readLine ();
        	    if (accounts [lines] == null)
        		break;
        	    sizeD++;
        	}
        	infileD.close ();
        }
    }
    public String[] readAllStrings() {
        String[] acc = new String[sizeD];
        for(int i=0;i<sizeD;i++){
        	acc[i] = accounts[i];
            //System.out.print(acc[i]+" ");
        }
        return acc;
    }
    
    public void close() throws IOException{
    	infileD.close();
    }
}
