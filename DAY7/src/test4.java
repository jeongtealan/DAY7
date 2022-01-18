import java.util.Scanner;

public class test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 5;

		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMoney = new int[MAX];

		int count = 0;
		int log = -1;

		String menu = "=== 메가IT ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n8.개인정보\n0.종료";

		while (true) {
			System.out.println(menu);

			int sel = sc.nextInt();

			if (sel == 1) {
				if (count == 5) {
					System.out.println("최대 저장 인원은 5명입니다.");
					continue;
				}

				System.out.println("Id를 입력해주세요");
				int Id = sc.nextInt();

				int check = 1;

				for (int i = 0; i < count; i++) {
					if (arId[i] == Id) {
						check = -1;
					}
				}

				if (check == -1) {
					System.out.println("중복되어 있는 Id입니다.");
				} else {
					System.out.println("Pw를 입력해주세요");
					int Pw = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arPw[i] == Pw) {
							check = -1;
						}
					}

					if (check == -1) {
						System.out.println("중복되어 있는 Pw입니다.");
					} else {
						arId[count] = Id;
						arPw[count] = Pw;
						arMoney[count] = 1000;
						count++;
						System.out.println(Id + " 님 회원가입이 성공적으로 이루어졌습니다. 환영합니다.");
					}
				}
			} else if (sel == 2) {
				if (log == -1) {
					System.out.println("로그인후 사용가능합니다.");
					System.out.println();
				} else {
					for (int i = log; i < count - 1; i++) {
						arId[i] = arId[i + 1];
						arPw[i] = arPw[i + 1];
						arMoney[i] = arMoney[i + 1];
					}
					System.out.println(arId[log] + "님 탈퇴되었습니다.");
					System.out.println();
					count--;
					log = -1;
				}
			} else if (sel == 3) {
				if (log == -1) {
					System.out.println("아이디를 입력 해주세요");
					int Id = sc.nextInt();

					int check = -1;

					for (int i = 0; i < count; i++) {
						if (arId[i] == Id) {
							check = i;
						}
					}
					if (check == -1) {
						System.out.println("Id를 확인해주세요");
					} else {
						System.out.println("비밀번호를 입력하시오");
						int Pw = sc.nextInt();

						for (int i = 0; i < count; i++) {
							if (arPw[i] == Pw) {
								check = i;
							}
						}
						if (check == -1) {
							System.out.println("비밀번호를 확인해주세요");
						} else {
							log = check;
							System.out.println(arId[check] + "님 환영합니다.");
							System.out.println();
						}
					}
				} else {
					System.out.println(arId[log] + "님이 로그인중입니다.");
					System.out.println();
				}
			} else if (sel == 4) {
				if (log == -1) {
					System.out.println("로그인 먼저 해주세요");
				} else {
					System.out.println(arId[log] + "님 로그아웃되었습니다.");
					System.out.println();
					log = -1;
				}
			} else if (sel == 5) {
				if (log == -1) {
					System.out.println("로그인 먼저 해주세요");
				} else {
					System.out.println("입금할 돈을 입력해주세요");
					int money = sc.nextInt();

					arMoney[log] = arMoney[log] + money;
				}
			} else if (sel == 6) {
				int send = 0;

				if (log == -1) {
					System.out.println("로그인 먼저 해주세요");
				} else {
					System.out.println("이체할 돈을 입력해주세요");
					int money = sc.nextInt();
					System.out.println("이체할 아이디를 입력해주세요");
					int send_Id = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arId[i] == send_Id) {
							send = i;
						}
					}

					if (money > arMoney[log]) {
						System.out.println("잔고가 부족합니다.");
					} else {
						arMoney[log] = arMoney[log] - money;
						arMoney[send] = arMoney[send] + money;
					}
				}
			} else if (sel == 7) {
				if (log == -1) {
					System.out.println("로그인 먼저 해주세요");
				} else {
					System.out.println(arId[log] + "님의 잔액은 " + arMoney[log] + " 입니다.");
				}
			} else if (sel == 8) {
				System.out.println("관리자만 접근 가능합니다.");
				System.out.println("관리자 권한 비밀번호를 입력해주세요");
				int Manager_Num = sc.nextInt();

				int Manager = 12345;

				if (Manager_Num == Manager) {
					System.out.println("현재 저장되어있는 Id");
					for (int i = 0; i < count; i++) {
						System.out.print(arId[i] + " ");
					}
					System.out.println();

					System.out.println("현재 저장되어있는 Pw");
					for (int i = 0; i < count; i++) {
						System.out.print(arPw[i] + " ");
					}
					System.out.println();

					System.out.println("현재 저장되어있는 돈");
					for (int i = 0; i < count; i++) {
						System.out.print(arMoney[i] + " ");
					}
					System.out.println();
				} else {
					System.out.println("비밀번호를 확인해주세요");
				}
			} else if (sel == 0) {
				break;
			}
		}
	}

}
