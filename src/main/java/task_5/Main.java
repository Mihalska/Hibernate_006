package task_5;



import task_5.entity.Author;
import org.jboss.logging.Logger;

import java.util.List;


public class Main {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

//____________________________________________________________________
//        List<Author> authorList = ah.getAuthorList("%sh%");
//
//        for (Author author : authorList) {
//            System.out.println(author.getId() + " " + author.getName() + " " + author.getLastName());
//        }
//____________________________________________________________________
 //       ah.deleteCriteria("%mon%");

//_____________________________________________________________________
        ah.deleteCriteriaLogic("%le%","%sh%", "Letyn" );
//_____________________________________________________________________
    }

}

