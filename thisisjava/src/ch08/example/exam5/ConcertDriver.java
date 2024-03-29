package ch08.example.exam5;

import java.util.*;

public class ConcertDriver {

	public static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;

		Concert concert = new Concert("가수왕", 100, 10000, 20000);

		System.out.println("콘서트 판매 프로그램을 시작합니다.");

		while (concert.getIsOnline()) {
			System.out.println();
			System.out.printf("인터넷 판매이면 S, 현장 판매로 바꾸려면 V, 판매를 종료하려면 F를 입력하세요: ");
			input = scan.nextLine();

			if (input.equals("S")) {
				System.out.printf("파는 티켓들 수는? <최대" + concert.getCapacity() + "> ");
				int ticketNum = Integer.parseInt(scan.nextLine());
				
				if(ticketNum>concert.getCapacity()) {
					System.out.println("죄송합니다. 판매를 완료할 수 없습니다.");
					System.out.println("남은 티켓들의 수: " + concert.getCapacity());
				}else {
					concert.setTicketNum(ticketNum);
					concert.setSoldTicket(ticketNum);
					concert.setCapacity(ticketNum);
					System.out.println("티켓들의 총 가격= "+concert.getTotalPrice());
					System.out.println("남은 티켓들의 수: " + concert.getCapacity());
				}
				
			} else if (input.equals("V")) {
				concert.setIsOnline(false);
				System.out.println("남은 티켓들의 수: " + concert.getCapacity());
			} else if (input.equals("F")) {
				concert.setIsOnline(false);
			} else {
				System.out.println("다시 선택해주세요.");
			}
		}

		while (!concert.getIsOnline()) {
			System.out.println();
			System.out.printf("현장 판매이면 S, 판매를 종료하려면 F를 입력하세요: ");
			input = scan.nextLine();
			
			if (input.equals("S")) {
				System.out.printf("파는 티켓들 수는? <최대" + concert.getCapacity() + "> ");
				int ticketNum = Integer.parseInt(scan.nextLine());
				
				if(ticketNum>concert.getCapacity()) {
					System.out.println("죄송합니다. 판매를 완료할 수 없습니다.");
					System.out.println("남은 티켓들의 수: " + concert.getCapacity());
				}else {
					concert.setTicketNum(ticketNum);
					concert.setSoldTicket(ticketNum);
					System.out.println("티켓들의 총 가격= "+concert.getTotalPrice());
					System.out.println("남은 티켓들의 수: " + concert.getCapacity());
					concert.setCapacity(ticketNum);
				}
			} else if (input.equals("F")) {
				concert.setIsOnline(true);
				System.out.println("남은 티켓들의 수: " + concert.getCapacity());
			} else {
				System.out.println("다시 선택해주세요.");
			}
		}
		
		System.out.println();
		
		System.out.println("최종 판매 보고서");
		System.out.println();
		System.out.println(concert.getName() + " 콘서트 티켓 판매 내역:");
		System.out.println("팔린 티켓 수: " + concert.getFinalTicket() + " 총 판매 금액 " + concert.getFinalPrice());
		
		System.out.print("계속하려면 아무 키나 누르십시오 . . .");
		scan.nextLine();
	}

}
