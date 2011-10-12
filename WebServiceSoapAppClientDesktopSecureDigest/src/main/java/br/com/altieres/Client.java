/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altieres;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

/**
 *
 * @author altitdb
 */
public class Client {

    public static void main(String[] args) throws AxisFault, XMLStreamException {
        ServiceClient serviceClient = new ServiceClient();
        serviceClient.setTargetEPR(
            new EndpointReference("http://localhost:8080/WebServiceSoapAppSecureDigest/CalculadoraService"));
        serviceClient.getOptions().setAction("urn:soma");

        HttpTransportProperties.Authenticator authenticator = new HttpTransportProperties.Authenticator();
        authenticator.setUsername("altieres");
        authenticator.setPassword("altieres");

        serviceClient.getOptions().setProperty(HTTPConstants.AUTHENTICATE, authenticator);

        OMElement payload = Client.getXml(1, 2);

        OMElement e = serviceClient.sendReceive(payload);
        System.out.println(e.toStringWithConsume());
    }

    public static OMElement getXml(Integer x, Integer y) throws XMLStreamException {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://altieres.com.br/", "ns2");
        OMElement method = fac.createOMElement("soma", omNs);
        QName x1 = new QName("x");
        QName y1 = new QName("y");
        OMElement value1 = fac.createOMElement(x1);
        OMElement value2 = fac.createOMElement(y1);
        value1.addChild(fac.createOMText(value1, x.toString()));
        value2.addChild(fac.createOMText(value2, y.toString()));
        method.addChild(value1);
        method.addChild(value2);
        return method;
    }
}
