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

	Item[] item1 = { new Item("수영복", 1, "아디다스"), new Item("씨스루", 1, "세라"), new Item("레터링 티셔츠", 1, "china"),
			new Item("크롭티셔츠", 1, "데상트"), new Item("원피스", 1, "노스페이스"), new Item("골프웨어", 1, "K2"),
			new Item("구찌T", 1, "ITALY"), null, null, null };
	Item[] item2 = { new Item("Nike", 1, "china"), new Item("FILA", 1, "korea"), new Item("데상트", 1, "china"),
			new Item("FUMA", 1, "china"), new Item("K2", 1, "china"), new Item("Adidas", 1, "USA"),
			new Item("골든구스", 1, "USA") };
	Item[] item3 = { new Item("Watch", 1, "CK"), new Item("Ring", 1, "OST"), new Item("Necklace", 1, "제이에스티나"),
			new Item("ear-ring", 1, "Clue"), new Item("wristband", 1, "크롬하츠"), new Item("Anklet", 1, "비비안"),
			new Item("비싼액세서리", 1, "디디에두보") };

	public void buyWear(Wearable[] w, Customer c) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		useMoney = c.getUseMoney();
		System.out.println("보유금액을 입력하세요 >> ");
		c.setHaveMoney(sc.nextInt());
		sum = c.getHaveMoney();
		printMenu();
		while (true) {
			input = sc.nextInt();
			if (input == -1)
				break;
			else if (input >= 9 || input < -1) {
				System.out.println("다시 입력해주세요");
			} else {
				if (sum < w[input].getPrice()) {
					System.out.println("잔액이 부족합니다\n");
					return;
				}
				choice[index] = w[input];
				System.out.println(choice[index].getName());
				useMoney += choice[index].getPrice();
				sum -= choice[index].getPrice();
				index++;
				if (index == 9) {
					System.out.println("==== 구매는 9개까지 가능합니다 ====");
					break;
				}
			} // else
				// for
		} // while
	}// buyWear

	public void customShoppingInfo(Customer c) {
		if (useMoney == 0) {
			System.out.println("시스템이 종료됩니다");
			System.exit(0);
		}
		System.out.println("   [" + c.getName() + "]님의 쇼핑 리스트");
		for (Wearable a : choice) {
			if (a == null)
				break;
			System.out.println(" ▷  " + a.getName());
		}
		System.out.println("쇼핑에 사용하신 총 금액은 " + useMoney + "원 입니다.\n");
		System.out.println("남은 금액은 " + sum + "원 입니다.\n");
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
		int Max = 0; // 같을시 우선순위는 cloth, shoes, accessory 순으로 자동으로 결정 됩니다.
		if (clothCnt >= shoesCnt)
			Max = clothCnt;
		else if (clothCnt < shoesCnt)
			Max = shoesCnt;
		if (Max < accCnt)
			Max = accCnt;
		if (Max == clothCnt) {
			System.out.println(c.getName() + "님께서 쇼핑 중 가장 관심을 보이신 분야는 '옷'입니다.");
			decideItemArray(1);
		} else if (Max == shoesCnt) {
			System.out.println(c.getName() + "님께서 쇼핑 중 가장 관심을 보이신 분야는 '신발'입니다.");
			decideItemArray(2);
		} else if (Max == accCnt) {
			System.out.println(c.getName() + "님께서 쇼핑 중 가장 관심을 보이신 분야는 '악세사리'입니다.");
			decideItemArray(3);
		}
	}// InterestWear

	public void decideItemArray(int a) {
		switch (a) {
		case 1:
			if (useMoney >= 150000) {
				System.out.println("사용금액 150000원 이상으로 " + item1[6].getName() + "이(가) 추가됩니다.");
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
				System.out.println("사용금액 150000원 이상으로 " + item2[6].getName() + "이(가) 추가됩니다.\n");
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
				System.out.println("사용금액 150000원 이상으로 " + item2[6].getName() + "이(가) 추가됩니다.\n");
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
			System.out.println("추첨결과 : " + item1[0].getbrandName() + " 사의 " + item1[0].getName());
			System.out.print("추첨 완료 경품 제거 >>\t");
			item1[0].setQn(item1[0].getQn() - 1);
			if (item1[0].getQn() == 0) {
				for (int i = 0; i < item1.length; i++) {
					for (int j = i; j < item1.length - 1; j++) {
						item1[j] = item1[j + 1]; // 삭제 로직
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
			System.out.println("추첨결과 : " + item2[0].getbrandName() + " 사의 " + item2[0].getName());
			System.out.print("추첨 완료 경품 제거 >>\t");
			item2[0].setQn(item2[0].getQn() - 1);
			if (item2[0].getQn() == 0) {
				for (int i = 0; i < item2.length; i++) {
					for (int j = i; j < item2.length - 1; j++) {
						item2[j] = item2[j + 1]; // 삭제 로직
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
			System.out.println("추첨결과 : " + item3[0].getbrandName() + " 사의 " + item3[0].getName());
			System.out.print("추첨 완료 경품 제거 >>\t");
			item3[0].setQn(item3[0].getQn() - 1);
			if (item3[0].getQn() == 0) {
				for (int i = 0; i < item3.length; i++) {
					for (int j = i; j < item3.length - 1; j++) {
						item3[j] = item3[j + 1]; // 삭제 로직
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
		if (cust.getAddr().equals("서초동"))
			System.out.println("\n\n배달 가능 지역입니다.\n");
		else
			System.out.println("\n\n배달 불가능 지역입니다. 직접 수령하세여.^^\n");
	}

	public void printMenu() {
		System.out.println("상품을 선택하세요. 금액에 한해 최대 9개까지 구매 가능합니다.");
		System.out.println("[0] Shirt");
		System.out.println("[1] Skirt");
		System.out.println("[2] T-Shirt ");
		System.out.println("[3] 운동화 ");
		System.out.println("[4] 슬리퍼");
		System.out.println("[5] 하이힐");
		System.out.println("[6] ear-ring");
		System.out.println("[7] ring");
		System.out.println("[8] necklace");
		System.out.println("[-1] 구매 종료");
	}
} // class

