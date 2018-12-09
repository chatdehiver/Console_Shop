package team.test;

import java.util.Scanner;

import team.child.Accessory;
import team.child.Cloth;
import team.child.Shoes;
import team.customer.Customer;
import team.parent.Wearable;
import team.service.WearableService;

public class WearableTest {
	public static void main(String[] args) {
		Wearable cloth1 = new Cloth("Shirt", "blue", 42000, '남');
		Wearable cloth2 = new Cloth("Skirt", "Ivory", 38000, '여');
		Wearable cloth3 = new Cloth("T-Shirt", "Black", 58000, '남');

		Wearable shoes1 = new Shoes("운동화", "blue", 60000, 270);
		Wearable shoes2 = new Shoes("슬리퍼", "Ivory", 38000, 265);
		Wearable shoes3 = new Shoes("하이힐", "White", 58000, 240);

		Wearable acc1 = new Accessory("ear-ring", "white", 20000, "Silver");
		Wearable acc2 = new Accessory("ring", "silver", 40000, "ruby");
		Wearable acc3 = new Accessory("necklace", "Rose-gold", 60000, "gold");

		Wearable[] wear = { cloth1, cloth2, cloth3, shoes1, shoes2, shoes3, acc1, acc2, acc3 };

		Scanner sc = new Scanner(System.in);
		System.out.println("거주지를 입력하세요. 서초동만 배달 가능합니다.");
		String addr = sc.nextLine();
		Customer cust = new Customer("김용진", addr, 0);
		WearableService ser = new WearableService();
		ser.buyWear(wear, cust);
		ser.customShoppingInfo(cust);
		ser.interestWear(cust);
		ser.printLottoResult();
		ser.deliveryPossible(cust);
	}// main
}// class
