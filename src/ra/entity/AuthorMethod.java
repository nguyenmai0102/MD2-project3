package ra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.entity.Author.*;
import static ra.entity.IBook.File_Author;
import static ra.entity.IBook.getData;

public class AuthorMethod {
    public static ArrayList<Author> authorList = new ArrayList<>();

    public static void showlistauthor() {                                        //1.show list author
        authorList = getData();
        for (Author author : authorList) {
            author.displayData();
        }
    }

    public static void addNewAuthor(Scanner sc) {
        int count;
        while (true) {
            try {
                System.out.println("Nhập số lượng muốn thêm.");
                count = Integer.parseInt(sc.nextLine());
                if (count > 0) {
                    break;
                } else {
                    System.out.println("Số lượng phải lớn hơn 0.");
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng.");
            }

        }
        for (int i = 0; i < count; i++) {
            Author author = new Author();
            System.out.printf("Tác giả thứ %d\n ", (i + 1));
            author.inputData();
            authorList.add(author);
        }
        insertData(authorList);

    }

    public static void editAuthor(Scanner sc) {
        authorList = getData();
        System.out.println("Nhập Id tác giả cần cập nhập: ");
        int inputId = Integer.parseInt(sc.nextLine());
        boolean check = true;
        for (Author author : authorList) {
            if (author.getAuthorId()==inputId){
                author.setAuthorName(checkinputName(sc));
                System.out.println("Trạng thái tác giả:");
                author.setAuthorStatus(Boolean.parseBoolean(sc.nextLine()));
                System.out.println("Cập nhập thành công.");
                check=true;
                break;
            }else {
                check=false;
            }
        }
        if (check){
            insertData(authorList);
        }else {
            System.out.println("Id không tồn tại.");
        }

    }
    public static void updateStatusAuthor(Scanner sc){
        getData();
        System.out.println("Nhập Id tác giả muốn cập nhập: ");
        int inputId = Integer.parseInt(sc.nextLine());
        for (Author author : authorList) {
            if (author.getAuthorId()==inputId){
                author.setAuthorStatus(!author.isAuthorStatus());
            }
        }
        insertData(authorList);
        System.out.println("Cập nhập thành công.");
    }
}