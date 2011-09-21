/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altieres;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author altitdb
 */
public class ClientRest {

    public static void main(String[] args) throws JAXBException, MalformedURLException, IOException {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/WebServiceRestAppNotSecure/").build());
		
                System.out.println("SOMA: " + service.path("calculadora/soma/1-2").accept(MediaType.TEXT_XML).get(String.class));
                System.out.println("SUBTRAÇÃO: " + service.path("calculadora/subtracao/10-5").accept(MediaType.TEXT_XML).get(String.class));
    }
}
