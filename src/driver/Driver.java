/* File     : Driver.java */
/* Author     : Andika Kusuma */

package driver;

import java.util.Scanner;

/**
 * Created by ASUS INDONESIA on 3/27/2017.
 */

/**
 * \brief Class Driver
 * \details Class yang digunakan untuk menginisiasi zoo
 */
public class Driver {
    /**
     * \brief Constructor
     */
    public Driver() {
        char option;
        Scanner scanner = new Scanner(System.in);
        int width = 33, length = 32;
        //Zoo z;
        do {
            System.out.println("Auto generate zoo? (y/n) ");
            option = scanner.next().charAt(0);
        } while (option != 'Y' && option != 'y' && option != 'N' && option != 'n');
        if (option == 'N' || option == 'n') {
            do{
                System.out.println("Input lebar dan panjang zoo: ");
                width = scanner.nextInt();
                length = scanner.nextInt();
            } while (width <= 0 || length <= 0);
            //z = new Zoo (0, width, length);
        } else{
            //z = new Zoo;
        }
        do {
            System.out.println("Apa yang ingin anda lakukan?");
            System.out.println("1. Tampilkan zoo");
            System.out.println("2. Tampilkan total konsumsi makanan semua hewan di zoo");
            System.out.println("3. Tour zoo");
            System.out.println("4. Buka/tutup semua sekat");
            System.out.println("5. Tutup zoo");
            option = scanner.next().charAt(0);
            switch (option) {
                case '1':
                    //z->Display(0, 0, width-1, length-1);
                    break;
                case '2':
                    //System.out.println("Daging: " << z->GetTotalMeat() << " kg");
                    //System.out.println("Tumbuhan: " << z->GetTotalVegetables() << "kg");
                    break;
                case '3':
                    //z->Tour();
                    break;
                case '4':
                    //z->ToggleAllSekat();
                    break;
                default :
            }
            //z->MoveAllAnimal();
        } while (option != '5');
    }
}