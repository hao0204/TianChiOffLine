import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import com.shichaohao.model.Item;
import com.shichaohao.model.User;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File userFile = new File("tianchi_fresh_comp_train_user.csv");
		File itemFile = new File("tianchi_fresh_comp_train_item.csv");
		HashSet<String> itemSet = new HashSet<String>();
		Scanner inputItem = new Scanner(itemFile);
		inputItem.nextLine();
		while(inputItem.hasNextLine()){
			String[] temp = inputItem.nextLine().split(",");
			Item item = new Item(temp[0], temp[1], temp[2]);
			itemSet.add(item.getItem_id());
		}
		inputItem.close();
		Scanner inputUser = new Scanner(userFile);
		inputUser.nextLine();
		ArrayList<User> userList = new ArrayList<User>();
		System.out.println("开始清理");
		while(inputUser.hasNextLine()){
			String[] temp = inputUser.nextLine().split(",");
			User user = new User(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
			if (itemSet.contains(user.getItem_id())){
				userList.add(user);
			}
		}
		inputUser.close();
		System.out.println("开始输出");
		File outFile = new File("item_user_behavior.csv");
		PrintWriter output = new PrintWriter(outFile);
		for (User u: userList){
			output.print(u.getUser_id() + ",");
			output.print(u.getItem_id() + ",");
			output.print(u.getBehavior_type() + ",");
			output.print(u.getUser_geohash() + ",");
			output.print(u.getItem_category() + ",");
			output.println(u.getTime());
		}
		output.close();
	}

}

//训练数据包含了抽样出来的一定量用户在一个月时间（11.18~12.18）之内的移动端行为数据（D），
//评分数据是这些用户在这个一个月之后的一天（12.19）对商品子集（P）的购买数据。
//参赛者要使用训练数据建立推荐模型，并输出用户在接下来一天对商品子集购买行为的预测结果。 
