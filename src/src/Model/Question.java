package Model;

public class Question {
    private final String myQuestion;
    private final String myAnswer;
    private final int myDifficulty;

    public Question(final int theDifficulty, final String theQuestion, final String theAnswer){
        myDifficulty = theDifficulty;
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }

    public String getMyQuestion() {
        return myQuestion;
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public int getMyDifficulty() {
        return myDifficulty;
    }

    @Override
    public String toString() {
        return ("diff: "+this.getMyDifficulty()+
                " question: "+ this.getMyQuestion() +
                " answer: "+ this.getMyAnswer());
    }
}
