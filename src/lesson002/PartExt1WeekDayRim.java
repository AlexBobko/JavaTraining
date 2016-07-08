package lesson002;

import java.util.Scanner;

public class PartExt1WeekDayRim {

	public static void main(String[] args) {
		boolean enterDate = true;
		int numUlYear = 0, numUlMonth = 0, numUlDay = 0;
		while (enterDate) {
			Scanner scWeekDayRim = new Scanner(System.in);
			System.out.print("Вводим современную дату\n Введите год: ");
			if (scWeekDayRim.hasNextInt()) {
				numUlYear = scWeekDayRim.nextInt();
				if (numUlYear < 0)
					continue;
				System.out.print("Введите месяц (1-12): ");
				if (scWeekDayRim.hasNextInt()) {
					int countThisMonthDay;
					numUlMonth = scWeekDayRim.nextInt();
					if ((numUlMonth < 13) && (numUlMonth > 0)) {
						if ((numUlMonth == 4) || (numUlMonth == 6) || (numUlMonth == 9) || (numUlMonth == 11)) {
							countThisMonthDay = 30;
						} else if (numUlMonth == 2) {
							countThisMonthDay = 27;
							if ((numUlYear % 4 == 0) && ((numUlYear % 100 != 0)||(numUlYear % 400 == 0))){ 
								countThisMonthDay = 28;
								//System.out.println("високосный год " + countThisMonthDay);
								 }
						} else
							countThisMonthDay = 31;
						System.out.print("Введите число месяца (1-" + countThisMonthDay + "): ");
						if (scWeekDayRim.hasNextInt()) {
							numUlDay = scWeekDayRim.nextInt();
							if ((numUlDay > 0) && (numUlDay <= countThisMonthDay)) {
								System.out.println("Вы ввели дату: " + numUlDay + "." + numUlMonth + "." + numUlYear);
								break;
							}
						}
					}
				}

			}
			System.out.println("Вы ввели не корректную дату, повторите ввод");
		}
		// convert Uliandate to Rimdate
		numUlMonth = numUlMonth - 2;
		if (numUlMonth <= 0) {
			numUlMonth = numUlMonth + 12;
			numUlYear--;
		}
		// рассчитываем день недели
		int calcDay, counCent;
		counCent = (int) (numUlYear / 100); // количество столетий
		numUlYear = numUlYear - counCent * 100;
		calcDay = (numUlDay + ((int) ((13 * numUlMonth - 1) / 5)) + numUlYear + ((int) (numUlYear / 4))
				+ ((int) (counCent / 4)) - (2 * counCent) + 777) % 7;
		String calDayString;
		switch (calcDay) {
		case 1:
			calDayString = "Понедельник";
			break;
		case 2:
			calDayString = "Вторник";
			break;
		case 3:
			calDayString = "Среда";
			break;
		case 4:
			calDayString = "Четверг";
			break;
		case 5:
			calDayString = "Пятница";
			break;
		case 6:
			calDayString = "Суббота";
			break;
		default:
			calDayString = "Воскресенье";
			break;
		}
		System.out.println("день:" + calDayString + "\n Римская дата: число:" + numUlDay + " месяц:" + numUlMonth
				+ " век:" + counCent + " номер года в столетии:" + numUlYear);
	}
}