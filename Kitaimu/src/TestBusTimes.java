
public class TestBusTimes {
	public static void main(String[] args) {
		BusTimes busTimes = new BusTimes();
		busTimes.add(new BusTime("09:10","10:00"));
		busTimes.add(new BusTime("12:10","10:00"));
		busTimes.add(new BusTime("14:10","10:00"));
		busTimes.add(new BusTime("17:10","10:00"));
		busTimes.add(new BusTime("18:10","10:00"));
		
		System.out.println("最初のデータ総数は、" + busTimes.size());
		busTimes.fastAct();
		System.out.println("最後のデータ総数は、" + busTimes.size());
	}
}
