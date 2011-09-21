/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altieres;

import javax.jws.WebService;

/**
 *
 * @author altitdb
 */
@WebService(endpointInterface = "br.com.altieres.CalculadoraService", serviceName="CalculadoraService")
public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public Integer soma(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer subtracao(Integer x, Integer y) {
        return x - y;
    }
    
}

