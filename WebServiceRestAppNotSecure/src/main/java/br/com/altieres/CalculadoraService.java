/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altieres;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author altitdb
 */
@Path("/calculadora")
public class CalculadoraService {
    
    @Path("/soma/{valor1}-{valor2}")
    @GET
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_XML)
    public String soma(@PathParam("valor1") Integer valor1,
                    @PathParam("valor2") Integer valor2) {
        Integer total = valor1 + valor2;
        return total.toString();
    }
    @Path("/subtracao/{valor1}-{valor2}")
    @GET
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_XML)
    public String subtracao(@PathParam("valor1") Integer valor1,
                    @PathParam("valor2") Integer valor2) {
        Integer total = valor1 - valor2;
        return total.toString();
    }
}
