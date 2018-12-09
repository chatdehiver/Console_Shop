package team.service;

import java.util.Scanner;

import team.child.Accessory;
import team.child.Cloth;
import team.child.Shoes;
import team.customer.Customer;
import team.item.Item;
import team.parent.Wearable;

public class WearableService {
	private Wearable[] choice = new Wearable[9];
	private int useMoney;
	private int sum;
	private int clothCnt;
	private int shoesCnt;
	private int accCnt;
	private int num;
	private int index = 0;

	Item[] item1 = { new Item("������", 1, "�Ƶ�ٽ�"), new Item("������", 1, "����"), new Item("���͸� Ƽ����", 1, "china"),
			new Item("ũ��Ƽ����", 1, "����Ʈ"), new Item("���ǽ�", 1, "�뽺���̽�"), new Item("��������", 1, "K2"),
			new Item("����T", 1, "ITALY"), null, null, null };
	Item[] item2 = { new Item("Nike", 1, "china"), new Item("FILA", 1, "korea"), new Item("����Ʈ", 1, "china"),
			new Item("FUMA", 1, "china"), new Item("K2", 1, "china"), new Item("Adidas", 1, "USA"),
			new Item("��籸��", 1, "USA") };
	Item[] item3 = { new Item("Watch", 1, "CK"), new Item("Ring", 1, "OST"), new Item("Necklace", 1, "���̿���Ƽ��"),
			new Item("ear-ring", 1, "Clue"), new Item("wristband", 1, "ũ������"), new Item("Anklet", 1, "����"),
			new Item("��Ѿ׼�����", 1, "��𿡵κ�") };

