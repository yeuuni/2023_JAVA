import java.util.Scanner;


public class Third { 
    public static void main(String[] args) {
        int n;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하시오 >> ");
        n = scanner.nextInt();

        // 학생 수 만큼의 학생들의 배열을 만듭니다
        Student[] students = new Student[n];
        for (int i = 0; i < students.length; ++i) {
            students[i] = new Student();
        }

        // 각각의 학생들의 이름과 성적을 각 배열에 저장합니다
        String name;
        int score;
        String num;
        for (int i = 0; i < n; ++i) {
            System.out.print((i + 1) + "번째 학생 이름과 성적과 학번을 입력하시오(빈칸으로 구분) : ");
            name = scanner.next();
            score = scanner.nextInt();
            num = scanner.next();
            students[i].setStudent(name, score, num);
        }
 
        // 입력 받은 정보들을 출력해 봅니다
        for (Student student : students) {
            student.print();
        }

        // 평균을 계산합니다
        int mean;
        int sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        mean = sum / students.length;
        
        // 결과를 출력합니다
        System.out.println("전체 학생은 총" + n + "명이고, 학생들의 전체 평균 점수는" + mean + "입니다." );
    }

    public static class Student {
        int score;
        String name, num;
        public Student()
        {
            this.score = 0;
            this.name = "";
        }
        public void setStudent(String name, int score, String num) {
            this.name = name;
            this.score = score;
            this.num = num;
        }
        public String getName() {
            return this.name;
        }
        public String getNum() {
            return this.num;
            
        }
        public int getScore() {
            return this.score;
            
        }
      
        public void print() {
            System.out.println(this.name + " , " + this.num+ " , " + this.score);
        }
    }    
}



