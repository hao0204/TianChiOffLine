package com.shichaohao.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import com.shichaohao.model.Result;
import com.shichaohao.model.User;

public class FileOperate {
	
	static HashSet<User> readItemUserBehaviorFile(String time){
		File file = new File("item_user_behavior.csv");
		HashSet<User> hashSet = null;
		try {
			Scanner input = new Scanner(file);
			hashSet = new HashSet<User>();
			while(input.hasNextLine()){
				String[] temp = input.nextLine().split(",");
				if (temp[5].compareTo(time) > 0)
					hashSet.add(new User(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]));
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return hashSet;
	}
	
	static ArrayList<Result> readResult(String fileName){
		File pFile = new File(fileName);
		Scanner inputPreFile;
		ArrayList<Result> predictResult = null;
		try {
			inputPreFile = new Scanner(pFile);
			predictResult = new ArrayList<Result>();
			inputPreFile.nextLine();
			while(inputPreFile.hasNextLine()){
				String[] temp = inputPreFile.nextLine().split(",");
				predictResult.add(new Result(temp[0], temp[1]));
			}
			inputPreFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return predictResult;
	}
	
	static void writeToPredictResultCSV(ArrayList<Result> predictResult){
		String dirName = String.valueOf(System.currentTimeMillis());
		File dir = new File(dirName);
		if (!dir.exists())
			dir.mkdirs();
		File file = new File(dirName + "/tianchi_mobile_recommendation_predict.csv");
		if (!file.exists()){
			try {
				file.createNewFile();
				PrintWriter output = new PrintWriter(file);
				output.println("user_id,item_id");
				for (Result r: predictResult){
					output.print(r.getUser_id() + ",");
					output.println(r.getItem_id());
				}
				output.close();
				System.out.println("完成预测结果输出！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
