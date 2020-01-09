public class ONotation {
    /*
    This code is intended to dhow how small changes shorten the run time.
    We will write three versions of the same code with increasing efficiency
    We will run each function 10^7 times and record how many milliseconds it takes to complete
     */
    public static void main(String[] args) {
        int [] arr = new int[]{1,3,5,6,1,4,5,7,8,9,1,2,3,4};
        long t; int searchedValue=1;
        int p=7;
        t = System.currentTimeMillis();
        for(int i=0;i<Math.pow(10,p);i++){
            int index1 = findInArray1(arr,searchedValue);
        }
        System.out.println("version 1 takes "+(System.currentTimeMillis()-t)+" seconds");
        t = System.currentTimeMillis();
        for(int i=0;i<Math.pow(10,p);i++){
            int index1 = findInArray2(arr,searchedValue);
        }
        System.out.println("version 2 takes "+(System.currentTimeMillis()-t)+" seconds");
        t = System.currentTimeMillis();
        for(int i=0;i<Math.pow(10,p);i++){
            int index3 = findInArray3(arr,searchedValue);
        }
        System.out.println("version 3 takes "+(System.currentTimeMillis()-t)+" seconds");
    }

    //version 1: searches until the last index.
    //if value appears multiple times, the last appeared index will be returned.
    private static int findInArray1(int [] arr, int value){
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                index=i;
            }
        }
        return index;
    }

    //version 2: searches until the last index.
    //as soon as the value is found, the index is returned in the NEXT iteration.
    private static int findInArray2(int [] arr, int value){
        int index=-1;
        for(int i=0;i<arr.length&&index==-1;i++){
            if(arr[i]==value){
                index=i;
            }
        }
        return index;
    }

    //version 3: searches until the last index.
    //as soon as the value is found, the index is returned immediately.
    private static int findInArray3(int [] arr, int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;//immediately
            }
        }
        //if the code can run to here, this means that the array does not contain the value.
        return -1;
    }
}
