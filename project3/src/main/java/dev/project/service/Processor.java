package dev.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.project.UserInformation;

// 로그인 기능 부분
public class Processor {
	
	// 1. 회원가입 기능
public List<String> makeUser(Scanner sc, List<UserInformation> userList) {
	
		List<String> newStringList = new ArrayList<>();
		
		System.out.println("회원 정보 입력 (가입)");
		System.out.print("ID: ");
		String inputID = sc.next();
		System.out.print("PW: ");
		String inputPW = sc.next();
		System.out.print("Name: ");
		String inputName = sc.next();
		System.out.print("Phone: ");
		System.out.println("형식 : 010-0000-0000");
		String inputPhone = sc.next();
		
		//객체 생성
		UserInformation newUser = new UserInformation(inputID, inputPW, inputName, inputPhone);
		
		//새로 만들어진 객체 출력
		System.out.println("Id | PassWord | Name | Phone");
		System.out.println(newUser.getInfoToTable());
		
		//사용자 확인
		System.out.println("정말로 다음과 같이 회원가입을 하시겠습니까? Y/N");
		String userConfirm = sc.next();
		
		if (userConfirm.equals("Y")) {
		//새로운 유저 리스트 생성
		List<UserInformation> newUserList = userList;
		newUserList.add(newUser);
		System.out.println("회원가입 되었습니다!");
		
		//새로운 유저 리스트를 String 리스트로 변환
		for (UserInformation user: newUserList) {
			newStringList.add(user.getInfoToString());
		}
		
		} else {System.out.println("회원가입이 취소되었습니다.");
			List<UserInformation> newUserList = userList;
			
			for (UserInformation user: newUserList) {
				newStringList.add(user.getInfoToString());
			}
		}
		
		return newStringList;
		
	}
	
	// 2. 로그인 기능
	public boolean login(Scanner sc, List<UserInformation> userList) {
		
		System.out.print("ID: ");
		String inputID = sc.next();
		
		System.out.print("PW: ");
		String inputPW = sc.next();
		
		for (UserInformation user : userList) {
			if (inputID.equals(user.getUserID()) && inputPW.equals(user.getUserPW()))
				return true;
			
		} return false;
	}
	
	// 3. 아이디 찾기 기능
	public String findID(Scanner sc, List<UserInformation> userList) {
		String foundID = "아이디가 존재하지 않습니다.";
		
		System.out.println("등록한 휴대번호를 입력해주세요.");
		System.out.println("형식 : 010-0000-0000");
		System.out.print("PHONE: ");
		String inputPhone = sc.next();
		
		for (UserInformation user : userList) {
			if (inputPhone.equals(user.getUserPhone())) { foundID = user.getUserID(); }	
			
		}
		return foundID;
	}
	
	// 4. 비밀번호 찾기 기능
	public String findPW(Scanner sc, List<UserInformation> userList) {
		String foundPW = "";
		
		System.out.print("ID: ");
		String inputID = sc.next();
		
		System.out.print("PHONE: ");
		String inputPhone = sc.next();
		
		for (UserInformation user : userList) {
			if (inputID.equals(user.getUserID()) && inputPhone.equals(user.getUserPhone()))
				foundPW = user.getUserPW();
			else { foundPW = "정보가 일치하지 않습니다."; }
			
		} return foundPW;
	}
}