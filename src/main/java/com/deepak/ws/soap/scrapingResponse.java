package com.deepak.ws.soap;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "scrapingResponse")
public class scrapingResponse {

    private boolean result;

    public boolean isResult() {
        return result;
    }

    // Use setResult(boolean result) for setting the result
    public void setResult(boolean result) {
        this.result = result;
    }
}
