/* 
LeetCode problem #624 solution
Link : https://leetcode.com/problems/maximum-distance-in-arrays/
 */

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MaxDist{
    public static int maxDistance(List<List<Integer>> arrays){
        int res = 0;
        int currMax = arrays.getFirst().getLast();
        int currMin = arrays.getFirst().getFirst();
        
        for(int i=1; i<arrays.size(); i++){
            res = Math.max(res, Math.max(Math.abs(currMax - arrays.get(i).getFirst()), 
                                Math.abs(arrays.get(i).getLast() - currMin)));
            currMax = Math.max(arrays.get(i).getLast(), currMax);
            currMin = Math.min(arrays.get(i).getFirst(), currMin);
        }
        return res;
    }
    
    public static void main(String[] args){
        int x, y, z, res;
        List<List<Integer>> arrays = new ArrayList<>();
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("\nEnter the number of arrays : ");
            x = sc.nextInt();
            for(int i=0; i<x; i++){
                List<Integer> arr = new ArrayList<>();
                System.out.print(String.format("\nEnter the size of array #%d : ", i+1));
                y = sc.nextInt();
                System.out.print(String.format("\nEnter the elements of array #%d : ", i+1));
                for(int j=0; j<y; j++){
                    z = sc.nextInt();
                    arr.add(z);
                }
                arrays.add(arr);
            }
        }
        res = maxDistance(arrays);
        System.out.println(String.format("\nMaximum distance : %d", res));
    }
}
