import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;


public class SQLQuestions {
    private static final ArrayList<String> questionList = new ArrayList<>();
    private static final ArrayList<String> answerList = new ArrayList<>();

    public static void main( String args[] ) {

        Statement stmt = null;
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:Questions.db");

        String sql2 = "SELECT * FROM QA";

        try {
            Connection c = ds.getConnection();
            stmt = c.createStatement();
//            String sql = "CREATE TABLE QA " +
//                    " (Questions           TEXT    NOT NULL, " +
//                    " Answers           TEXT    NOT NULL) ";

            System.out.println("Connected.");

            ResultSet rs = stmt.executeQuery(sql2);
            while(rs.next()){
                String ques = rs.getString("Questions");
                String Ans = rs.getString("Answers");
                questionList.add(ques);
                answerList.add(Ans);

                System.out.println(getRandQuestion());
            }
            rs.close();
            stmt.close();
            c.close();

        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("operation done");
    }

    public static String getRandQuestion(){
        Random rand = new Random();
        int randIndex = rand.nextInt(questionList.size());
        String randQuestion = questionList.get(randIndex);
        return randQuestion;
    }

}
