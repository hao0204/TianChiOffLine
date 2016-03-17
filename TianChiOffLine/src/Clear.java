import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import com.shichaohao.model.Result;
import com.shichaohao.model.User;

public class Clear {

	public static void main(String[] args) throws FileNotFoundException {
		File pFile = new File("tianchi_mobile_recommendation_predict.csv");
		Scanner inputPreFile = new Scanner(pFile);
		ArrayList<Result> predictResult = new ArrayList<Result>();
		inputPreFile.nextLine();
		while(inputPreFile.hasNextLine()){
			String[] temp = inputPreFile.nextLine().split(",");
			predictResult.add(new Result(temp[0], temp[1]));
		}
		inputPreFile.close();
		
		File f = new File("item_user_behavior.csv");
		Scanner input = new Scanner(f);
		HashSet<User> u = new HashSet<User>();
		while(input.hasNextLine()){
			String[] temp = input.nextLine().split(",");
			if (temp[5].compareTo("2014-12-12 00") > 0)
				u.add(new User(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]));
		}
		input.close();
		for (int i = predictResult.size()-1; i>=0; --i){
			Result r = predictResult.get(i);
			for (User user: u){
				if (user.getUser_id().equals(r.getUser_id())){
					if (user.getItem_id().equals(r.getItem_id())){
						if (user.getBehavior_type().equals("4")){
							predictResult.remove(i);
							break;
						}
					}
				}
			}
		}
		
		File tt = new File("temp.csv");
		PrintWriter p = new PrintWriter(tt);
		p.println("user_id,item_id");
		for (Result r: predictResult){
			p.print(r.getUser_id() + ",");
			p.println(r.getItem_id());
		}
		p.close();
	}

}
