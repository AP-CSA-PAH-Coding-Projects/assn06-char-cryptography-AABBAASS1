package apcsa.githubtrack;

// Implement your CStringUtil class here
public final class CStringUtil {


   public static boolean isPalindrome(CString cstr) {
    if (cstr == null) return false;

    // 1. Create a "Cleaned" string (no spaces, lowercase)
    String raw = "";
    for (int i = 0; i < cstr.getChar().length; i++) {
        char c = cstr.getChar()[i];
        if (c != ' ') { // Skip spaces
            raw += Character.toLowerCase(c); // Force lowercase
        }
    }

    // 2. Compare the cleaned string to its reverse
    String reversed = "";
    for (int i = raw.length() - 1; i >= 0; i--) {
        reversed += raw.charAt(i);
    }

    return raw.equals(reversed);

}
public static int[] toNumerical(CString str, int offset){
int[] aray = new int[str.getChar().length];
for (int i = 0; i < str.getChar().length; i++ ){
    aray[i] = str.getChar()[i] + offset;


}

return aray;
}
public static int maxMirror(int[] str){
int[] work = str;
int[] rev = new int[work.length];
for (int i = work.length-1; i>= 0 ; i--){
rev[i]=work[work.length - 1 - i];


}
int n = rev.length;
    int max =0 ;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int count = 0;
            
            // We must ensure (i + count) and (j + count) don't go out of bounds
            while (i + count < n && j + count < n && work[i + count] == rev[j + count]) {
                count++;
            }
            
            // Update max if this match is the longest we've seen
            if (count > max) {
                max = count;
                System.out.println(max);
            }
        }
    }

return max;

}

public static int maxMirror(CString str) {
    int[] work = toNumerical(str, -100);
    int n = work.length;
    int max = 0;

    for (int i = 0; i < n; i++) {
        for (int j = n - 1; j >= 0; j--) {
            int count = 0;
            int p1 = i;
            int p2 = j;

            while (p1 < n && p2 >= 0 && work[p1] == work[p2]) {
                count++;
                p1++;
                p2--;
                
                if (count > max) {
                    max = count;
                }
            }
        }
    }
    return max;
}
public static int[] memeifyArray(int[] nums){

for (int i = 0 ; i < nums.length; i++){
    
    if(nums[i] == 6 && i != nums.length-1){
        for (int j =0; j < nums.length; j++){

            if ((nums[j] == 7 && j==0) || (nums[j] == 7 && !(nums[j-1] == 6))){

                int temp = nums[i+1];
                nums[i+1] = 7;
                nums[j] = temp;
                break;
            }
        }


    }




}


return nums;
}
public static boolean nestedSequence(CString outer, CString inner){
    inner.sortAscending();
    outer.sortAscending();
    int[] in = toNumerical(inner, -100);
    int[] out = toNumerical(outer, -100);
    int count = 0;
    if (in.length == 0 && out.length > 0) {
        return true;
    }
    for (int i = 0; i < out.length; i++) {
        if (i + in.length <= out.length){
        for (int j = 0; j < in.length;j++) {
            if (out[i+j] == in[i]){
                count++;
            }
            if (count == in.length-1){

            return true;
        }
            
        }
        count = 0;
    }
        if (count == in.length-1){

            return true;
        }
        
    }



return false;

}
public static CString decrypt(CString str){
int clumps = 0;
int[] arr = toNumerical(str, 0);
int cumpsnum = -1;
for (int i = 0; i < arr.length-1; i++) {
    if (cumpsnum == -1  || cumpsnum != arr[i]){
        if (arr[i] == arr[i+1]){

        clumps++;
        cumpsnum = arr[i];
        }
    }
    if(cumpsnum != arr[i]){
        cumpsnum = -1;
    }
}

for (int i = 0; i < arr.length; i++) {
    arr[i] = arr[i]-clumps;
    
}
int[] ret = new int[arr.length];
int count = 0;
for (int i = ret.length-1; i > 0; i--) {
    ret[count] = arr[i];
    count++;
    
}

char[] re = new char[arr.length];
    for (int i = 0; i < arr.length; i++) {
        int shiftedValue = arr[arr.length - 1 - i] - clumps;
        re[i] = (char) shiftedValue;
    }

    return new CString(re);
}

}
