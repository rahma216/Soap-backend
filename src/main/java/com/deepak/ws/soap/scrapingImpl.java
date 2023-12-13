package com.deepak.ws.soap;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;
@WebService(endpointInterface = "com.deepak.ws.soap.scraping")
public class scrapingImpl implements scraping {

	@Override
	public scrapingResponse processScraping(String labelle, int accidents, int tues, int blesses) {
		scrapingResponse scrapingResponse = new scrapingResponse();

		scrapingResponse.setResult(true);

		return scrapingResponse;
	}

	@Override
	public List<Item> getData() {

		List<Item> items = new ArrayList<>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("C:/Users/Acer/Downloads/cause2022.xml"));

			NodeList nodeList = document.getElementsByTagName("item");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);

				Item item = new Item();
				item.setLabelle(element.getElementsByTagName("labelle").item(0).getTextContent());
				item.setAccidents(Integer.parseInt(element.getElementsByTagName("accidents").item(0).getTextContent()));
				item.setTues(Integer.parseInt(element.getElementsByTagName("tues").item(0).getTextContent()));
				item.setBlesses(Integer.parseInt(element.getElementsByTagName("blesses").item(0).getTextContent()));

				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return items;
	}
}

