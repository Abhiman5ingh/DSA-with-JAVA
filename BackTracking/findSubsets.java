package BackTracking;

public class findSubsets {
    public static void findsets(String str, String ans, int i)
    {
        if(i==str.length()){
            if(ans.length()==0){
                System.out.print("null ");
            }
            else{
                System.out.print(ans+" ");
            }
            return;
        }
        findsets(str,ans,i+1);  // No addition
        findsets(str,ans+str.charAt(i),i+1);  // Yes: Addition
    }
    public static void main(String args[]){
        String str="abc";
        findsets(str, "", 0);
    }
}
