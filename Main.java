import java.util.Scanner;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) {
    boolean doAgain = true;
    int userInput;
    Scanner input = new Scanner(System.in);
    CreateMatrix create = new CreateMatrix();
    DisplayMatrix display = new DisplayMatrix();
    MatrixOperations op = new MatrixOperations();
    while (doAgain) {
      System.out.println("MATRIX CALCULATOR\n\n");
      System.out.println("Menu:");
      System.out.println("1. Create a matrix");
      System.out.println("2. Display all matrices");
      System.out.println("3. Add matrices");
      System.out.println("4. Multiply matrices");
      System.out.println("5. Quit");
      System.out.print("Enter 1 - 5: ");
      userInput = input.nextInt();
      switch (userInput) {
        case 1:
          create.dimensions();
          create.inputElements();
          create.displayMatrix();
          create.saveMatrix();
          break;
        case 2:
          try {
            display.displayAll();
          }
          catch(FileNotFoundException error) {
            System.out.print(display.getFileName() + " not found");
            System.out.println(error);
          }
          break;
        case 3:
          try {
            op.inputTwoMatrices();
            op.doSum();
          }
          catch(FileNotFoundException error) {
            System.out.print(display.getFileName() + " not found");
            System.out.println(error);
          }
          break;
        case 4:
          try {
            op.inputTwoMatrices();
            op.doProduct();
          }
          catch(FileNotFoundException error) {
            System.out.print(display.getFileName() + " not found");
            System.out.println(error);
          }
          break;
        case 5:
          doAgain = false;
          break;
        }
      }
      
    }
}