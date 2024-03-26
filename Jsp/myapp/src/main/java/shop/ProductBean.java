package shop;

public class ProductBean {

	private int no;
	
	private String name;
	
	private int price;
	
	private String detail;
	
	private String date;
	
	private int stock;
	
	private String image;
	
	public ProductBean() {}

	public ProductBean(int no, int stock, int price, String name, String detail, String date, String image) {
		this.no = no;
		this.stock = stock;
		this.price = price;
		this.detail = detail;
		this.date = date;
		this.name = name;
		this.image = image;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
