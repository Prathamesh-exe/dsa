public class PrintTrapezium {

    static void printPattern(int n) {
        int lterm = 1;
        int rterm = n * n + 1;
        for (int i = n; i > 0; i--) {
            // Print spaces
            for (int space = n; space > i; space--)
                System.out.print("  ");
            // Print left side numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(lterm);
                System.out.print("*");
                lterm++;
            }
            // Print right side numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(rterm);
                if (j < i)
                    System.out.print("*");
                rterm++;
            }
            rterm = rterm - 2 * (i - 1) - 1;
            System.out.println();
        }
    }


    static void printPattern2(int n) {
    int lterm = 1;
    int rterm = n * n + 1;

    for (int row = 1; row <= n; row++) {

        int count = n - row + 1;

        // spaces
        for (int space = 1; space < row; space++)
            System.out.print("  ");

        // left numbers
        for (int j = 1; j <= count; j++) {
            System.out.print(lterm + "*");
            lterm++;
        }

        // right numbers
        for (int j = 1; j <= count; j++) {
            System.out.print(rterm);
            if (j < count) System.out.print("*");
            rterm++;
        }

        // adjust right term
        rterm = rterm - 2 * (count - 1) - 1;
        System.out.println();
    }
}

    public static void main(String[] args) {
            printPattern(3);
            System.out.println();
            printPattern(4);
            System.out.println();
            printPattern2(3);
            System.out.println();
            printPattern2(4);
    }
}
