public class PfQuestion {
    String question;
    String group;
    String rightAnswer;
    String userAnswer;

    public PfQuestion(String str) {
        this.question = str;
        this.group = "X";
        this.userAnswer = "X";
    }

    public boolean noAnswer() {
        return this.userAnswer.equals("X");
    }

    public int grade() {
        boolean flag = this.rightAnswer.equals(this.userAnswer);
        if(this.group.equals("B")) {
            if(flag) return 1;
            else return 0;
        } 
        else if (flag) return 2;
        else if(this.userAnswer.equals("B")) return 1;
        else return 0;
    }
}
