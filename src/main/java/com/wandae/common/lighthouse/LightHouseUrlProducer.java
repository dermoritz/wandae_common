package com.wandae.common.lighthouse;

import javax.enterprise.inject.Produces;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by moritz on 13.08.2015.
 */
public class LightHouseUrlProducer {

    private static final String LIGHTHOUSE_PROPERTY = "com.wandae.lighthouse";

    @Lighthouse
    @Produces
    public URL getLightHouseUrl(){
        String urlString = System.getProperty(LIGHTHOUSE_PROPERTY);
        if(urlString == null){
            throw new IllegalStateException("System property " + LIGHTHOUSE_PROPERTY + " not set. Please set a reachable lighthouse url.");
        }
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Value for Property " + LIGHTHOUSE_PROPERTY + " can't be parsed as urls value is: " + urlString);
        }
        return url;
    }
}
