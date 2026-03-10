
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Book> listBooks = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        String msg = """
                Menu:
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách theo ID
                3. Thay đổi thông tin 1 cuốn sách theo ID
                4. Xuất danh sách sách
                5. Tìm Sách lập trình
                6. Lấy sách tối đa theo giá
                7. Tìm kiếm theo tác giả
                0. Thoát
                Chọn chức năng (0-7): """;
        int choice;
        do {
            System.out.print(msg);
            choice = Integer.parseInt(x.nextLine());
            switch (choice) {
                case 1 -> {
                    Book b = new Book();
                    b.input();
                    listBooks.add(b);
                }
                case 2 -> {
                    System.out.print("Nhập ID sách cần xóa: ");
                    int bookId = Integer.parseInt(x.nextLine());
                    Book find = listBooks.stream().filter(p -> p.getId() == bookId).findFirst().orElseThrow();
                    listBooks.remove(find);
                    System.out.println("Xóa thành công.");
                }
                case 3 -> {
                    System.out.print("Nhập ID sách cần sửa: ");
                    int bookId = Integer.parseInt(x.nextLine());
                    Book findBook = listBooks.stream().filter(p -> p.getId() == bookId).findFirst().orElseThrow();
                    System.out.print("Nhập title mới: ");
                    String newTitle = x.nextLine();
                    System.out.print("Nhập author mới: ");
                    String newAuthor = x.nextLine();
                    System.out.print("Nhập price mới: ");
                    long newPrice = Long.parseLong(x.nextLine());
                    findBook.setTitle(newTitle);
                    findBook.setAuthor(newAuthor);
                    findBook.setPrice(newPrice);
                    System.out.println("Sửa thành công.");
                }
                case 4 -> {
                    System.out.println("Danh sách các sách:");
                    listBooks.forEach(p -> p.output());
                }
                case 5 -> {
                    System.out.println("Danh sách sách lập trình:");
                    List<Book> list5 = listBooks.stream()
                            .filter(p -> p.getTitle().toLowerCase().contains("lập trình"))
                            .toList();
                    list5.forEach(p -> p.output());
                }
                case 6 -> {
                    long maxPrice = listBooks.stream()
                            .mapToLong(Book::getPrice)
                            .max()
                            .orElse(0);
                    System.out.println("Sách có giá cao nhất:");
                    listBooks.stream()
                            .filter(p -> p.getPrice() == maxPrice)
                            .forEach(p -> p.output());
                }
                case 7 -> {
                    System.out.print("Nhập tên tác giả cần tìm: ");
                    String authorName = x.nextLine().toLowerCase();
                    System.out.println("Kết quả tìm kiếm:");
                    listBooks.stream()
                            .filter(p -> p.getAuthor().toLowerCase().contains(authorName))
                            .forEach(p -> p.output());
                }
                case 0 ->
                    System.out.println("Thoát chương trình.");
                default ->
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

}
