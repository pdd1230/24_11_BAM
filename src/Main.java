import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList<>();
		
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
				
				// 생성자를 통해서 최적화 진행

//				article.id = id;
//				article.title = title;
//				article.body = body;
				
	// 아래 2문장을 최적화 하면... (선택은 개발자의 선택임, 이해하기 쉬운것)
//				Article article = new Article(id, title, body);
//				articles.add(article);
				
				// 아래1번과 2번을 1줄로 최적화가 가능함
				articles.add(new Article(id, title, body));
				
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
class Article {
	int id;
	String title;
	String body;
	
	// 생성자를 통해서 최적화
	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}






