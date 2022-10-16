package ra.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Author implements IBook, Serializable {

    private int authorId;
    private String authorName;
    private boolean authorStatus;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean authorStatus) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorStatus = authorStatus;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isAuthorStatus() {
        return authorStatus;
    }

    public void setAuthorStatus(boolean authorStatus) {
        this.authorStatus = authorStatus;
    }

    public void inputData() {                                                                         //inputdata
        Scanner sc = new Scanner(System.in);
        this.authorId = AuthorMethod.authorList.size() + 1;
        this.authorName = checkinputName(sc);
        System.out.println("Nhập trạng thái tác giả:");
        this.authorStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void inputData(Scanner sc) {

    }

    public static String checkinputName(Scanner sc) {
        String authorName;
        do {
            System.out.println("Tên tác giả: ");
            authorName = sc.nextLine();
            if (authorName.trim().length() != 0) {
                if (authorName.trim().length() > 6 && authorName.trim().length() < 50) {
                    boolean check = true;
                    for (Author author : AuthorMethod.authorList) {
                        if (author.getAuthorName().equals(authorName.trim())) {
                            check = false;
                        }
                    }
                    if (!check) {
                        System.out.println("Tên bị trùng.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Tên tác giả gồm từ 6-50 ký tự.");
                }
            } else {
                System.out.println("Không để trống.");
            }
        } while (true);
        return authorName;
    }

//    @Override
//    public String toString() {
//        return authorId +";"+authorName + ";" +authorStatus ;
//    }

    public void displayData() {                                                                       // display
        System.out.println("authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorStatus=" + authorStatus);
    }
    public static void insertData(ArrayList<Author> authors) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            file = new File(File_Author);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(authors);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getData() {
        ArrayList<Author> authorList = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(File_Author);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            authorList= (ArrayList<Author>) ois.readObject();

//            Author author;
//            while (true){
//                author = (Author) ois.readObject();
//                if (author==null){
//                    break;
//                }
//                authorList.add(author);
//            }
//        }catch(EOFException eof){

        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        return authorList;
    }

    @Override
    public void insertData() {

    }

}
