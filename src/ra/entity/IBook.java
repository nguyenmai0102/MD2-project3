package ra.entity;

import java.util.ArrayList;
import java.util.Scanner;

public interface IBook {
    final String File_Author = "C:\\Users\\Dell\\IdeaProjects\\MD2_PRIOJECT3\\src\\Author.txt ";
    final String File_Book = " C:\\Users\\Dell\\IdeaProjects\\MD2_PRIOJECT3\\src\\book.txt ";
    void inputData();

    void inputData(Scanner sc);

    void displayData();

    static ArrayList<Author> getData() {

        return null;
    }


    void insertData();
}
