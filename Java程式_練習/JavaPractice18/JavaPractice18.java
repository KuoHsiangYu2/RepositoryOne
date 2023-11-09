
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class JavaPractice18 {

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
        List<Horse> horseList = new ArrayList<Horse>();
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        horseList.add(horse4);

        String targetId = splitInput[1];
        int countObj = 0;
        for (Horse horseElement : horseList) {
            if (targetId.equals(horseElement.id)) {
                ++countObj;
                setHorseData(horseElement, splitInput);
                break;
            }
        }
        if (countObj == 0) {
            out.println("<系統提示> 賽道編號不存在，無法新增");
        }
    }

}
