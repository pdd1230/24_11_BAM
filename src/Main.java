import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList<>();
		// 게시글 번호 변수명을 rename  id --> lastArticleId
		int lastArticleId= 1;

		while (true) {

			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if (cmd.equals("exit")) {
				break;
			}
			
			if (cmd.equals("article write")) {
				System.out.printf("제목 :");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();
					
				Article article = new Article(lastArticleId, title, body);
				articles.add(article);
				
				System.out.printf("%d번 글이 생성되었습니다.\n",lastArticleId);
				lastArticleId++;
				
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
					continue;
				} else {
					System.out.println("번호   |   제목");
					for (int i = articles.size() -1; i >= 0 ; i--) {
						Article article = articles.get(i);
						System.out.printf("  %d    |   %s\n", article.id, article.title);;
					}
				}
				
			} else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");
				int id;
				
				// 잘못된 문자열이 들어오는 경우 예외 처리로 해결
				// 구글링 -> throw 예외던지기 
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("올바른 명령어가 아닙니다.");
					continue;
				} catch (Exception e) {
					e.printStackTrace();
				}
				id = Integer.parseInt(cmdBits[2]);
				
				Article foundArticle = null;
				
				for(Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					} 
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시글이 존재하지 않습니다.\n", id); 
					continue;
				}
				
			    System.out.println("번호 :"+ foundArticle.id );
				System.out.println("날짜 : ~~~~");
				System.out.println("제목 :"+ foundArticle.title );
				System.out.println("내용 :"+ foundArticle.body );
				
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		
		sc.close();  
		
		System.out.println("== 프로그램 종료 ==");
	}
}
class Article {
	int id;
	String title;
	String body;
	
	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}