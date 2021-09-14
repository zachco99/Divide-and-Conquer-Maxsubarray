import java.util.*;
public class Main {
    //final

    public static void main(String[] args) {
        // write your code here
        int[] array = {2,-3,1,7,9,10,-5};

        System.out.println(maxFromSplit(array,0, array.length-1));
        int i=0;
        do{
            i++;
        }while(i<5);

    }

    public static int maxFromMid(int [] array){

        int mid = array.length/2;
        int leftsum=Integer.MIN_VALUE;
        int sum = 0;

        for(int i=mid;i>=0;i--){
            int num=array[i];
            sum+=num;
            if(sum>leftsum) leftsum = sum;
            //else break;
        }

        int rightsum = Integer.MIN_VALUE;
        sum = 0;
        for(int i=mid+1;i< array.length;i++){
            int num=array[i];
            sum+=num;
            if(sum>rightsum)rightsum=sum;
            else break;
        }

        return Math.max(leftsum,Math.max(rightsum,(leftsum+rightsum)));
    }

    public static int maxFromSplit(int [] array, int firstIndex, int lastIndex){
        if(firstIndex==lastIndex)return array[firstIndex];

        int midpoint = (firstIndex+lastIndex)/2;
        int maxLeft = maxFromSplit(array,firstIndex,midpoint);
        int maxRight = maxFromSplit(array,midpoint+1,lastIndex);
        int maxFromMid = maxFromMid(array);
        return Math.max(maxLeft,Math.max(maxRight,maxFromMid));
    }

}
