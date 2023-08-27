
//     Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//     Создать множество ноутбуков.
//     Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.

// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД hd hdd
// 3 - Операционная система
// 4 - Цвет

// 4. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// 5. Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

// Класс сделать в отдельном файле

// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        // NoteBook notebook1 = new NoteBook("Asus", "D543MA",
        // "black", 256, 8, "Windows 10");
        // NoteBook notebook2 = new NoteBook("Asus", "F515JF",
        // "white", 512, 8, "Windows 10");
        // NoteBook notebook3 = new NoteBook("Apple", "MacBook Air",
        // "gold", 512, 8, "MacOS");
        // NoteBook notebook4 = new NoteBook("Tecno", "Megabook T1",
        // "black", 1000, 12, "Linux");
        // NoteBook notebook5 = new NoteBook("Apple", "MacBook Pro",
        // "gray", 512, 8, "MacOS");

        Set<NoteBook> set = new HashSet<>();
        set.add(new NoteBook("Asus", "D543MA", "black", 256, 8, "Windows 10"));
        set.add(new NoteBook("Asus", "F515JF", "white", 512, 8, "Windows 10"));
        set.add(new NoteBook("Apple", "MacBook Air", "gold", 512, 8, "MacOS"));
        set.add(new NoteBook("Tecno", "Megabook T1", "black", 1000, 12, "Linux"));
        set.add(new NoteBook("Apple", "MacBook Pro", "gray", 512, 8, "MacOS"));
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;

        Set<String> setBrand = new HashSet<>();
        Set<String> setColor = new HashSet<>();
        Set<Integer> setHardDisk = new HashSet<>();
        Set<Integer> setRam = new HashSet<>();
        Set<String> setOs = new HashSet<>();

        for (var item : set) {
            setBrand.add(item.brandNoteBook);
            setColor.add(item.colorNoteBook);
            setHardDisk.add(item.capacityHardDisk);
            setRam.add(item.ramNoteBook);
            setOs.add(item.osNoteBook);
        }

        while (flag) {
            System.out.println("\nВыберите параметр, по которому нужно выполнить фильтрацию:");
            System.out.println("1)Показать все");
            System.out.println("2)Объем жесткого диска");
            System.out.println("3)Объем ОЗУ");
            System.out.println("4)Операционная система");
            System.out.println("5)Цвет");
            System.out.println("0)Выход");
            System.out.print("Выберите действие: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    for (var item : set) {
                        System.out.println(item);
                    }
                    break;
                case "2":
                    capacityHardDisk(setHardDisk, set);
                    break;
                case "3":
                    ramNoteBook(setRam, set);
                    break;
                case "4":
                    osNoteBook(setOs, set);
                    break;
                case "5":
                    colorNoteBook(setColor, set);
                    break;
                case "0":
                    flag = false;
                default:
                    break;
            }
        }
        scanner.close();
    }

    public static void ramNoteBook(Set<Integer> setRam, Set<NoteBook> set) {
        Scanner scanner = new Scanner(System.in);
        Integer identifier = 1;
        Map<Integer, Integer> mapRam = new HashMap<>();
        Boolean flag = true;

        for (var item : setRam) {
            mapRam.put(identifier++, item);
        }

        System.out.println("\nВыберите объем оперативной памяти: ");
        for (var item : mapRam.entrySet()) {
            System.out.println(item.getKey() + ")" + item.getValue());
        }
        String value = scanner.nextLine();
        Integer tempValue = 0;

        while (flag) {

            System.out.println("\nВыберите объем оперативной памяти: ");
            for (var item : mapRam.entrySet()) {
                if (item.getKey() == Integer.parseInt(value)) {
                    System.out.println(item.getKey() + ")" + item.getValue() + "*");
                    tempValue = item.getValue();
                } else
                    System.out.println(item.getKey() + ")" + item.getValue());
            }

            for (var item : set) {
                if (item.ramNoteBook.equals(tempValue))
                    System.out.println(item);
            }
            value = scanner.nextLine();
            if (value == "0") {
                flag = false;
                break;
            }
        }
        scanner.close();
    }

    public static void capacityHardDisk(Set<Integer> setHardDisk, Set<NoteBook> set) {
        Scanner scanner = new Scanner(System.in);
        Integer identifier = 1;
        Map<Integer, Integer> mapHardDisk = new HashMap<>();
        Boolean flag = true;

        for (var item : setHardDisk) {
            mapHardDisk.put(identifier++, item);
        }

        System.out.println("\nВыберите объем памяти жесткого диска: ");
        for (var item : mapHardDisk.entrySet()) {
            System.out.println(item.getKey() + ")" + item.getValue());
        }
        String value = scanner.nextLine();
        Integer tempValue = 0;

        while (flag) {

            System.out.println("\nВыберите объем памяти жесткого диска: ");
            for (var item : mapHardDisk.entrySet()) {
                if (item.getKey() == Integer.parseInt(value)) {
                    System.out.println(item.getKey() + ")" + item.getValue() + "*");
                    tempValue = item.getValue();
                } else
                    System.out.println(item.getKey() + ")" + item.getValue());
            }

            for (var item : set) {
                if (item.capacityHardDisk.equals(tempValue))
                    System.out.println(item);
            }
            value = scanner.nextLine();
            if (value == "0") {
                flag = false;
                break;
            }
        }
        scanner.close();
    }

    public static void osNoteBook(Set<String> setOs, Set<NoteBook> set) {
        Scanner scanner = new Scanner(System.in);
        Integer identifier = 1;
        Map<Integer, String> mapOs = new HashMap<>();
        Boolean flag = true;

        for (var item : setOs) {
            mapOs.put(identifier++, item);
        }

        System.out.println("\nВыберите операционную систему: ");
        for (var item : mapOs.entrySet()) {
            System.out.println(item.getKey() + ")" + item.getValue());
        }
        String value = scanner.nextLine();
        String tempValue = "";

        while (flag) {

            System.out.println("\nВыберите операционную систему: ");
            for (var item : mapOs.entrySet()) {
                if (item.getKey() == Integer.parseInt(value)) {
                    System.out.println(item.getKey() + ")" + item.getValue() + "*");
                    tempValue = item.getValue();
                } else
                    System.out.println(item.getKey() + ")" + item.getValue());
            }

            for (var item : set) {
                if (item.osNoteBook.equals(tempValue))
                    System.out.println(item);
            }
            value = scanner.nextLine();
            if (value == "0") {
                flag = false;
                break;
            }
        }
        scanner.close();
    }

    public static void colorNoteBook(Set<String> setColor, Set<NoteBook> set) {
        Scanner scanner = new Scanner(System.in);
        Integer identifier = 1;
        Map<Integer, String> mapColor = new HashMap<>();
        Boolean flag = true;

        for (var item : setColor) {
            mapColor.put(identifier++, item);
        }

        System.out.println("\nВыберите цвет: ");
        for (var item : mapColor.entrySet()) {
            System.out.println(item.getKey() + ")" + item.getValue());
        }
        String value = scanner.nextLine();
        String tempValue = "";

        while (flag) {

            System.out.println("\nВыберите цвет: ");
            for (var item : mapColor.entrySet()) {
                if (item.getKey() == Integer.parseInt(value)) {
                    System.out.println(item.getKey() + ")" + item.getValue() + "*");
                    tempValue = item.getValue();
                } else
                    System.out.println(item.getKey() + ")" + item.getValue());
            }

            for (var item : set) {
                if (item.colorNoteBook.equals(tempValue))
                    System.out.println(item);
            }
            value = scanner.nextLine();
            if (value == "0") {
                flag = false;
                break;
            }
        }
        scanner.close();
    }
}