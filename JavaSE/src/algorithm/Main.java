package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len=in.nextInt();
        Integer [] arr = new Integer[len];
        for(int i = 0; i< arr.length; i++){
            arr[i] = in.nextInt();
        }
         Arrays.sort(arr, new Comparator<Integer>() {

             @Override
             public int compare(Integer o1, Integer o2) {
                 return o2-o1;
             }
         });

        for (int i = 0;i <arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }

}