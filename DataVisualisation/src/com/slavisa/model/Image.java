package com.slavisa.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Image {

	private Integer[][] image;
	private ArrayList<Integer[][]> images;

	public void generateImage(int row, int col, String content) {
		
		
		images = new ArrayList<>();
		Scanner scanner = new Scanner(content);
		
		while (scanner.hasNextLine()) {
		
		  image = new Integer[row][col];	
		  String line = scanner.nextLine();
		  String[] items = line.split(",");
		  int index = 0;
		  
		  for(int i = 0; i < row; i++){
				for(int j = 0; j < col; j++){
					image[i][j] = Integer.parseInt(items[index++]);
				}
		  }
		  images.add(image);
		}
		scanner.close();		
	}
	public ArrayList<Integer[][]> getImages(){
		return images;
	}
}
