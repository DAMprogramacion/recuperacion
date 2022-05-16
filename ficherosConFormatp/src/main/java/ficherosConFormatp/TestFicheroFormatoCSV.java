package ficherosConFormatp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TestFicheroFormatoCSV {
	public static void main(String[] args) {
		
		
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("introduce la extensión del fichero");
			String extension =  sc.nextLine();
			String path = String.format("FICHEROS/companies.%s", extension);
			int contador = 0;
			List<Company> list = Helper.getListCompany(path);
			for (Company company : list) {
				System.out.println(company);
				contador++;
				if (contador % 10 == 0) {
					System.err.println("Pulsa una tecla para continuar");
					sc.nextLine();
				}
			}
			//list.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
