import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Pf {
    PfQuestion[] questionnaire;
    private Map<String,Integer> result;

    public Pf() {
        this.questionnaire = new PfQuestion[187];
        this.result = new HashMap<String,Integer>();

        try { // set questionnaire
            Scanner in = new Scanner(
                Path.of("D:\\code\\16PF-questionnaire\\source\\question.txt"), 
                StandardCharsets.UTF_8);
            for(int i = 0; i < 187; i++) {
                String strQ = in.next(); 
                String strA = in.next(); 
                String strB = in.next(); 
                String strC = in.next();
                /* check invalid input
                if (strA.charAt(0) != 'A' || strC.charAt(0) != 'C') {
                    System.out.println(strQ);
                    System.out.printf("%s %s %s\n", strA, strB, strC);
                }*/
                this.questionnaire[i] = new PfQuestion(strQ, strA, strB, strC);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        try { // set answer
            Scanner in = new Scanner(
                Path.of("D:\\code\\16PF-questionnaire\\source\\answer.txt"), 
                StandardCharsets.UTF_8);
            while(in.hasNext()) {
                String[] tmp = in.next().split("\\.");
                int num = Integer.valueOf(tmp[0]); 
                String ans = tmp[1];
                //System.out.printf("%d:%s\n", num, ans);
                this.questionnaire[num-1].setRightAnswer(ans); 
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        try { // group
            Scanner in = new Scanner(
                Path.of("D:\\code\\16PF-questionnaire\\source\\group.txt"), 
                StandardCharsets.UTF_8);
            while(in.hasNext()) {
                String line = in.next();
                if(line != null) {
                    String[] tmp;

                    tmp = line.split("：");
                    String group = tmp[0];
                    this.result.put(group, 0);
                    
                    tmp = tmp[1].split("，|。|；");
                    for (String n : tmp) {
                        if (n != null) {
                            int num = Integer.valueOf(n);
                            this.questionnaire[num].setGroup(group);
                            //System.out.printf("%s:%s\n", num, group);
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void record(int num, String ans) {
        this.questionnaire[num-1].setUserAnswer(ans);
    }
    
    public void count(String grp, int[] t) {
        int raw = this.result.get(grp);
        if(raw <= t[0]) this.result.put(grp, 1);
        else if(raw <= t[1]) this.result.put(grp, 2);
        else if(raw <= t[2]) this.result.put(grp, 3);
        else if(raw <= t[3]) this.result.put(grp, 4);
        else if(raw <= t[4]) this.result.put(grp, 5);
        else if(raw <= t[5]) this.result.put(grp, 6);
        else if(raw <= t[6]) this.result.put(grp, 7);
        else if(raw <= t[7]) this.result.put(grp, 8);
        else if(raw <= t[8]) this.result.put(grp, 9);
        else this.result.put(grp, 10);
    }

    public void finish() {
        // raw point
        for(PfQuestion q : this.questionnaire) {
            if(!q.group.equals("X")) {
                int cnt = this.result.get(q.group);
                this.result.put(q.group, cnt+q.grade());
            }
        }

        // final point   1  2  3  4  5  6  7  8  9
        this.count("A" , new int[] {1, 3, 5, 6, 8,11,13,14,16});
        this.count("B" , new int[] {3, 4, 5, 6, 7, 8, 9,10,11});
        this.count("C" , new int[] {5, 7, 9,11,13,16,18,20,22});
        this.count("E" , new int[] {2, 4, 5, 7, 9,12,14,16,18});
        this.count("F" , new int[] {3, 4, 6, 7, 9,12,14,16,18});
        this.count("G" , new int[] {5, 7, 9,10,12,14,16,17,18});
        this.count("H" , new int[] {1, 2, 3, 6, 8,11,14,16,19});
        this.count("I" , new int[] {5, 6, 8, 9,11,13,14,16,17});
        this.count("L" , new int[] {3, 5, 6, 8,10,12,13,15,16});
        this.count("M" , new int[] {5, 7, 9,11,13,15,17,19,20});
        this.count("N" , new int[] {2, 3, 4, 6, 8,10,11,13,14});
        this.count("O" , new int[] {2, 4, 6, 8,10,12,14,16,18});
        this.count("Q1", new int[] {4, 5, 7, 8,10,12,13,14,15});
        this.count("Q2", new int[] {5, 7, 8,10,12,14,15,17,18});
        this.count("Q3", new int[] {4, 6, 8,10,12,14,15,17,18});
        this.count("Q4", new int[] {2, 4, 6, 8,11,14,16,19,21});

    }
}
