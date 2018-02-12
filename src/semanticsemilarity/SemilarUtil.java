package semanticsemilarity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 *
 * @author Luis
 */
public class SemilarUtil {

    public final int cantidad = 372;
    
    public final boolean[][] tMatriz={{true,true,false,false,false,false,false,false,true,false,false,false},
                                      {false,false,false,true,false,false,false,false,true,false,false,false},
                                      {true,false,false,true,false,false,false,false,true,false,false,false},
                                      {true,false,false,false,false,true,false,false,true,false,false,false},
                                      {true,false,false,false,false,true,false,false,true,false,false,false},
                                      {true,false,false,false,false,false,false,false,true,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {false,false,false,false,false,false,true,true,false,false,false,false},
                                      {false,false,false,false,false,false,true,true,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {false,false,false,false,false,false,true,true,false,false,false,false},
                                      {false,false,false,false,false,false,true,true,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {true,false,false,false,false,false,false,false,false,false,false,false},
                                      {true,false,false,false,false,false,false,false,false,false,false,false},
                                      {true,false,false,false,false,false,false,false,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {true,false,false,false,false,false,true,false,false,false,false,false},
                                      {true,false,false,false,false,false,true,false,false,false,false,false},
                                      {true,false,false,false,false,false,true,false,false,false,false,false},
                                      {false,false,true,false,false,false,false,false,false,false,false,false},
                                      {false,false,true,false,false,false,false,false,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {false,false,false,false,false,true,false,false,false,false,false,false},
                                      {false,false,false,false,false,false,false,false,false,true,false,false},
                                      {false,false,false,false,false,false,false,false,false,false,false,true},
                                      {false,false,false,false,false,false,false,false,false,false,false,true},
                                      {false,false,false,false,false,false,false,false,false,false,false,true}};
    
    public float cacluclarPrecision(float[][] matrizLSA){
        float resp=0;
        boolean [][] puntuacionLSA = calcularPuntuacion(matrizLSA);
        int tp =0;
        int tn =0;
        int fp =0;
        int fn =0;
        for(int i=0;i<31;i++){
            System.out.println("\n");
            for(int j=0;j<12;j++){
                if(puntuacionLSA[i][j] == tMatriz[i][j] && tMatriz[i][j]== true){
                    tp++;
                }
                if(puntuacionLSA[i][j] == tMatriz[i][j] && tMatriz[i][j]== false){
                    tn++;
                }
                if(puntuacionLSA[i][j] != tMatriz[i][j] && tMatriz[i][j]== false){
                    fp++;
                }
                if(puntuacionLSA[i][j] != tMatriz[i][j] && tMatriz[i][j]== true){
                    fn++;
                }
                if(puntuacionLSA[i][j] == true){
                    System.out.print("X"+" | ");
                }
                else{
                    System.out.print(""+" | ");
                }
            }
        }
        
        System.out.println();
        System.out.println("TP: "+tp);
        System.out.println("FN: "+fn);
        System.out.println("FP: "+fp);
        System.out.println("TN: "+tn);
        
        return (float)(tp+tn)/cantidad;
        
    }
    
    private static boolean[][] calcularPuntuacion(float[][] matrizLSA) {
        
        boolean[][] resp= new boolean[31][12];
        List<Float> aux = new ArrayList<Float>();
        
        for(int i=0;i<31;i++){
            aux.clear();
            for(int j=0;j<12;j++){
                aux.add(matrizLSA[i][j]);
            }
            Collections.sort(aux);
            aux=aux.subList(9, 12);
            for(int j=0;j<12;j++){
                if(aux.contains(matrizLSA[i][j]))
                    resp[i][j]=true;
                else
                    resp[i][j]=false;
            }
            
        }
        return resp;
    }
    
}
