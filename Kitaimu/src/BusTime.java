

public class BusTime {
	
	private String txt_dep;
	private String txt_arr;
	
	public BusTime(String txt_dep, String txt_arr){
		this.txt_dep = txt_dep;
		this.txt_arr = txt_arr;
	}
	
	public String get_dep() {
		return this.txt_dep;
	}
	
	public String get_arr() {
		return this.txt_arr;
	}
}
