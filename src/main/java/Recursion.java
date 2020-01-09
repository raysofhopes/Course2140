import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        // 1
        char [] greet ={'H','e','l','l','o'};
        char [] aidMe = greet;aidMe[3] ='p';
        aidMe[4] ='!';
        System.out.println(greet);

        // 2
        int [] evens ={0, 2, 4, 6};  // Place A
        int [] weirdo = evens;  // Place B
        int i;
        for (i = 2; i >= 0; i--)
            weirdo[i] = 3 * evens[i] - weirdo[i+1];// Place C
        weirdo = new int[ 1 ];
        weirdo[0] = -1;  // Place D
        for (i = 0; i < 4; i++)
            System.out.println( evens[i] );

        //4
        int [] arr =null;
        int res1 = sumArray(arr);
        arr = new int[4];
        int res2 = sumArray(arr);
        arr[0]=3;
        arr[1]=4;
        int res3 = sumArray(arr);
        arr[0]=4;arr[1]=1;arr[2]=6;arr[3]=3;
        int res4 = sumArray(arr);
        System.out.println(res1+", "+res2+", "+res3+", "+res4);

        //5: This is a bit difficult to catch!
        Student myArgument = new Student( "Dr. Cameron", 1 );
        myHelperMethod( myArgument );
        System.out.println( myArgument.getName());
        //but you could change what is already stored in the object
        myChangerMethod( myArgument);
        System.out.println( myArgument.getName() );

        // 6
        System.out.println("Press a key+enter to continue to the third output - Program is supposed to crash now!");
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        Recursion r = new Recursion();
        r.callMe(0);
    }

    public static int exp(int x, int m) {

        int result;
        if (m == 1)
            result = x;
        else
            result = x * exp(x,m-1);
        return result;
    } // end exp


    public static void myHelperMethod(Student helperParameter){
        helperParameter = new Student( "Dr. Matheson", 7 );
    } // end myHelperMethod
    public static void myChangerMethod(Student helperParameter){
        helperParameter.changeName("Dr. Akcora");
    }

    private void callMe(int count){
        System.out.println(count);
        callMe(++count);
    }
    public static int sumArray( int[] nums )
    {   // return the sum of
        // nums[pos] + nums[pos+1] + ... + nums[nums.length-1]
        if(nums==null||nums.length==0) return -1;
        return sumArray( nums, 0 );
    }

    private static int sumArray( int[] nums, int pos )
    {
        int result = 0;
        if ( pos < nums.length )
            result = nums[pos] + sumArray( nums, pos+1 );
        return result;
    }
}
