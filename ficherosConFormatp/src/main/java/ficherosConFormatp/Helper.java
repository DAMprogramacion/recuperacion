package ficherosConFormatp;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Helper {
	//
	public static List<Company> getListCompany(String path) throws IOException, ParserConfigurationException, SAXException {
		
		List<Company> list = new ArrayList<Company>();
		Reader in = Files.newBufferedReader(Paths.get(path));
		String extension = path.split("\\.")[1];
		switch (extension) {
		case "csv":
			Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
			for (CSVRecord record : records)
				list.add(new Company(record.get(0), record.get(1), 
		    		record.get(2), record.get(3)));
			break;
		case "json":	
			list = 	new Gson().fromJson(in, new TypeToken<List<Company>>() {}.getType());
			break;
		case "xml" :
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc =  dBuilder.parse(new File(path));
	        NodeList nList = doc.getElementsByTagName("company");
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	        	 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        		 Element eElement = (Element) nNode;
	        		 String name = eElement.getElementsByTagName("name").item(0).getTextContent();
	        		 String sector = eElement.getElementsByTagName("sector").item(0).getTextContent();
	        		 String symbol = eElement.getElementsByTagName("symbol").item(0).getTextContent();
	        		 String cap = eElement.getElementsByTagName("cap").item(0).getTextContent();
	        	  	 list.add(new Company(name, sector, symbol, cap));
	        	 }
	        } 
			break;
		default:
			//name,sector,symbol,cap
			break;
		}
		return list;
		
		
	}
	
	
}
