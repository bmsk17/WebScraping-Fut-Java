/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bernardo
 */
public class Ep1 {
    public static void main(String[] args) throws IOException {

        String valor = "google.com";
        System.out.println(valor);

    try {
        java.awt.Desktop.getDesktop().browse( new java.net.URI( "http://www." + valor  ) );
    } catch (URISyntaxException ex) {
       ;
    }
    }
    
}
