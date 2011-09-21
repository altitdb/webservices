package br.com.altieres;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Security;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.Constants;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.soap.SOAPConstants;
import org.xml.sax.SAXException;

public class Client {

    public static void main(String[] args) throws MalformedURLException, ServiceException, SAXException, AxisFault {
        String envelope = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<S:Header/>"
                + "<S:Body>"
                + "<ns2:soma xmlns:ns2=\"http://altieres.com.br/\">"
                + "<x>1</x>"
                + "<y>2</y>"
                + "</ns2:soma>"
                + "</S:Body>"
                + "</S:Envelope>";

        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\altitdb\\Documents\\keystore-client.jks");

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.keyStore", "C:\\Users\\altitdb\\Documents\\altieres.pfx");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");

        URL soapURL = new URL("https://localhost:8181/WebServiceSoapAppSecureClientCert/CalculadoraService");
        Service s = new Service();
        Call call = (Call) s.createCall();
        call.setTargetEndpointAddress(soapURL);
        SOAPEnvelope env = new SOAPEnvelope(new ByteArrayInputStream(envelope.getBytes()));

        System.out.println(call.invoke(env));
    }
}
