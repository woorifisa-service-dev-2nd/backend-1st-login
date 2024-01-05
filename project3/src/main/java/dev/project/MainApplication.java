package dev.project;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.project.service.Processor;


public class MainApplication {
	private static final String RESOURCES = "src/main/resources/";
	
	public static void main(String[] args) {
		
		final Path path = Paths.get(RESOURCES + "list.txt");
		Scanner sc = new Scanner(System.in);
		
		try {
			
			List<String> lines = Files.readAllLines(path);
			
			if (lines.isEmpty()) {
				System.out.println("정보가 없습니다.");
				return;
			}
			
			List<UserInformation> userList = new ArrayList<>();
			
			for (String line : lines) {
				String[] columns = line.split(" ");
				
				UserInformation user = new UserInformation(columns[0], columns[1], columns[2], columns[3]);
				userList.add(user);
			}
			
			
			Processor Pro = new Processor();
			String userInput = ""; 
			while (!userInput.equals("0")) {
				System.out.println("\n홈페이지: 메뉴에 맞는 숫자를 입력하세요.");
				System.out.println("0. 프로그램 종료\n1. 회원가입\n2. 로그인 \n3. 아이디 찾기 \n4. 비밀번호 찾기");
				userInput = sc.next();
				switch (userInput) {
					case "1": // 회원가입
						Files.write(path, Pro.makeUser(sc, userList), StandardCharsets.UTF_8); break;
					case "2": // 로그인
						System.out.println(Pro.login(sc, userList) ? "로그인 성공!": "로그인실패!"); break;
					case "3": // 아이디 찾기
						System.out.println("찾고있는 아이디는"+Pro.findID(sc, userList)); break;
						
					case "4": // 비밀번호 찾기
						System.out.println("찾고있는 비밀번호 는"+Pro.findPW(sc, userList)); break;
				}
				
			}			
		} catch (IOException e) {
			System.out.println("파일을 찾지 못했습니다.");
			
		} finally { sc.close(); }
		
	}
}