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

		String menu = "=== �ް�IT ATM ===\n";
		menu += "1.ȸ������\n2.ȸ��Ż��\n3.�α���\n4.�α׾ƿ�\n";
		menu += "5.�Ա�\n6.��ü\n7.�ܾ���ȸ\n8.��������\n0.����";

		while (true) {
			System.out.println(menu);

			int sel = sc.nextInt();

			if (sel == 1) {
				if (count == 5) {
					System.out.println("�ִ� ���� �ο��� 5���Դϴ�.");
					continue;
				}

				System.out.println("Id�� �Է����ּ���");
				int Id = sc.nextInt();

				int check = 1;

				for (int i = 0; i < count; i++) {
					if (arId[i] == Id) {
						check = -1;
					}
				}

				if (check == -1) {
					System.out.println("�ߺ��Ǿ� �ִ� Id�Դϴ�.");
				} else {
					System.out.println("Pw�� �Է����ּ���");
					int Pw = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arPw[i] == Pw) {
							check = -1;
						}
					}

					if (check == -1) {
						System.out.println("�ߺ��Ǿ� �ִ� Pw�Դϴ�.");
					} else {
						arId[count] = Id;
						arPw[count] = Pw;
						arMoney[count] = 1000;
						count++;
						System.out.println(Id + " �� ȸ�������� ���������� �̷�������ϴ�. ȯ���մϴ�.");
					}
				}
			} else if (sel == 2) {
				if (log == -1) {
					System.out.println("�α����� ��밡���մϴ�.");
					System.out.println();
				} else {
					for (int i = log; i < count - 1; i++) {
						arId[i] = arId[i + 1];
						arPw[i] = arPw[i + 1];
						arMoney[i] = arMoney[i + 1];
					}
					System.out.println(arId[log] + "�� Ż��Ǿ����ϴ�.");
					System.out.println();
					count--;
					log = -1;
				}
			} else if (sel == 3) {
				if (log == -1) {
					System.out.println("���̵� �Է� ���ּ���");
					int Id = sc.nextInt();

					int check = -1;

					for (int i = 0; i < count; i++) {
						if (arId[i] == Id) {
							check = i;
						}
					}
					if (check == -1) {
						System.out.println("Id�� Ȯ�����ּ���");
					} else {
						System.out.println("��й�ȣ�� �Է��Ͻÿ�");
						int Pw = sc.nextInt();

						for (int i = 0; i < count; i++) {
							if (arPw[i] == Pw) {
								check = i;
							}
						}
						if (check == -1) {
							System.out.println("��й�ȣ�� Ȯ�����ּ���");
						} else {
							log = check;
							System.out.println(arId[check] + "�� ȯ���մϴ�.");
							System.out.println();
						}
					}
				} else {
					System.out.println(arId[log] + "���� �α������Դϴ�.");
					System.out.println();
				}
			} else if (sel == 4) {
				if (log == -1) {
					System.out.println("�α��� ���� ���ּ���");
				} else {
					System.out.println(arId[log] + "�� �α׾ƿ��Ǿ����ϴ�.");
					System.out.println();
					log = -1;
				}
			} else if (sel == 5) {
				if (log == -1) {
					System.out.println("�α��� ���� ���ּ���");
				} else {
					System.out.println("�Ա��� ���� �Է����ּ���");
					int money = sc.nextInt();

					arMoney[log] = arMoney[log] + money;
				}
			} else if (sel == 6) {
				int send = 0;

				if (log == -1) {
					System.out.println("�α��� ���� ���ּ���");
				} else {
					System.out.println("��ü�� ���� �Է����ּ���");
					int money = sc.nextInt();
					System.out.println("��ü�� ���̵� �Է����ּ���");
					int send_Id = sc.nextInt();

					for (int i = 0; i < count; i++) {
						if (arId[i] == send_Id) {
							send = i;
						}
					}

					if (money > arMoney[log]) {
						System.out.println("�ܰ� �����մϴ�.");
					} else {
						arMoney[log] = arMoney[log] - money;
						arMoney[send] = arMoney[send] + money;
					}
				}
			} else if (sel == 7) {
				if (log == -1) {
					System.out.println("�α��� ���� ���ּ���");
				} else {
					System.out.println(arId[log] + "���� �ܾ��� " + arMoney[log] + " �Դϴ�.");
				}
			} else if (sel == 8) {
				System.out.println("�����ڸ� ���� �����մϴ�.");
				System.out.println("������ ���� ��й�ȣ�� �Է����ּ���");
				int Manager_Num = sc.nextInt();

				int Manager = 12345;

				if (Manager_Num == Manager) {
					System.out.println("���� ����Ǿ��ִ� Id");
					for (int i = 0; i < count; i++) {
						System.out.print(arId[i] + " ");
					}
					System.out.println();

					System.out.println("���� ����Ǿ��ִ� Pw");
					for (int i = 0; i < count; i++) {
						System.out.print(arPw[i] + " ");
					}
					System.out.println();

					System.out.println("���� ����Ǿ��ִ� ��");
					for (int i = 0; i < count; i++) {
						System.out.print(arMoney[i] + " ");
					}
					System.out.println();
				} else {
					System.out.println("��й�ȣ�� Ȯ�����ּ���");
				}
			} else if (sel == 0) {
				break;
			}
		}
	}

}
