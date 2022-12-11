import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

class DisplayMatrix {
  public DisplayMatrix() {
    
  }
  String currentFile;
  public void displayAll() throws FileNotFoundException{
    File names = new File("myMatrices.txt");
    Scanner nameScanner = new Scanner(names);
    System.out.println("------------------------------\n");
    while (nameScanner.hasNext()) {
      currentFile = nameScanner.nextLine();
      System.out.println(displayOne(readMatrix(currentFile + ".txt"), true, true));
    }
    nameScanner.close();
  }
  

  public int[][] readMatrix(String fileName) throws FileNotFoundException{
    File matrixFile = new File(fileName);
    Scanner fileInput = new Scanner(matrixFile);
    int vert = fileInput.nextInt();
    fileInput.nextLine();
    int horiz = fileInput.nextInt();
    fileInput.nextLine();
    int[][] currentMat = new int[vert][horiz];
    for (int y = 0; y < vert; y++) {
      for (int x = 0; x < horiz; x++) {
        currentMat[y][x] = fileInput.nextInt();
      }
      fileInput.nextLine();
    }
    fileInput.close();
    return currentMat;
  }

  public String getFileName() {
    return currentFile;
  }
  
  public String displayOne(int[][] matrix, boolean withLine, boolean withName) throws FileNotFoundException{
    StringBuilder builder = new StringBuilder();
    if (withName) {
      builder.append("Matrix: ");
      builder.append(currentFile);
      builder.append("\n\n");
    }
    for (int y = 0; y < matrix.length; y++) {
      builder.append("| ");
      for (int x = 0; x < matrix[y].length; x++) {
        builder.append(matrix[y][x]);
        builder.append(" ");
      }
      builder.append("|\n");
    }
    if (withLine) {
      builder.append("\n\n------------------------------\n");
    }
    return builder.toString();
  }
}