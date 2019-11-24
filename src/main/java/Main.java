import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int rounds;
        int enIncr=0;
        int plIncr=0;
        String weapon = "pivo";
        System.out.println("Введите количество раундов: ");
        rounds=sc.nextInt();
        System.out.println("Игра началась!" );
        for(int i=0;i<rounds;i++){
            System.out.println("1-Камень; ");
            System.out.println("2-Ножницы; ");
            System.out.println("3-Бумага. ");
            System.out.print("Сделайте свой выбор: ");
            choice = sc.nextInt();
            switch (choice) {
                case (1): {
                    weapon = "Камень";
                    break;
                }
                case (2): {
                    weapon = "Ножницы";
                    break;
                }
                case (3): {
                    weapon = "Бумага";
                    break;
                }
                default:
                    System.err.println("Не верное значение!");
                    break;
            }
            Map<Integer, String> enemWeapon = new HashMap<Integer, String>();
            enemWeapon.put(0, "Камень");
            enemWeapon.put(1, "Ножницы");
            enemWeapon.put(2, "Бумага");
            String enemChoice = enemWeapon.get((int) (Math.random() * 3));
            System.out.println("пользователь: " + weapon + "   Бездушная машина: " + enemChoice);
            if (weapon.equals(enemChoice))
                System.out.println("Ничья");
            else if (weapon == "Камень" && enemChoice == "Ножницы" || weapon == "Ножницы"
                    && enemChoice == "Бумага" || weapon == "Бумага" && enemChoice == "Камень"){
                ++plIncr;
                System.out.println("Победа в "+(i+1)+ " раунде ");
            }
            else{
                ++enIncr;
                System.out.println("Поражение в "+(i+1)+" раунде ");
            }
        System.out.println("Вы желаете продолжить? Y/N: ");
            String continueChoice;
            continueChoice=sc.next();
            if(continueChoice.equals("Y"))
                continue;
            else if(continueChoice.equals("N"))
                break;
            else break;
            }
        String totalRes="\n Итоговый счёт: Игрок: "+plIncr+" Компьютер: "+enIncr;
        System.out.println(totalRes);
        if(plIncr>enIncr){
            totalRes+="\n Победа игрока!";
            System.out.println("Победа игрока! \n");}
        else if(plIncr==enIncr){
            totalRes+="\n Ничья!";
            System.out.println("Ничья! \n");}
        else{totalRes+="\n Поражение";
            System.out.println("Поражение \n" );}
        File file=new File(File.separator+"Results");
        File file1=new File(File.separator+"Results"+File.separator+"results.txt");
        if(!file.exists())
            file.mkdir();
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(file1,true));
            bw.append(dtf.format(now));
            bw.append(totalRes);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

