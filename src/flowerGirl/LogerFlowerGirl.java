package flowerGirl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LogerFlowerGirl {
	private static volatile LogerFlowerGirl log;

	private File newFile = new File("src/flowerGirl/logFlowerGirl.txt");

	private LogerFlowerGirl() {
		try {
			newFile.createNewFile();
//			System.out.println("Log файл создан (logFlowerGirl.txt)");
		} catch (IOException e) {
//			System.out.println("Файл уже существует");
			e.printStackTrace();
		}
	}

	static void addlog(String message) {
//		LogerFlowerGirl loger = log;
		if (log == null) {
			synchronized (LogerFlowerGirl.class) {
//				loger = log;
				if (log == null) {
					log = new LogerFlowerGirl();
				}
			}
		}
		synchronized (LogerFlowerGirl.class) {
			try (FileWriter writer = new FileWriter(log.newFile, true)) {
				String time=DateFormat.getDateTimeInstance().format(new Date());
				time=time.concat(" ").concat(message).concat("\n");
//				System.out.println (time);
//				String dat=MainFlowerGirl.df.format(MainFlowerGirl.currentDate);
				writer.write(time);
				writer.flush();
//				System.out.println("Записано");
			} catch (IOException ex) {
				System.out.println("Логирование не работает");
				ex.printStackTrace();
			}
		}
	}
}
