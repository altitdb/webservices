/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altieres;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author altitdb
 */
@WebService(name="CalculadoraService")
@SOAPBinding(style= Style.RPC)
public interface CalculadoraService {

    @WebMethod(operationName="soma")
    public Integer soma(@WebParam(name = "x") Integer x, @WebParam(name = "y") Integer y);

    @WebMethod(operationName="subtracao")
    public Integer subtracao(@WebParam(name = "x") Integer x, @WebParam(name = "y") Integer y);
}
