package com.quest.ExceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;
//
public class ExceptionEg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            operations(sc);
        } catch (ArithmeticException e) {
            System.out.println("Error occurs in program.(Cannot divide a No. by zero.)");
        } catch (InputMismatchException e) {
            System.out.println("Error occurs in program:(Invalid input. Enter numeric values.)");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error occurs in program:( Please enter an index between 0 and 4.)");
        } catch (NullPointerException e) {
            System.out.println("Error occurs in program.(Trying to access Null value)");
        } finally {
            System.out.println("Exception handling is complete.");
        }
    }

    public static void operations(Scanner scanner)
            throws ArithmeticException, InputMismatchException, ArrayIndexOutOfBoundsException, NullPointerException {
        int[] array = {78, 98, 13, 33, 55};

        System.out.print("Enter the 1st no: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter the 2nd no: ");
        int n2 = scanner.nextInt();
        System.out.println("result after Division of n1 and n2 : " + n1 / n2);

        System.out.print("Enter an array index between (0 and 4): ");
        int index = scanner.nextInt();
        System.out.println("Value at index " + index + ": " + array[index]);
    }
}
