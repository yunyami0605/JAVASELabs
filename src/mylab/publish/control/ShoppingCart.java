package mylab.publish.control;
import mylab.publish.entity.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private final List<Publication> items;

    public ShoppingCart() { 
    	this.items = new ArrayList<>(); 
    }
    
    public static void main(String[] args) {
        Publication[] publications = samplePublications();

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(publications[0]);
        cart.addItem(publications[1]);
        cart.addItem(publications[2]);
        cart.addItem(publications[3]);
        cart.addItem(publications[4]);

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("빠삐용");
        cart.displayCart();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
        return false;
    }

    // 장바구니에 있는 모든 출판물의 원래 가격을 합산하여 반환합니다.
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) total += item.getPrice();
        return total;
    }

    // 출판물 타입에 따라 다른 할인율을 적용하여 총 할인가를 계산합니다: 
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += (int) Math.round(item.getPrice() * 0.9);      // 10%
            } else if (item instanceof Novel) {
                total += (int) Math.round(item.getPrice() * 0.85);     // 15%
            } else if (item instanceof ReferenceBook) {
                total += (int) Math.round(item.getPrice() * 0.8);      // 20%
            } else {
                total += item.getPrice();
            }
        }
        return total;
    }

    public void printStatistics() {
        int magazineCount = 0, novelCount = 0, referenceBookCount = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) magazineCount++;
            else if (item instanceof Novel) novelCount++;
            else if (item instanceof ReferenceBook) referenceBookCount++;
        }
        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + magazineCount + "권");
        System.out.println("소설: " + novelCount + "권");
        System.out.println("참고서: " + referenceBookCount + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }

    public void displayCart() {
        System.out.println("= 장바구니 내용 =");
        for (int i = 0; i < items.size(); i++) {
            Publication p = items.get(i);
            System.out.println(i + 1);
            System.out.println(p.getTitle());
            System.out.println(p.getPrice() + "원");
        }
        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();
        System.out.println("총 가격: " + total + "원");
        System.out.println("할인 적용 가격: " + discounted + "원");
    }

    

    static Publication[] samplePublications() {
        return new Publication[]{
                new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
                new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
                new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
                new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
                new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
                new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
                new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };
    }
}
