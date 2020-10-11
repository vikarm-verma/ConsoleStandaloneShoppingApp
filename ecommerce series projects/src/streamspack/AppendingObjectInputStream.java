package streamspack;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class AppendingObjectInputStream extends ObjectInputStream {

	  public AppendingObjectInputStream(InputStream in) throws IOException {
	    super(in);
	  }

	  @Override
	  protected void readStreamHeader() throws IOException {
	    // do not write a header, but reset:
	    // this line added after another question
	    // showed a problem with the original
	   // reset();
	  }

	}