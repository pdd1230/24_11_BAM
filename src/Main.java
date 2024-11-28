import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);

		int id= 1;

		while (true) {

			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if (cmd.equals("exit")) {
				break;
			} else if (cmd.equals("article write")) {
				System.out.printf("제목 :");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();
				System.out.printf("%d번 글이 생성되었습니다.\n",id);
				id++;

			} else if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다");
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
			
		}
		
		sc.close();  //sc 객체 close , 노란 경고를 막는다

		System.out.println("== 프로그램 종료 ==");
	}
}





