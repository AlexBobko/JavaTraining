/** *автобус** класс Bus
 * 
 * 0 Фамилия и инициалы водителя, 
 * 1 Номер автобуса,
 * 2 Номер маршрута,
 * 3 Марка,
 * 4 Год начала эксплуатации,
 * 5 Пробег.
 * */
package lesson005;

public class Bus {
	//шапка вывода
	public static String header="ФИО водителя~номер автобуса~Номер маршрута~Марка~Год начала эксплуатации~Пробег, км~~"; 
	private String busDriverName; // фио водителя
	private int busNumber; // номер
	private int busRoutingNumber; // номер маршрута
	private String makeBus; // марка
	private int yearBus; // год начала эксплуатации
	private int mileageBus;// пробег

	public Bus() {
		// создаем пустой объект
	}

	public Bus(String strBus) {
		String[] items = strBus.split("~");
		this.busDriverName = items[0];
		this.busNumber = Integer.valueOf(items[1]);
		this.busRoutingNumber = Integer.valueOf(items[2]);
		this.makeBus = items[3];
		this.yearBus = Integer.valueOf(items[4]);
		this.mileageBus = Integer.valueOf(items[5]);

	}

	public Bus(String busDriverName, int busNumber, int busRoutingNumber, String makeBus, int yearBus, int mileageBus) {
		this.busDriverName = busDriverName;
		this.busNumber = busNumber;
		this.busRoutingNumber = busRoutingNumber;
		this.makeBus = makeBus;
		this.yearBus = yearBus;
		this.mileageBus = mileageBus;
	}

	public Bus(String[] strBus) {
		this.busDriverName = strBus[0];
		this.busNumber = Integer.valueOf(strBus[1]);
		this.busRoutingNumber = Integer.valueOf(strBus[2]);
		this.makeBus = strBus[3];
		this.yearBus = Integer.valueOf(strBus[4]);
		this.mileageBus = Integer.valueOf(strBus[5]);
	}
	
	@Override
	public String toString() {
		String str = new String();
		str = str.concat ("type=").concat ("Bus").concat ("\n");
		//str = str.concat (Bus.header.replace ('~', ' ')).concat ("\n");
		str = str.concat(" busDriverName=").concat(this.busDriverName);
		str = str.concat(" busNumber=").concat(Integer.toString(this.busNumber));
		str = str.concat(" busRoutingNumber=").concat(Integer.toString(this.busRoutingNumber));
		str = str.concat(" makeBus=").concat(this.makeBus);
		str = str.concat(" yearBus=").concat(Integer.toString(this.yearBus));
		str = str.concat(" mileageBus=").concat(Integer.toString(this.mileageBus));
		str = str.concat("\n");
		return str;
	}
	//форматируем под вывод true - добавить header
	public String toString(boolean b) {
		String str = new String();
		if (b)str = str.concat(Bus.header);
		str = str.concat(this.busDriverName).concat("~");
		str = str.concat(Integer.toString(this.busNumber)).concat("~");
		str = str.concat(Integer.toString(this.busRoutingNumber)).concat("~");
		str = str.concat(this.makeBus).concat("~");
		str = str.concat(Integer.toString(this.yearBus)).concat("~");
		str = str.concat(Integer.toString(this.mileageBus)).concat("~");
		str = str.concat("~");
		return str;
	}
	

	public int getYearBus() {
		return this.yearBus;
	}

	public int getMileageBus() {
		return this.mileageBus;
	}

	public int getBusNumber() {
		return this.busNumber;
	}

	public String getMakeBus() {
		return this.makeBus;
	}

	public String getBusDriverName() {
		return this.busDriverName;
	}

	public int getBusRoutingNumber() {
		return this.busRoutingNumber;
	}

	public void setYearBus(int yearBus) {
		this.yearBus = yearBus;
	}

	public void setMileageBus(int mileageBus) {
		this.mileageBus = mileageBus;
	}

	public void setMakeBus(String makeBus) {
		this.makeBus = makeBus;
	}

	public void setBusDriverName(String busDriverName) {
		this.busDriverName = busDriverName;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public void setBusRoutingNumber(int busRoutingNumber) {
		this.busRoutingNumber = busRoutingNumber;
	}
}
