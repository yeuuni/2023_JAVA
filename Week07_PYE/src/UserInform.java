import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInform {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int num2;
        String num, name, tel, email;
        PrintWriter in = new PrintWriter("user.txt");
        BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
        String line;

        while (true) {
            System.out.println("번호:");
            num = s.next();
            System.out.println("이름:");
            name = s.next();
            System.out.println("전화번호: ");
            tel = s.next();
            System.out.println("이메일: ");
            email = s.next();
            System.out.println("입력을 끝났으면 1, 계속하려면 0: ");
            num2 = s.nextInt();
            in.println(num + "," + name + "," + tel + "," + email);
            in.flush();

            if (num2 == 1)
                break;
        }

        System.out.println("사용자 정보 입력이 완료되었습니다.");

        // 사용자로부터 번호 입력
        System.out.println("전화번호를 검색할 번호를 입력하세요: ");
        String searchNumber = s.next();
        boolean found = false;

        // 파일에서 사용자 정보를 읽어서 해당 번호와 일치하는 정보를 출력
        while ((line = reader.readLine()) != null) {
            String[] userInfo = line.split(",");
            if (userInfo.length >= 3 && userInfo[0].equals(searchNumber)) {
                System.out.println("번호: " + userInfo[0]);
                System.out.println("전화번호: " + userInfo[2]);
                
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("일치하는 번호를 찾지 못했습니다.");
        }

        in.close();
        reader.close();
    }
}