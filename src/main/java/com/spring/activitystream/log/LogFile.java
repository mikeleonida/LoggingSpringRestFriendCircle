package com.spring.activitystream.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFile {
	private static String fileName = "UserControllerLogger.txt";
	
	public static void log(String message) {
		File file = new File(fileName);
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy h:mmaa");
			fr.append(message + " at " + formatter.format(date));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
