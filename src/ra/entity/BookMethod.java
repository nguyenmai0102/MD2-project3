package ra.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static ra.entity.Book.*;

public class BookMethod {
    public static ArrayList<Book> bookList = new ArrayList<>();

    public static void showlistBook() {                                        //1.show list book
        bookList = getData();
        for (Book book : bookList) {
            book.displayData();
        }
    }

    public static void addNewBook(Scanner sc) {
        int count;
        while (true) {
            try {
                System.out.println("Nhập số lượng muốn thêm:");
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
            Book book = new Book();
            System.out.printf("Sách thứ %d\n ", (i + 1));
            book.inputData();
            bookList.add(book);
        }
        insertData(bookList);
    }

    public static void editBook(Scanner sc) {
        System.out.println("Nhập Id sách muốn cập nhập: ");
        String inputId = sc.nextLine();
        for (Book book : bookList) {
            if (book.getBookId().trim().equals(inputId.trim())) {
                System.out.println("Tên sách mới:");
                book.setBookName(pushBookName(sc));
                System.out.println("Giá nhập:");
                book.setImportPrice(pushBookPice(sc));
                System.out.println("Giá bán:");
                book.setExportPrice(pushExportBookPrice(sc, book.getImportPrice()));
                System.out.println("Số lượng:");
                book.setQuantity(pushBookQuantity(sc));
                System.out.println("Tiêu đề:");
                book.setTittle(sc.nextLine());
                System.out.println("Nội dung");
                book.setContent(sc.nextLine());
                System.out.println("Nhà xuất bản:");
                book.setPublishing(sc.nextLine());
                System.out.println("Trạng thái:");
                book.setBookStatus(Boolean.parseBoolean(sc.nextLine()));
                System.out.println("Tác giả:");
                book.setAuthorArrayList(pushAuthorbook(sc));
                System.out.println("Cập nhập thành công");
            } else {
                System.out.println("Id không tồn tại ");
            }
        }
    }

    public static void updateStatusBook(Scanner sc) {
        for (Book book : bookList) {
            if (book.getQuantity() > 0) {
                book.setBookStatus(true);
            } else {
                book.setBookStatus(false);
            }
        }
        System.out.println("Cập nhập thành công.");
    }

    public static void profitBook() {
        for (Book book : bookList) {
            book.calProfit();
        }
        System.out.println("Đã tính xong lợi nhuận");
    }

    public static void arrangePriceBook() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getExportPrice() > o2.getExportPrice()) {
                    return 1;
                } else if (o1.getExportPrice() == o2.getExportPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    public static void searchBook(Scanner sc) {
        System.out.println("Nhập tên sách hoặc tên tác giả. ");
        String inputSearch = sc.nextLine();
        for (Book book : bookList) {
            if (book.getBookId().equals(inputSearch.trim())) {
                book.displayData();
                break;
            }for (Author author : AuthorMethod.authorList) {
                if (author.getAuthorName().equals(inputSearch.trim())) {
                    book.displayData();
                }
            }
        }

    }
    public static void saleBook (Scanner sc){
        System.out.println("Nhập Id sách muốn bán:");
        String inputID = sc.nextLine();
        for (Book book : bookList) {
            if (book.getBookId().equals(inputID.trim())) {
                int quatity;
                do {
                    try {
                        System.out.println("Số lượng bán:");
                        quatity = Integer.parseInt(sc.nextLine());
                        if (quatity > 0 && quatity < book.getQuantity()) {
                            book.setQuantity(book.getQuantity() - quatity);
                            System.out.println("Bán thành công.");
                            break;
                        } else {
                            System.out.printf("Số lượng bán phải nhỏ hơn số lượng tồn kho(%d).\n", book.getQuantity());
                        }
                    } catch (Exception e) {
                        System.out.println("Sai định dạng");
                    }

                } while (true);


            }
        }
    }
}
