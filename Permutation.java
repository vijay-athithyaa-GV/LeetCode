import java.util.*;

class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<List<Integer>> res = new ArrayList<>();
    System.out.println("Enter the Size:");
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
     permutation(0,arr,res);
    for(int i=0;i<res.size();i++){
        for(int j=0;j<res.get(i).size();j++){
            System.out.print(res.get(i).get(j)+" ");
        }
        System.out.println();
    }
    }
    public static void permutation(int ind,int[] arr,List<List<Integer>> res){
        List<Integer> ds = new ArrayList<>();
        int n = arr.length;
        if(ind == n){
            for(int i=0;i<n;i++)
                ds.add(arr[i]);
            res.add(ds);
        }
        for(int i=ind;i<n;i++){
            swap(i,ind,arr);
            permutation(ind+1,arr,res);
            swap(i,ind,arr);
        }
    }
    public static void swap(int i,int ind,int[] arr){
        int tem = arr[i];
        arr[i] = arr[ind];
        arr[ind] = tem;
    }
}

