/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

/**
 *
 * @author Bernardo
 */
public class NumFormat {
    
    public static void main(String[] args) {
        String cantos ="711-2";
        String ss = cantos.substring(2);
        int traco=0;
        for(int i=0;i<cantos.length();i++){
            if(cantos.substring(i,i+1).equals("-")){
            System.out.println("aaaaaaaaa :"+i);    
            traco=i;
            }
        }
        Double nCantosCasa = Double.parseDouble(cantos.substring(0,traco));
        Double nCantosVisitante = Double.parseDouble(cantos.substring(traco+1,cantos.length()));

        
        System.out.println(nCantosCasa+  "X "+nCantosVisitante+" --- "+ss);
    }
}
