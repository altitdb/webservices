/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altieres;

import java.io.ByteArrayInputStream;
import java.net.URL;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPEnvelope;

/**
 *
 * @author altitdb
 */
public class Client {

    public static void main(String[] args) {
        try {
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                    + "<S:Header/>"
                    + "<S:Body>"
                    + "<ns2:soma xmlns:ns2=\"http://altieres.com.br/\">"
                    + "<x>1</x>"
                    + "<y>1</y>"
                    + "</ns2:soma>"
                    + "</S:Body>"
                    + "</S:Envelope>";

            URL soapURL = new URL("http://localhost:8080/WebServiceSoapAppNotSecure/CalculadoraService?wsdl");
            //Instancio um novo serviço com as configurações de KeyStore e TrustStore
            Service s = new Service();
            //Abro a chamada ao Serviço
            Call call = (Call) s.createCall();
            //Defino as configurações do para chamar o serviço
            call.setTargetEndpointAddress(soapURL);
            //Crio um envelope para enviar
            SOAPEnvelope env = new SOAPEnvelope(new ByteArrayInputStream(xml.getBytes()));
            //Invoco o serviço do WebService e recebo a respota
            SOAPEnvelope resposta = call.invoke(env);
            System.out.println(resposta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
