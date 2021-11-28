import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte maximalni vahy: ");
        String weight = sc.nextLine();
        String[] splitString = weight.split(" ");

        ArrayList<Van> vans = new ArrayList<>();

        for (String a : splitString) {
            int carCapacity = Integer.parseInt(a);
            vans.add(new Van(carCapacity));
        }

        while (true) {

            System.out.println("Zadejte číslo auta a změnu nákladu. Pro ukončení dejte 'END'. ");
            String response = sc.nextLine();

            if (response.toUpperCase(Locale.ROOT).equals("END"))
                break;

            String[] input = response.split(" ");

            int carId = Integer.parseInt(input[0]) - 1;
            if (!carExist(carId, vans)) {
                System.out.println("Toto vozidlo neexistuje. ");
            } else {
                Van tempCar = vans.get(carId);
                tempCar.setWeight(Double.parseDouble(input[1]));
            }
        }
        double avg = vans.stream().mapToDouble(Van::getWeight).average().orElse(0.0);
        System.out.println("Průměrná váha vašich aut je: " + avg);
    }

    public static boolean carExist(int id, ArrayList<Van> vans) {
        return getCar(id, vans) != null;
    }

    public static Van getCar(int id, ArrayList<Van> vans) {
        if (vans.size() <= id || id < 0) {
            System.out.println("Auto neexistuje " + id);
            return null;
        }
        return vans.get(id);
    }

    public static boolean carWeightLegitCheck(ArrayList<Van> vans) {
        for (Van van : vans) {
            if (van.getWeight() < 0)
                System.out.println("Vaha je v minusu, vahu neukladam, zadejte znovu");
            return false;
        }
        return true;
    }

    public static boolean carOverweight(ArrayList<Van> vans) {
        for (Van van : vans) {
            if (van.getWeight() > van.getCapacity())
                System.out.println("Vaha auta je prilis vysoka, vahu neukladam, zadejte znovu");
            return false;
        }
        return true;
    }
}
