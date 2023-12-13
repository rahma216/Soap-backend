package com.deepak.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@WebService(name = "scrapingProcessor")
public interface scraping {

    @WebMethod
    @WebResult(name = "response")
    scrapingResponse processScraping(
            @WebParam(name = "labelle") String labelle,
            @WebParam(name = "accidents") int accidents,
            @WebParam(name = "tues") int tues,
            @WebParam(name = "blesses") int blesses
    );


    @GET
    @Path("/getData")
    @WebResult(name = "response")
    List<Item> getData();


}
