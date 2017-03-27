/* File     : Driver.java */
/* Author     : Andika Kusuma dan Reinaldo Ignatius Wijaya */

package zoo;

import animal.Animal;
import cell.Cell;
import pair.Pair;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

/** \brief Class Zoo
 * \details Kelas Zoo yang berisi kebun binatang itu sendiri beserta hewan-hewannya
 */
public class Zoo {
    private int width; /**< dimensi zoo; jumlah baris*/
    private int length;    /**< dimensi zoo; jumlah kolom*/
    private Cell[][] cells; /**< matriks Cell yang dimiliki zoo*/
    private ArrayList<Animal> animals;    /**< daftar Animals yang ada dalam zoo*/
    private int[][] cage_map;    /**< matriks penanda nomor cage dalam zoo*/
    private int cage_nb; /**< jumlah cage yang ada dalam zoo*/

    /**
     * \brief Constructor
     * \details Mengenerate kebun binatang dari file eksternal denangan list hewan kosong
     */
    public Zoo(){
    }
    
    /**
     * \brief Constructor
     * \details Mengenerate kebun binatang dengan input dari user
     * \param w width lebar kebun binatang
     * \param l length panjang kebun binatang
     */
    public Zoo(int w, int l){

    }

    /** \brief Display
     * \details Menampilkan kebun binatang ke layar
     */
    public void Display(int x1, int y1, int x2, int y2){
        for (int i = x1; i <= x2; ++i) {
            for (int j = y1; j <= y2; ++j) {
                System.out.print(cells[i][j].GetSymbol());
            }
            System.out.println();
        }
    }

    /**
     * \brief FindAnimal
     * \details Mengembalikan iterator hewan yang berada di pos
     *
     * \param pos posisi Animal saat itu
     * \return int untuk indeks arraylist animals
     */
    public int FindAnimal(Pair pos){

        return 0;
    }

    /** \brief AddAnimal
     * \details Menambahkan hewan pada kebun binatang
     * \param animals hewan yang akan ditambahkan
     */
    public void AddAnimal(Animal animals){

    }

    /**
     * \brief DelAnimal dengan id
     * \details Menghapus hewan dengan id=_id dan number=_number
     * \param _id id jenis hewan
     * \param _number nomor pada jenis hewan tersebut
     */
    public void DelAnimal(String _id, int _number){
        int i = 0;
        while (animals.get(i).GetId().equals(_id) && animals.get(i).GetNumber() != _number && i < animals.size() - 1) {
            ++i;
        }
        if (animals.get(i).GetId() == _id && animals.get(i).GetNumber() == _number) {
            animals.remove(i);
        }
        int posx = animals.get(i).GetPos().first;
        int posy = animals.get(i).GetPos().second;
        //MakroSetterCell(SetSymbol,cells[posx][posy],GetInitSymbol(cells[posx][posy]));
    }

    /**
     * \brief DelAnimal
     * \details Menghapus hewan pada posisi x y
     * \param x posisi pada width
     * \param y posisi pada length
     */
    public void DelAnimal(int x, int y){

    }

    /**
     * \brief GetTotalMeat
     * \details mengeluarkan total daging yang diperlukan di zoo dalam kilogram
     * \return Total daging yang dibutuhkan zoo
     */
    public float GetTotalMeat(){
        float sum = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).GetType() == 'K') {
                sum += animals.get(i).GetWeight() * animals.get(i).GetEat();
            }
            else if (animals.get(i).GetType() == 'O') {
                sum += 0.5 * animals.get(i).GetWeight() * animals.get(i).GetEat();
            }
        }
        return sum;
    }

    /**
     * \brief GetTotalVegetables
     * \details mengeluarkan total sayur yang diperlukan di zoo dalam kilogram
     * \return Total sayur yang dibutuhkan zoo
     */
    public float GetTotalVegetables(){
        float sum = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).GetType() == 'H') {
                sum += animals.get(i).GetWeight() * animals.get(i).GetEat();
            }
            else if (animals.get(i).GetType() == 'O') {
                sum += 0.5 * animals.get(i).GetWeight() * animals.get(i).GetEat();
            }
        }
        return sum;
    }

    /**
     * \brief MoveAnimal dengan posisi
     * \details Menggerakkan animals dengan id=_id dan number=_number
     * \param pos posisi hewan
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void MoveAnimal(Pair pos, int direction){

    }

    /**
     * \brief MoveAnimal dengan id
     * \details Menggerakkan animals dengan id=_id dan number=_number ke arah sesuai direction sebanyak 1 langkah jika memungkinkan (tidak melewati sekat)
     * \param _id jenis hewan 
     * \param _number no number pada jenis hewan
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void MoveAnimal(String _id, int _number, int direction){
        int i = 0;
        while (animals.get(i).GetId() != _id && animals.get(i).GetNumber() != _number && i < animals.size() - 1) {
            ++i;
        }
        if (animals.get(i).GetId() == _id && animals.get(i).GetNumber() == _number) {
            MoveAnimal(animals.get(i).GetPos(), direction);
        }
    }

    /**
     * \brief MoveAllAnimal
     * \details Menggerakkan semua hewan secara acak
     */
    public void MoveAllAnimal(){
        Random random = new Random();
        for (int i = 0; i < animals.size(); i++) {
            MoveAnimal(animals.get(i).GetPos(),random.nextInt(4));
        }
    }

    /**
     * \brief ToggleSekat
     * \details Membuka/menutup sekat pada posisi i,j ke arah direction jika memungkinkan (tidak membuka ke luar cage)
     * \param i posisi pada width
     * \param j posisi pada length
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void ToggleSekat(int i, int j, int direction){

    }

    /**
     * \brief ToggleAllSekat
     * \details Membuka/menutup semua sekat
     */
    public void ToggleAllSekat(){

    }

    /**
     * \brief Melakukan tour pada kebun binatang
     * \details Jalur tour akan dipilih secara acak
     * \details Settiap cell yang ada di samping road yang dilalui akan diinteract. Suatu cell adalah bagian dari suatu cage, maka semua binatang pada cage tersebut akan diinteract
     */
    public void Tour(){

    }

    /**
     * \brief InteractCage
     * \details Melakukan interaksi dengan semua hewan yang ada di cage yang sama. Cage memiliki posisi pos dan nomor cage_number
     * \param pos posisi cage
     * \param cage_number nomor cage
     */
    public void InteractCage(Pair pos, int cage_number){

    }
}
