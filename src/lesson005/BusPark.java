/* объект Buses (массив объектов Bus с заданными методами выборки)  getBuses - возвращает массив Bus
методы согласно условия задачи:
 * a) список автобусов для заданного номера маршрута; getBusToRout(int);
 * b) список автобусов, которые эксплуатируются больше заданного срока; getExpirationDate(int);
 * c) список автобусов, пробег у которых больше заданного расстояния. getExpirationMileage(int);
*/

package lesson005;

public class BusPark {
	private Bus[] argsBus;
	public static String header="ФИО водителя~номер автобуса~Номер маршрута~Марка~Год начала эксплуатации~Пробег, км~~";
	public BusPark() {
		
	}

	public BusPark(Bus[] args) { 
		this.argsBus = args;//уточнить на предмет корректности или все переприсваивать циклами?
		// this.strBuses = this.toString();
	}

	public BusPark(String strBuses) {
		Bus[] argsBus;
		String[] items = strBuses.split("~~");
		int n = items.length;
		argsBus = new Bus[n];
		int i = 0;
		for (String item : items) {
			argsBus[i] = new Bus(item);
			i++;
		}
		this.argsBus = argsBus;
	}
	@Override
	public String toString() {
		String str = new String();
		str = str.concat("type:BusPark\n");
		for (Bus bus : this.argsBus) {
			str = str.concat(bus.toString());
			//str = str.concat("\n");
		}
		return str;
	}
	//форматируем под вывод true - добавить header
	public String toString(boolean b) {
		String str = new String();
		if (b){str = str.concat(BusPark.header);}
		for (Bus bus : this.argsBus) {
			str = str.concat(bus.toString(false));
			//str = str.concat("~~");
		}
		return str;
	}
	public Bus[] getBuses() {
		return this.argsBus;
	}

	public String getBusToRout(int numberRout) {
		String getBuses = new String();
		getBuses = getBuses.concat(BusPark.header);
		for (Bus bus : this.argsBus) {
			if (bus.getBusRoutingNumber() == numberRout) {
				getBuses = getBuses.concat(bus.toString(false));
			}
		}
		return getBuses;
	}

	public String getExpirationDate(int numberYear) {
		String getBuses = new String();
		getBuses = getBuses.concat(BusPark.header);
		int currenYear = Integer.valueOf((new java.util.Date().toString()).substring(24));
		for (Bus bus : this.argsBus) {
			if ((currenYear - bus.getYearBus()) > numberYear) {
				getBuses = getBuses.concat(bus.toString(false));
			}
		}
		return getBuses;
	}

	public String getExpirationMileage(int mileage) {
		String getBuses = new String();
		getBuses = getBuses.concat(BusPark.header);
		for (Bus bus : this.argsBus) {
			if ((bus.getMileageBus()) > mileage) {
				getBuses = getBuses.concat(bus.toString(false));
			}
		}
		return getBuses;
	}
}