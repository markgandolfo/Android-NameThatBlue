package com.nametheblue;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	static ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Product> activeChoices = new ArrayList<Product>();
	ArrayList<Integer> usedProducts = new ArrayList<Integer>();
	private Random randomGenerator;
	private int score = 0;
	int correctChoiceIndex;
	int choiceOneIndex, choiceTwoIndex, randomColorIndex;
	
	public Game() {
		randomGenerator = new Random();
		
		loadProducts();
		
		choiceOneIndex = randomGenerator.nextInt(products.size());
		choiceTwoIndex = randomGenerator.nextInt(products.size()); 
		
		while(choiceOneIndex == choiceTwoIndex) {
			choiceTwoIndex = randomGenerator.nextInt(products.size());
		}
		
		// Grab two active choices 
		activeChoices.add(products.get(choiceOneIndex));
		activeChoices.add(products.get(choiceTwoIndex));

		usedProducts.add(choiceOneIndex);
		usedProducts.add(choiceTwoIndex);
		
		// Get the correct choice
		correctChoiceIndex = randomGenerator.nextInt(2);
	}

	public ArrayList<Product> getchoices() {
		return activeChoices;
	}
	
	public Product getCorrectChoice() {
		return products.get(correctChoiceIndex);
	}
	
	public void checkAnswer(int answer) {
		if(answer == correctChoiceIndex) {
			score++;
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public int getProductCount() {
		return products.size();
	}
	
	private void loadProducts() {
		products.add(new Product("Aston Martin", "#004f32"));
        products.add(new Product("Audi", "#e21d38"));
        products.add(new Product("BMW", "#3399cc"));
        products.add(new Product("Bugatti", "#be0030"));
        products.add(new Product("Citro‘n", "#d9152e"));
        products.add(new Product("Daihatsu", "#ff0000"));
        products.add(new Product("Ferrari", "#fff200"));
        products.add(new Product("Ford", "#1F97D0"));
        products.add(new Product("Holden", "#ec1c2e"));
        products.add(new Product("Honda", "#e11428"));
        products.add(new Product("Hyundai", "#006faf"));
        products.add(new Product("Isuzu", "#ff0000"));
        products.add(new Product("Jeep", "#485f2b"));
        products.add(new Product("Lada", "#0060a9"));
        products.add(new Product("Lamborghini", "#f9ce5c"));
        products.add(new Product("Land Rover", "#008948"));
        products.add(new Product("Maserati", "#0c2e59"));
        products.add(new Product("Mazda", "#0080c5"));
        products.add(new Product("Mitsubishi", "#ea0033"));
        products.add(new Product("Nissan", "#c71444"));
        products.add(new Product("Opel", "#fbbf0c"));
        products.add(new Product("Peugeot", "#0d224a"));
        products.add(new Product("Proton", "#ffbd00"));
        products.add(new Product("Renault", "#fdb515"));
        products.add(new Product("SEAT", "#e53125"));
        products.add(new Product("Skoda", "#42bd3b"));
        products.add(new Product("Subaru", "#004489"));
        products.add(new Product("Suzuki", "#e31b31"));
        products.add(new Product("Toyota", "#ff0000"));
        products.add(new Product("Volkswagen", "#1077b9"));
        products.add(new Product("Volvo", "#0d3896"));
	}
}
