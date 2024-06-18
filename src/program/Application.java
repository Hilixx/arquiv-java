package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Products;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pathString = "C:\\Users\\MSI Queiroz\\OneDrive\\Área de Trabalho\\foldesCsv\\itens.txt";
		File path = new File(pathString);
		String folderStrg =  path.getParent();
		boolean success = new File(folderStrg + "//out").mkdir();
		
		List<Products> productsList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(pathString))) {
			String line = br.readLine();
			while (line != null) {
				String[] newList = line.split(",");
				System.out.println(newList);
				line = br.readLine();

				int price = Integer.parseInt(newList[2]);
				double quantity = Double.parseDouble(newList[1]);
				Products product = new Products(newList[0], quantity, price);
				productsList.add(product);

			}
		} catch (IOException e) {
			System.out.println("erro" + e);
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(folderStrg + "//out//sumary.txt", true))) {
				
			for(Products product : productsList) {
				bw.write(product.getName() + "," + product.totalPrice());
				bw.newLine();
				
			}
			System.out.println("Arquivo Criado/Alterado");

		} catch (IOException e) {
			System.out.println("errp: " + e);
		}

		sc.close();
	}

}
