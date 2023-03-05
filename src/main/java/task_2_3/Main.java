package task_2_3;

import task_2_3.entity.Author;
import task_2_3.entity.Book;


public class Main {


    public static void main(String[] args) {

        BookHelper bh = new BookHelper();
        Book book = new Book();
 //------------------------------------------------------------------------
//         bh.deleteById(1); -видалення по id  (+);

//--------------------------------------------------------------------------
//        AuthorHelper ah = new AuthorHelper(); // оновлення даних (+) - завдання 2
//        ah.addAuthor1(null);

// ---------------- -видалення по автору----------------------------------------
        Author author = new AuthorHelper().getAuthorById(1);
        int result = new BookHelper().deleteByName(author);
        System.out.println("Видалили " + result+  " книжки(у) " +   author.getLastName() + " " + author.getName());
 //-----------------------------------------------------------------------------

    }

}