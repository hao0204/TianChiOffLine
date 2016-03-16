import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

import com.shichaohao.model.Result;

public class Find {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("item_user_behavior.csv");
		Scanner input = new Scanner(file);
		HashSet<Result> resultSet = new HashSet<Result>();
		while(input.hasNextLine()){
			String[] temp = input.nextLine().split(",");
			if ( (temp[2].equals("3") || temp[2].equals("2"))){
				if (temp[5].compareTo("2014-12-18 00") > 0){
					Result r = new Result(temp[0], temp[1]);
					resultSet.add(r);
				}
			}
		}
		input.close();
		File outputFile = new File("tianchi_mobile_recommendation_predict.csv");
		PrintWriter output = new PrintWriter(outputFile);
		output.println("user_id,item_id");
		for (Result r: resultSet){
			output.print(r.getUser_id() + ",");
			output.println(r.getItem_id());
		}
		output.close();
	}
}
