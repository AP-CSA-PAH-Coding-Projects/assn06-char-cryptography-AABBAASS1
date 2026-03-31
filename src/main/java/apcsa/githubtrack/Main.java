package apcsa.githubtrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("src/main/resources/MonsterData.txt"));
           
 
        List<String> monsterNameData = new ArrayList<>();

        List<Integer> healthData = new ArrayList<>();
         while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                monsterNameData.add(line);
            }
 */
// Implement your main application logic here

public class Main {
    
    public static void rotate(CString[] arr, int d) {
    int n = arr.length;
    d = d % n; 
    
    CString[] temp = new CString[d];
    for (int i = 0; i < d; i++) {
        temp[i] = arr[i];
    }

    for (int i = d; i < n; i++) {
        arr[i - d] = arr[i];
    }

    for (int i = 0; i < d; i++) {
        arr[n - d + i] = temp[i];
    }
}
                
            


            
        
    public static void main(String[] args) throws FileNotFoundException{
        // Code execution starts here
        Scanner scanner = new Scanner(new File("src/main/resources/secretMessage.txt"));
        String lin = "";
        while (scanner.hasNext()) {
                String line = scanner.nextLine();
                
                lin = line;
            }
        String[] words = lin.split("\\s+");
        CString[] cwords = new CString[words.length];
        for (int i = 0; i < words.length; i++) {
            cwords[i] = new CString(words[i]);

            
        }

        for (int i = 0; i < cwords.length; i++) {
          
            cwords[i] = CStringUtil.decrypt(cwords[i]);
            

            
        }
        int max  = 0;
        for (int i = 0; i < cwords.length; i++) {
            for (int j = 0; j < cwords[i].getChar().length; j++) {
                if (max< (int) cwords[i].getChar()[j]){
                    max = (int) cwords[i].getChar()[j];
                }
                
            }
            
        }
        rotate(cwords, max-60);
        for (CString elem : cwords) {
            System.out.println(elem.getChar());
            
        }
        
        
           

        
        
        // You can call other methods or create objects here
       
    }
}
