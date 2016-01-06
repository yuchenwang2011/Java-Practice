import java.util.Arrays;

public class removeDuplicate {
   public int removeDuplicates(int[] num) {
     int size = 0;
     if(num.length == 0 || num == null) return 0;
     for (int i = 0; i< num.length; i++) {
       if (num[size] != num[i]) {
         size ++;
        num[size] = num[i];
       }
     }
     return size+1;
   }
   
   public static void main(String[] args) {
     removeDuplicate myRemove = new removeDuplicate();
     int[] testData = new int[]{1,2,3,4,4,4,5,5,5,5,5,6,6,6,6,7,7,7,7,8,8,9,9};
     int size = myRemove.removeDuplicates(testData);
     System.out.println("size is " + size);
     System.out.println("data now is " + Arrays.toString(testData));
    }
}