	public void buyWear(Wearable[] w, Customer c) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		useMoney = c.getUseMoney();
		System.out.println("�����ݾ��� �Է��ϼ��� >> ");
		c.setHaveMoney(sc.nextInt());
		sum = c.getHaveMoney();
		printMenu();
		while (true) {
			input = sc.nextInt();
			if (input == -1)
				break;
			else if (input >= 9 || input < -1) {
				System.out.println("�ٽ� �Է����ּ���");
			} else {
				if (sum < w[input].getPrice()) {
					System.out.println("�ܾ��� �����մϴ�\n");
					return;
				}
				choice[index] = w[input];
				System.out.println(choice[index].getName());
				useMoney += choice[index].getPrice();
				sum -= choice[index].getPrice();
				index++;
				if (index == 9) {
					System.out.println("==== ���Ŵ� 9������ �����մϴ� ====");
					break;
				}
			} // else
				// for
		} // while
	}// buyWear

	public void customShoppingInfo(Customer c) {
		if (useMoney == 0) {
			System.out.println("�ý����� ����˴ϴ�");
			System.exit(0);
		}
		System.out.println("   [" + c.getName() + "]���� ���� ����Ʈ");
		for (Wearable a : choice) {
			if (a == null)
				break;
			System.out.println(" ��  " + a.getName());
		}
		System.out.println("���ο� ����Ͻ� �� �ݾ��� " + useMoney + "�� �Դϴ�.\n");
		System.out.println("���� �ݾ��� " + sum + "�� �Դϴ�.\n");
	}// customShoppingInfo

	public void interestWear(Customer c) {
		for (Wearable ch : choice) {
			if (ch instanceof Cloth)
				clothCnt++;
			if (ch instanceof Shoes)
				shoesCnt++;
			if (ch instanceof Accessory)
				accCnt++;
		}
		int Max = 0; // ������ �켱������ cloth, shoes, accessory ������ �ڵ����� ���� �˴ϴ�.
		if (clothCnt >= shoesCnt)
			Max = clothCnt;
		else if (clothCnt < shoesCnt)
			Max = shoesCnt;
		if (Max < accCnt)
			Max = accCnt;
		if (Max == clothCnt) {
			System.out.println(c.getName() + "�Բ��� ���� �� ���� ������ ���̽� �оߴ� '��'�Դϴ�.");
			decideItemArray(1);
		} else if (Max == shoesCnt) {
			System.out.println(c.getName() + "�Բ��� ���� �� ���� ������ ���̽� �оߴ� '�Ź�'�Դϴ�.");
			decideItemArray(2);
		} else if (Max == accCnt) {
			System.out.println(c.getName() + "�Բ��� ���� �� ���� ������ ���̽� �оߴ� '�Ǽ��縮'�Դϴ�.");
			decideItemArray(3);
		}
	}// InterestWear

	public void decideItemArray(int a) {
		switch (a) {
		case 1:
			if (useMoney >= 150000) {
				System.out.println("���ݾ� 150000�� �̻����� " + item1[6].getName() + "��(��) �߰��˴ϴ�.");
				for (int i = 0; i < 100; i++) {
					int t = (int) (Math.random() * 7);
					Item tmp = item1[0];
					item1[0] = item1[t];
					item1[t] = tmp;
				} // for i
			} else
				for (int i = 0; i < 100; i++) {
					int t = (int) (Math.random() * 6);
					Item tmp = item1[0];
					item1[0] = item1[t];
					item1[t] = tmp;
				} // for i
			num = 1;
			break;
		case 2:
			if (useMoney >= 150000) {
				System.out.println("���ݾ� 150000�� �̻����� " + item2[6].getName() + "��(��) �߰��˴ϴ�.\n");
				for (int i = 0; i < 100; i++) {
					int t = (int) (Math.random() * 7);
					Item tmp = item2[0];
					item2[0] = item2[t];
					item2[t] = tmp;
				} // for i
			} else
				for (int i = 0; i < 100; i++) {
					int t = (int) (Math.random() * 6);
					Item tmp = item2[0];
					item2[0] = item2[t];
					item2[t] = tmp;
				} // for i
			num = 2;
			break;
		case 3:
			if (useMoney >= 150000) {
				System.out.println("���ݾ� 150000�� �̻����� " + item2[6].getName() + "��(��) �߰��˴ϴ�.\n");
				for (int i = 0; i < 100; i++) {
					int t = (int) (Math.random() * 7);
					Item tmp = item3[0];
					item3[0] = item3[t];
					item3[t] = tmp;
				} // for i
			} else
				for (int i = 0; i < 100; i++) {
					int t = (int) (Math.random() * 6);
					Item tmp = item3[0];
					item3[0] = item3[t];
					item3[t] = tmp;
				} // for i
			num = 3;
			break;
		}
	} // itemArray

	public void printLottoResult() {
		if (num == 1) {
			System.out.println("��÷��� : " + item1[0].getbrandName() + " ���� " + item1[0].getName());
			System.out.print("��÷ �Ϸ� ��ǰ ���� >>\t");
			item1[0].setQn(item1[0].getQn() - 1);
			if (item1[0].getQn() == 0) {
				for (int i = 0; i < item1.length; i++) {
					for (int j = i; j < item1.length - 1; j++) {
						item1[j] = item1[j + 1]; // ���� ����
					}
					break;
				} // for
				item1[item1.length - 1] = null;
				for (Item is : item1)
					if (is == null)
						break;
					else
						System.out.print("[" + is.getName() + "]\t");
			}
		}

		else if (num == 2) {
			System.out.println("��÷��� : " + item2[0].getbrandName() + " ���� " + item2[0].getName());
			System.out.print("��÷ �Ϸ� ��ǰ ���� >>\t");
			item2[0].setQn(item2[0].getQn() - 1);
			if (item2[0].getQn() == 0) {
				for (int i = 0; i < item2.length; i++) {
					for (int j = i; j < item2.length - 1; j++) {
						item2[j] = item2[j + 1]; // ���� ����
					}
					break;
				} // for
				item2[item2.length - 1] = null;
				for (Item is : item2)
					if (is == null)
						break;
					else
						System.out.print("[" + is.getName() + "]\t");
			}
		} else {
			System.out.println("��÷��� : " + item3[0].getbrandName() + " ���� " + item3[0].getName());
			System.out.print("��÷ �Ϸ� ��ǰ ���� >>\t");
			item3[0].setQn(item3[0].getQn() - 1);
			if (item3[0].getQn() == 0) {
				for (int i = 0; i < item3.length; i++) {
					for (int j = i; j < item3.length - 1; j++) {
						item3[j] = item3[j + 1]; // ���� ����
					}
					break;
				} // for
				item3[item3.length - 1] = null;
				for (Item is : item3)
					if (is == null)
						break;
					else
						System.out.print("[" + is.getName() + "]\t");
			}
		} // else
	} // printLottoResult

	public void deliveryPossible(Customer cust) {
		if (cust.getAddr().equals("���ʵ�"))
			System.out.println("\n\n��� ���� �����Դϴ�.\n");
		else
			System.out.println("\n\n��� �Ұ��� �����Դϴ�. ���� �����ϼ���.^^\n");
	}

	public void printMenu() {
		System.out.println("��ǰ�� �����ϼ���. �ݾ׿� ���� �ִ� 9������ ���� �����մϴ�.");
		System.out.println("[0] Shirt");
		System.out.println("[1] Skirt");
		System.out.println("[2] T-Shirt ");
		System.out.println("[3] �ȭ ");
		System.out.println("[4] ������");
		System.out.println("[5] ������");
		System.out.println("[6] ear-ring");
		System.out.println("[7] ring");
		System.out.println("[8] necklace");
		System.out.println("[-1] ���� ����");
	}
} // class

