package insurance.customer.bean;

public class ClaimBean {

	
	private String Reasion;
	private String  TypeOfDamage;
	private String issue;
	private String parts;
	private int sum;
	
	
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getReasion() {
		return Reasion;
	}
	public void setReasion(String reasion) {
		Reasion = reasion;
	}
	public String getTypeOfDamage() {
		return TypeOfDamage;
	}
	public void setTypeOfDamage(String typeOfDamage) {
		TypeOfDamage = typeOfDamage;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getParts() {
		return parts;
	}
	public void setParts(String part) {
		this.parts = part;
	}
	
	
}
