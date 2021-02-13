public class PfQuestion {
    String question;
    String[] option;
    String group;
    private String rightAnswer;
    private String userAnswer;

    public PfQuestion(String strQ, String strA, String strB, String strC) {
        this.question = strQ;
        this.option = new String[] {strA, strB, strC};
        this.group = "X";
    }

    public void setGroup(String grp) {
        this.group = grp;
    }

    public void setRightAnswer(String ans) {
        this.rightAnswer = ans;
    }

    public void setUserAnswer(String ans) {
        this.userAnswer = ans;
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
