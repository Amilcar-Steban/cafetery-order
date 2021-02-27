
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main {
    
    public static double[] ages;
    public static double averageChanges;
    
    //metodo burbuja
    public static double[] bubbleSort(){
        int changes = 0;
        int turns = 0;

        for (int i = 1; i < ages.length ; i++) {

            for (int j = 0; j < ages.length-i; j++) {
                if (ages[j]>ages[j+1]) {
                    double temp = ages[j];
                    ages[j] = ages[j+1];
                    ages[j+1] = temp;
                    changes++;
                }
            }
            turns++;
            
        }
        averageChanges = changes/turns;
        
        return ages; 
    }
    
    //code
    public static void main(String[] args) throws IOException {
        
        
        PrintWriter bw = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\tA continuacion pegue el archivo :\n");
        
        
        
        ArrayList<Double> Averages = new ArrayList<>();
        ArrayList<double[]> orderedAges = new ArrayList<>();
	
        
        String line = br.readLine();
        int quantity = Integer.parseInt(line);
        String aux;
        String[] array;
        
        //
        for (int i = 0; i < quantity ;i++) {
            aux = br.readLine();
            array = aux.split(" ");
            int length = array.length;
            ages = new double[length];

            for(int j=0; j<ages.length; j++) {
                ages[j] = Double.parseDouble(array[j]);
            }

            orderedAges.add(bubbleSort());
            Averages.add(averageChanges);
        }
        br.close();
        
        
        
        System.out.println("\n\tEl texto diligenciado anteriomente fue modificado de la siguiente forma: \n");

        for(int i=0; i<orderedAges.size(); i++) {
            String ages = "";
            String space="";

            for (int j = 0; j < orderedAges.get(i).length; j++) {
                ages += space + orderedAges.get(i)[j];
                space=" ";
                
            }
            
            bw.println(String.format("%.2f",Averages.get(i))+"-"+ages);
        }
        bw.close();
    }
    
    
}
