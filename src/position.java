
public class position
{
	String type; //ship, grenade or nothing
	
	String owner; //user or computer or none
	
	boolean called; //has position been called before
	
	//default constructor
	position()
	{
		type = "nothing";
		owner = "none";
		called = false;
	}
	
	//parameterized constructor
	position(String t, String o, Boolean c)
	{
		type = t;
		owner = o;
		called = c;
	}
	
	public String getType() {
		return type;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public boolean getCalled() {
		return called;
	}
	
	public void setType(String newType) {
		this.type = newType;
	}
	
	public void setOwner(String newOwner) {
		this.owner = newOwner;
	}
	
	public void setCalled(boolean newCalled) {
		this.called = newCalled;
	}
	
	
	//show data of a coordinate
	public void showData()
	{
	   System.out.print("type = "+type + "  " + " owner = "+owner + " called = "+called);
	   System.out.println();
	}
	



}
