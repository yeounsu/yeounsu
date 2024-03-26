package shop;

import java.util.Hashtable;

public class CartMgr {
	//장바구니 기능 : DB연동 x, 세션을 사용
	
	//key : 상품번호, value : 주문객체(OrderBean)
	private Hashtable<Integer, OrderBean> hCart =
			new Hashtable<Integer, OrderBean>();
	
	
	//Cart Add : 기존에 장바구니에 동일한 상품이 있는 경우를 고려
	public void addCart(OrderBean order) {
		int productNo = order.getProductNo(); //상품번호 - key
		int quantity = order.getQuantity(); //주문수량
		if(quantity > 0) {
			if(hCart.containsKey(productNo)) {
				//기존에 동일한 상품이 있는 경우
				OrderBean temp = hCart.get(productNo);
				quantity += temp.getQuantity();
				order.setQuantity(quantity);
				hCart.put(productNo, order);
			}else {
				//기존에 동일한 상품이 없는 경우
				hCart.put(productNo, order);
			}
		}
		
	}
	
	//Cart Delete:
	public void deleteCart(OrderBean order) {
		hCart.remove(order.getProductNo());
	}
	
	//Cart Update : 동일한 key 값이 저장되면 자동 덮어쓰기
	public void updateCart(OrderBean order) {
		hCart.put(order.getProductNo(),order);
	}
	
	//Cart Return
	public Hashtable<Integer, OrderBean> getCartList(){
		return hCart;
	}
}
