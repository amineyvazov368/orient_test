package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDao();

        List<Category> categoryList = categoryDao.getAllCategory();

        categoryList.forEach(System.out::println);



        Scanner sc = new Scanner(System.in);
        for (int i =0; i<2; i++){
            System.out.print("Category name: ");
            String name = sc.nextLine().trim();
            System.out.print("Description: ");
            String description = sc.nextLine().trim();
            categoryDao.createCategory(name, description);
        }
       Category category=  categoryDao.getCategoryById("4");
        System.out.println(category);

        Category category1 = categoryDao.deleteCategory("15");
        System.out.println(category1);
        Category  category2 = categoryDao.updateCategory("Amin","aminin xeyallari","14");
        System.out.println(category2);
    }
}
