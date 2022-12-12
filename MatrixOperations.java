import java.util.Scanner;
import java.io.FileNotFoundException;

class MatrixOperations extends DisplayMatrix {
  public MatrixOperations() {
    super();
  }
  String m1Name;
  String m2Name;
  int[][] m1;
  int[][] m2;
  int vert;
  int horiz;
  int[][] resultMat;
  public void inputTwoMatrices() throws FileNotFoundException{
    Scanner matrixInput = new Scanner(System.in);
    System.out.print("Enter the name of the first matrix: ");
    m1Name = matrixInput.nextLine() + ".txt";
    m1 = readMatrix(m1Name);
    System.out.print("Enter the name of the second matrix: ");
    m2Name = matrixInput.nextLine() + ".txt";
    m2 = readMatrix(m2Name);
  }

  public void doSum() throws FileNotFoundException{
    if (m1.length != m2.length || m1[0].length != m2[0].length) {
      System.out.println("Matrices can not be added");
    } else {
      System.out.println(displayOne(m1, false, false) + "\n  +\n\n" + displayOne(m2, false, false) + "\n  =\n");
      System.out.println(displayOne(addMatrices(), false, false)); 
    }
  }
  
  public int[][] addMatrices() {
    vert = m1.length;
    horiz = m1[0].length;
    resultMat = new int[vert][horiz];
    for (int y = 0; y < vert; y++) {
      for (int x = 0; x < horiz; x++) {
        resultMat[y][x] = m1[y][x] + m2[y][x];
      }
    }
    return resultMat;
  }

  public void doProduct() throws FileNotFoundException{
    if (m1[0].length != m2.length) {
      System.out.println("Matrices can not be multiplied");
    } else {
      System.out.println(displayOne(m1, false, false) + "\n  *\n\n" + displayOne(m2, false, false) + "\n  =\n");
      System.out.println(displayOne(multiplyMatrices(), false, false)); 
    }
  }

  public int[][] multiplyMatrices() {
    vert = m1.length;
    horiz = m2[0].length;
    resultMat = new int[vert][horiz];
    for (int y = 0; y < vert; y++) {
      for (int x = 0; x < horiz; x++) {
        int temp = 0;
        for (int i = 0; i < m1[0].length; i++) {
          temp += m1[y][i] * m2[i][x];
        }
        resultMat[y][x] = temp;
      }
    }
    return resultMat;
  }
}