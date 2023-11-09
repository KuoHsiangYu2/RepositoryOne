
import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;

public class JavaPractice18_2 {

    private static void setHorseData(Horse horseElement, String[] splitInput) {
        if (horseElement.whetherExist) {
            out.println("<系統提示> 該道已有賽馬，無法新增");
        } else {
            horseElement.whetherExist = true;
            horseElement.setName(splitInput[3]);
            horseElement.setMaxSpeed(Integer.parseInt(splitInput[4]));
            horseElement.setAcceleration(Integer.parseInt(splitInput[5]));
            out.println("<系統提示> 已新增賽馬");
        }
    }

    public static void main(String[] args) {
        String[] splitInput = "0,1,2,horseName,20,2".split(",");
        Horse horse1 = new Horse("1", false, "horse1", 90, 2);
        Horse horse2 = new Horse("2", false, "horse2", 100, 4);
        Horse horse3 = new Horse("3", true, "horse3", 80, 8);
        Horse horse4 = new Horse("4", true, "horse4", 75, 4);
        Map<String, Horse> horseMap = new HashMap<String, Horse>();
        horseMap.put(horse1.id, horse1);
        horseMap.put(horse2.id, horse2);
        horseMap.put(horse3.id, horse3);
        horseMap.put(horse4.id, horse4);

        String targetId = splitInput[1];

        Horse currentHorse = horseMap.get(targetId);
        if (currentHorse == null) {
            out.println("<系統提示> 賽道編號不存在，無法新增");
        } else {
            setHorseData(currentHorse, splitInput);
        }
    }

}
