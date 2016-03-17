import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {

	public static void main(String[] args) throws IOException {
		String dirName = String.valueOf(System.currentTimeMillis());
		File f = new File(dirName);
		if (!f.exists())
			f.mkdirs();
		File t = new File(dirName + "/tianchi_mobile_recommendation_predict.csv");
		if (!t.exists())
			t.createNewFile();
		PrintWriter p = new PrintWriter(t);
		p.println("ddd");
		p.close();
	}

}
