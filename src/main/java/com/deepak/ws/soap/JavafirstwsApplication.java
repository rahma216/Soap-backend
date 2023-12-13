package com.deepak.ws.soap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.List;


@SpringBootApplication
public class JavafirstwsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavafirstwsApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Specify the path to the XML file
		System.setProperty("server.port", "8081");
		String xmlFilePath = "C:/Users/Acer/Downloads/cause2022.xml";

		// Read data from the XML file and send it as a SOAP request
		processXmlData(xmlFilePath);
	}

	private void processXmlData(String xmlFilePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(xmlFilePath));

			NodeList items = document.getElementsByTagName("item");

			// Create an instance of PaymentProcessorImpl
			scrapingImpl processScraping = new scrapingImpl();

			for (int i = 0; i < items.getLength(); i++) {
				Element item = (Element) items.item(i);
				String labelle = item.getElementsByTagName("labelle").item(0).getTextContent();
				int accidents = Integer.parseInt(item.getElementsByTagName("accidents").item(0).getTextContent());
				int tues = Integer.parseInt(item.getElementsByTagName("tues").item(0).getTextContent());
				int blesses = Integer.parseInt(item.getElementsByTagName("blesses").item(0).getTextContent());

				// Send the data as a SOAP request
				// Send the data as a SOAP request
				scrapingResponse response = processScraping.processScraping(labelle, accidents, tues, blesses);
				System.out.println("SOAP Response: " + response.isResult());
				List<Item> response1 = processScraping.getData();
				System.out.println("SOAP Response: " + response1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
