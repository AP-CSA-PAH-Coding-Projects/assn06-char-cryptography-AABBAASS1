package apcsa.githubtrack;

// Implement your CString class here

public class CString{
    private char[] str;
    public CString(CString other) {
    this.str = new char[other.str.length];
     for (int i = 0; i < other.str.length; i++) {
        this.str[i] = other.str[i];
    }
}
    public CString(String n){
        this.str = new char[n.length()];
        for (int i = 0; i < n.length(); i++) {
                this.str[i] = n.charAt(i);
            }

    }
    public CString(char[] n){
        this.str = n;
        

    }
    public void reverse() {
    // 1. Create the temporary storage
    char[] temp = new char[str.length];
    int count = 0;

    for (int i = str.length - 1; i >= 0; i--) {
        temp[count] = str[i];
        count++;
    }

    this.str = temp;
}
    public void sortAscending(){
        for (int j = 0; j < str.length-1; j++){
            int min = j;
            for (int i = j+1; i < str.length; i++) {
                if (str[i] < str[min]){

                    min = i;
                }
                

            }
            if (min != j){
                char st = str[j];
                str[j] = str[min];
                str[min] = st;





            }






        }




    }
    public void sortDescending(){
        for (int i = 1; i < str.length; i++) {
           int j = i;
           while(j > 0 && str[j-1] < str[j]){
                char st = str[j-1];
                str[j-1] = str[j];
                str[j] = st;
            j = j - 1;
           }
           


            
        }
        



System.out.println(str);

    }
public char[] getChar(){

            return  str;
        }


}
