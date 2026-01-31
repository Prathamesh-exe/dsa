
public class Bitwise {
    public static void main(String[] args) {
        int a = 3; // 11101 in binary
        int b = 5; // 01111 in binary

        //swapping using XOR
        System.out.println("Before swapping: a = " + a + ", b = " + b);
        a = a ^ b; // Step 1
        b = a ^ b; // Step 2
        a = a ^ b; // Step 3
        System.out.println("After swapping: a = " + a + ", b = " + b);


        //check if number is power of two
        int num = 16;
        // A number is a power of two if it has exactly one bit set in its binary representation.
        if ((num & (num - 1)) == 0 && num > 0) {
            System.out.println(num + " is a power of two.");
        } else {
            System.out.println(num + " is not a power of two.");    
    }
        
    //count set bits in an integer
        int number = 29; // 11101 in binary
        int count = 0;
        while (number > 0) {
            count += (number & 1); // Increment count if the last bit is set
            number >>= 1; // Right shift to check the next bit
        }
        System.out.println("Number of set bits: " + count);

    //find the only non-repeating element in an array where every other element repeats twice
        int[] arr = {2, 3, 5, 4, 5, 3, 2};
        int result = 0;
        for (int val : arr) {
            result ^= val; // XORing all elements -> 0 ^2 ^3 ^5 ^4 ^5 ^3 ^2 = 4
        }
        System.out.println("The non-repeating element is: " + result);

        //get the ith bit of a number
        int number2 = 13; // 1101 in binary
        int i = 2;
        int ithBit = (number2 >> i) & 1; // Right shift to get the ith bit and AND with 1 to isolate it
        System.out.println("The " + i + "th bit of " + number2 + " is: " + ithBit);

        //set the ith bit of a number
        int number3 = 10; // 1010 in binary
        int j = 1;
        int setIthBit = number3 | (1 << j); // Left shift 1 by j to create a mask and OR with the number to set the jth bit
        System.out.println("Number after setting the " + j + "th bit of " + number3 + " is: " + setIthBit);
}
        
}
