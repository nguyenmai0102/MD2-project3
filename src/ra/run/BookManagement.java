package ra.run;
import ra.entity.Author;
import ra.entity.AuthorMethod;
import ra.entity.Book;
import ra.entity.BookMethod;
import java.util.ArrayList;
import java.util.Scanner;


public class BookManagement {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("\n+----------------------------------------------------------+");
            System.out.println("|                   QUẢN LÝ CỬA HÀNG SÁCH                  |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    1. Quản lý tác giả.                   |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    2. Quản lý sách.                      |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    3. Thoát.                             |");
            System.out.println("+----------------------------------------------------------+\n");
            int choice=checkChoice(1,3);
            switch (choice) {
                case 1:
                    authorManagement();
                    break;
                case 2:
                    bookManagement();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
    public static void authorManagement() {
        boolean outCase = true;
        do {
            System.out.println("\n\n+----------------------------------------------------------+");
            System.out.println("|                       QUẢN LÝ TÁC GIẢ                    |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|             1. Danh sách tác giả.                        |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|             2. Thêm các tác giả.                         |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|             3. Cập nhật thông tin tác giả.               |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|             4. Cập nhật trạng thái tác giả.              |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|             5. Thoát.                                    |");
            System.out.println("+----------------------------------------------------------+\n");

            int choice = checkChoice(1,5);

            switch (choice) {
                case 1:
                    AuthorMethod.showlistauthor();
                    break;
                case 2:
                    AuthorMethod.addNewAuthor(sc);
                    break;
                case 3:
                    AuthorMethod.editAuthor(sc);
                    break;
                case 4:
                    AuthorMethod.updateStatusAuthor(sc);
                    break;
                case 5:
                    outCase = false;
                    break;
            }
        } while (outCase);
    }
    public static void bookManagement() {
        boolean outCase = true;
        do {
            System.out.println("\n\n+-----------------------------------------------------+");
            System.out.println("|                  QUẢN LÝ SÁCH                        |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   1. Danh sách sách.                                 |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   2. Thêm các sách.                                  |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   3. Cập nhật thông tin sách.                        |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   4. Cập nhật trạng thái sách.                       |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   5. Tính lợi nhuận sách.                            |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   6. Sắp xếp sách theo giá bán tăng dần.             |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   7. Tìm kiếm sách theo tên sách, tên tác giả.       |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   8. Bán sách.                                       |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|   9.Thoát.                                           |");
            System.out.println("+------------------------------------------------------+\n");

            int choice = checkChoice(1,9);

            switch (choice) {
                case 1:
                    BookMethod.showlistBook();
                    break;
                case 2:
                    BookMethod.addNewBook(sc);
                    break;
                case 3:
                    BookMethod.editBook(sc);
                    break;
                case 4:
                    BookMethod.updateStatusBook(sc);
                    break;
                case 5:
                    BookMethod.profitBook();
                    break;
                case 6:
                    BookMethod.arrangePriceBook();
                    break;
                case 7:
                    BookMethod.searchBook(sc);
                    break;
                case 8:
                    BookMethod.saleBook(sc);
                    break;
                case 9:
                    outCase=false;
                    break;
            }
        } while (outCase);

    }
    public static int checkChoice(int a, int b){
        int choice = 0;
        while (choice<a||choice>b) {
            try {
                System.out.printf("Chọn từ \"%d- %d\" để tiếp tục:\n ",a,b);
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập sai hãy hãy nhập lại.");
            }
        }
        return choice;
    }

}

