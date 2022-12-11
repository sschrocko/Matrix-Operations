import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.*;

class CreateMatrix {
  private int vertical;
  private int horizontal;
  private int element;
  private int[][] matrix;
  private String matrixName;

  public CreateMatrix() {
    
  }
  
  Scanner input = new Scanner(System.in);
  
  public void dimensions() {
    System.out.print("Enter the vertical size of the matrix: ");
    vertical = input.nextInt();
    input.nextLine();
    System.out.print("Enter the horizontal size of the matrix: ");
    horizontal = input.nextInt();
    input.nextLine();
    System.out.println("");
  }

  public void inputElements() {
    int[][] mat = new int[vertical][horizontal];
    for (int y = 0; y < vertical; y++) {
      for (int x = 0; x < horizontal; x++) {
        System.out.print("Enter a number (" + x + ", " + y +"): ");
        element = input.nextInt();
        input.nextLine();
        mat[y][x] = element;
      }
    }
    System.out.println("\n");
    matrix = mat;
  }
  
  public String toString(int[][] matrix, boolean withDimensions, boolean withBars) {
    StringBuilder builder = new StringBuilder();
    if (withDimensions) {
      builder.append(vertical);
      builder.append("\n");
      builder.append(horizontal);
      builder.append("\n");
    }
    for (int y = 0; y < vertical; y++) {
      if (withBars) {
        builder.append("| ");
      }
      for (int x = 0; x < horizontal; x++) {
        builder.append(matrix[y][x]);
        builder.append(" ");
      }
      if (withBars) {
        builder.append("|\n");
      } else {
        builder.append("\n");
      }
    }
    return builder.toString();
  }

  public void saveMatrix() {
    System.out.println("Save this matrix? (1 for yes, 2 for no)");

    if (input.nextInt() == 1) {
      try {
        input.nextLine();
        System.out.print("Name your matrix: ");
        matrixName = input.nextLine();
        File myFile = new File(matrixName + ".txt");
        if (myFile.createNewFile()) {
          System.out.println("File has been created!");
        } 
        FileWriter myWriter1 = new FileWriter(myFile, true);
        myWriter1.write(toString(matrix, true, false));
        File myMatrices = new File("myMatrices.txt");
        FileWriter myWriter2 = new FileWriter(myMatrices, true);
        myWriter2.write(matrixName + "\n");
        myWriter1.close();
        myWriter2.close();
      }

      catch (IOException error) {
        System.out.println("There was an error: ");
        System.out.print(error);
      }
    }
  }
  
  public void displayMatrix() {
    System.out.println(toString(matrix, false, true));
  }
  public int getVertical() {
    return vertical;
  }
  public int getHorizontal() {
    return horizontal;
  }
  public String getMatrixName() {
    return matrixName;
  }
  public int[][] getMatrix() {
    return matrix;
  }

}