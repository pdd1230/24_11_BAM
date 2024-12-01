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
				// split(" ") -> 입력 받은 명령어를 " "으로 나누어서 String[] type 으로 리턴 
				String[] cmdBits = cmd.split(" ");
				// 명령어 뒤에 입력되는 번호 처리용 변수 id 생성, 아래 소스를 id로 간결하게 처리
				int id = Integer.parseInt(cmdBits[2]);
				
				// articleChk -> 해당 article 이 있는지 check하는 용도로 사용 : 방법 1 또는
//				boolean articleChk = false;
				// 방법 2 -> foundArticle 객체로 check, 이하 소스 변경
				// ★방법 2로 변경하는 이유는? 게시글을 찾아내는 기능을 
				//                           다른 부분에서 재사용(공통소스)을 위해서 임
				// foundArticle 객체 -> 게시글을 찾았을때... 그때의 article을 backup 하는 기능 임
				Article foundArticle = null;
				
				// 향상된 for문 -> List<Article> 타입으로 articles 사용(articles 순회)
				for(Article article : articles) {
					//Integer.parseInt() -> 구글링, String타입의 숫자를 int타입으로 변환
					//String 이 숫자가 아니면 exception 발생 ( 예 : "asdf" -> 별도 보강 필요)
					if (article.id == id) {
//						articleChk = true;
						foundArticle = article;
//						System.out.println("번호 :"+ article.id );
//						System.out.println("날짜 : ~~~~");
//						System.out.println("제목 :"+ article.title );
//						System.out.println("내용 :"+ article.body );
						break;
					} 
				}
				
//				if (articleChk == false) {
				if (foundArticle == null) {
					System.out.printf("%d번 게시글이 존재하지 않습니다.\n", id); 
					// continue; 추가하여 아래 출력문이 나오도록 수정함
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






