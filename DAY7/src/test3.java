import java.util.Scanner;
import java.util.Random;

public class test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;

		int[] front = new int[SIZE];
		int[] back = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			front[i] = (i + 1);
			back[i] = SIZE + (i + 1);
		}

		for (int i = 0; i < 1000; i++) {
			int num = ran.nextInt(SIZE);
			int temp = front[0];
			front[0] = front[num];
			front[num] = temp;

			num = ran.nextInt(SIZE);
			temp = back[0];
			back[0] = back[num];
			back[num] = temp;
		}

		int data = 1;
		while (true) {
			int answer = 0;
			for (int i = 0; i < SIZE; i++) {
				if (front[i] == data) {
					answer = i;
				}
			}
			System.out.println(data + "[" + answer + "]");

			for (int i = 0; i < SIZE; i++) {
				if (front[i] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(front[i] + " ");
				}
			}
			System.out.println();

			System.out.println("[" + data + "]의 인덱스 입력:");
			int idx = sc.nextInt();

			if (front[idx] == data) {
				if (1 <= data && data <= SIZE) {
					front[idx] = back[idx];
				} else {
					front[idx] = 0;
				}
				data++;
			}
			if (data == 19) {
				break;
			}

		}
	}
}
