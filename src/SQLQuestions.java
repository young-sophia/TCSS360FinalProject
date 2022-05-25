package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;


public class SQLQuestions {
    private static final ArrayList<Question> questionList = new ArrayList<>();
    private static final ArrayList<String> answerList = new ArrayList<>();
    public static void main( String args[] ) {

//        Statement stmt = null;
//        SQLiteDataSource ds = new SQLiteDataSource();
//        ds.setUrl("jdbc:sqlite:Questions.db");
//
//        String sql2 = "SELECT * FROM QA";
//
//        try {
//            Connection c = ds.getConnection();
//            stmt = c.createStatement();
////            String sql = "CREATE TABLE QA " +
////                    " (Questions           TEXT    NOT NULL, " +
////                    " Answers           TEXT    NOT NULL) ";
//
//            System.out.println("Connected.");
//
//            ResultSet rs = stmt.executeQuery(sql2);
//            while(rs.next()){
//                int diff = rs.getInt("Difficulty");
//                String ques = rs.getString("Questions");
//                String Ans = rs.getString("Answers");
////                questionList.add(ques);
//                answerList.add(Ans);
//                    questionList.add(new Question(diff, ques, Ans));
//
//
//            }
//            rs.close();
//            stmt.close();
//            c.close();
//
//        }catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//        }
        for(int i = 0; i < 5; i++) {
            System.out.println(selectDiff(2));
        }
        System.out.println("operation done");
    }
    public static Question selectDiff(final int theDifficulty){
        Random ran = new Random();
        String sql = "SELECT * FROM QA WHERE Difficulty = ?";
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:Questions.db");
        try {
            Connection conn = ds.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            // set the value
            pstmt.setInt(1,theDifficulty);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                int diff = rs.getInt("Difficulty");
                String ques = rs.getString("Questions");
                String Ans = rs.getString("Answers");
                questionList.add(new Question(diff, ques, Ans));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return questionList.get(ran.nextInt(questionList.size()));
    }

}
