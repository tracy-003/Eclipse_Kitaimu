import java.io.IOException;

public class TestScreip {
	public static void main(String[] args) throws IOException{
		Screip screip = new Screip("https://www.navitime.co.jp/bus/diagram/timelist?departure=00551329&arrival=00551334&line=00085100");
		screip.setElements();
		System.out.println("スクレイプの大きさ "+ screip.getSize());
	}
}
