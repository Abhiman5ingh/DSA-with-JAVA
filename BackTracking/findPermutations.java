package BackTracking;

public class findPermutations {
    public static void findPermu(String str, String ans, int l)
    {
        if(ans.length() == l){              // also remove 'l' from the program, then the condi for printing will be str.length()==0
                System.out.print(ans+" ");
                return;
            }
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            findPermu(newStr,ans+curr,l);
        }
    }
    public static void main(String args[]){
        String str="123";
        int l = str.length();
        findPermu(str, "", l);
    }
}
