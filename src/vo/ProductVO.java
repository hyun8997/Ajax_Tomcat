package vo;

public class ProductVO {
	private int pno;
	private String pname;
	private int price;
	private int dcratio;
	private String prodesc;
	private int qty;
	private String imgFile;
	private String bigImgFile;
	
	public ProductVO() {}
	
	public ProductVO(int pno, String pname, int price, int dcratio, String prodesc, int qty, String imgFile,
			String bigImgFile) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.dcratio = dcratio;
		this.prodesc = prodesc;
		this.qty = qty;
		this.imgFile = imgFile;
		this.bigImgFile = bigImgFile;
	}

	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDcratio() {
		return dcratio;
	}
	public void setDcratio(int dcratio) {
		this.dcratio = dcratio;
	}
	public String getProdesc() {
		return prodesc;
	}
	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getBigImgFile() {
		return bigImgFile;
	}
	public void setBigImgFile(String bigImgFile) {
		this.bigImgFile = bigImgFile;
	}

	
	
}
