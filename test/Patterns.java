
public class Patterns {

    public static void main(String[] args) {
        int n = 4; // Number of rows
        pattern1(n);
        System.out.println();
        pattern2(n);
        System.out.println();
        pattern3(n);
        System.out.println();
        pattern4(n);
        System.out.println();
        pattern5(n);
        System.out.println();
        pattern6(n);
        System.out.println();
        pattern7(n);
        System.out.println();
        pattern8(n);
        System.out.println();
        pattern9(n);
        System.out.println();
        pattern10(n);
        System.out.println();
        pattern11(n);
        System.out.println();
        pattern12(n);
        System.out.println();
        pattern13(n);
        System.out.println();
        pattern14(n);
        System.out.println();
        pattern15(n);
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >= row; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print(col + 1 + " ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int stars = row;
            if (row > n) {
                stars = 2 * n - row;
            }

            for (int col = 1; col <= stars; col++) {
                System.out.print("* ");

            }
            System.out.println();

        }

    }

    static void pattern5(int n) {
        for (int row = 1; row <= n; row++) {
            // Print spaces
            for (int s = 1; s <= n - row; s++) {
                System.out.print(" ");
            }
            // Print stars
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            // Print spaces
            for (int s = 1; s <= n - row; s++) {
                System.out.print(" ");
            }
            // Print stars
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = 1; row <= n; row++) {
            // Print spaces
            for (int s = 1; s <= row; s++) {
                System.out.print(" ");
            }
            // Print stars
            for (int star = 1; star <= 2 * (n - row) - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern7(int n) {
        int start = 0;
        for (int row = 1; row <= n; row++) {
            if (row % 2 == 0) {
                start = 1;
            } else {
                start = 0;
            }

            for (int col = 1; col <= row; col++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    static void pattern8(int n) {
        char count = 'A';
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    static void pattern9(int n) {
        for (int row = 1; row <= n; row++) {
            char ch = 'A';

            for (int col = 1; col <= row; col++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    static void pattern10(int n) {
        for (int row = 1; row <= n; row++) {
            char ch = (char) ('A' + row - 1);

            for (int col = 1; col <= row; col++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    static void pattern11(int n) {
        for (int row = 1; row <= n; row++) {
            // Print leading spaces
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            // Print characters in increasing and then decreasing order
            char ch = 'A';
            int breakpoint = row;
            for (int col = 1; col <= 2 * row - 1; col++) {
                System.out.print(ch);
                if (col < breakpoint) {
                    ch++;
                } else {
                    ch--;
                }
            }
            // Print trailing spaces (optional, for symmetry)
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pattern12(int n) {
        int initialSpaces = 0;

        for (int row = 1; row <= n; row++) {

            // left stars
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("*");
            }

            // middle spaces
            for (int spaces = 0; spaces < initialSpaces; spaces++) {
                System.out.print(" ");
            }

            // right stars
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("*");
            }

            System.out.println();
            initialSpaces += 2;
        }
    }

    static void pattern13(int n) {
         for(int row=1;row<=2*n-1;row++){
            int stars=row;
            if(row>n) stars=2*n-row;
            int spaces=2*(n-stars);

            //stars
            for(int col=1; col<=stars; col++) {
                System.out.print("*");
            }

            //spaces
            for(int col=1; col<=spaces; col++) {
                System.out.print(" ");
            }

            //stars
            for(int col=1; col<=stars; col++) {
                System.out.print("*");
            }

            System.out.println();
         }
    }

    static void pattern14(int n) {
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==0 || j==0 || i==n-1 || j==n-1) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
      }
    }

    static void pattern15(int n){
      for(int i=0;i<2*n-1;i++){
        for(int j=0;j<2*n-1;j++){
            int top=i;
            int left=j;
            int right=2*n-2-j;
            int bottom=2*n-2-i;
            int min=Math.min(Math.min(top,bottom),Math.min(left,right));
            System.out.print((n-min) + " ");
        }
        System.out.println();
      }
    }

}


