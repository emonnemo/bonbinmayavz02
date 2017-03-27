/* File     : Driver.java */
/* Author     : Andika Kusuma dan Reinaldo Ignatius Wijaya */

package zoo;

import java.util.ArrayList;

/** \brief Class Zoo
 * \details Kelas Zoo yang berisi kebun binatang itu sendiri beserta hewan-hewannya
 */
public class Zoo {
    private int width; /**< dimensi zoo; jumlah baris*/
    private int length;    /**< dimensi zoo; jumlah kolom*/
    private Object cells; /**< matriks Cell yang dimiliki zoo*/
    private ArrayList<Object> animals;    /**< daftar Animals yang ada dalam zoo*/
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

    }

    /**
     * \brief FindAnimal
     * \details Mengembalikan iterator hewan yang berada di pos
     *
     * \param pos posisi Animal saat itu
     * \return iterator untuk list Animal
     */
    public ArrayList<Object>::iterator FindAnimal(pair<int,int> pos){

    }

    /** \brief AddAnimal
     * \details Menambahkan hewan pada kebun binatang
     * \param animal hewan yang akan ditambahkan
     */
    public void AddAnimal(Object animal){

    }

    /**
     * \brief DelAnimal dengan id
     * \details Menghapus hewan dengan id=_id dan number=_number
     * \param _id id jenis hewan
     * \param _number nomor pada jenis hewan tersebut
     */
    public void DelAnimal(String _id, int _number){

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

    }

    /**
     * \brief GetTotalVegetables
     * \details mengeluarkan total sayur yang diperlukan di zoo dalam kilogram
     * \return Total sayur yang dibutuhkan zoo
     */
    public float GetTotalVegetables(){

    }

    /**
     * \brief MoveAnimal dengan posisi
     * \details Menggerakkan animal dengan id=_id dan number=_number
     * \param pos posisi hewan
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void MoveAnimal(pair<int,int> pos, int direction){

    }

    /**
     * \brief MoveAnimal dengan id
     * \details Menggerakkan animal dengan id=_id dan number=_number ke arah sesuai direction sebanyak 1 langkah jika memungkinkan (tidak melewati sekat)
     * \param _id jenis hewan 
     * \param _number no number pada jenis hewan
     * \param direction 0 untuk ke atas, 1 untuk ke kiri, 2 untuk ke kanan, 3 untuk ke bawah
     */
    public void MoveAnimal(String _id, int _number, int direction){

    }

    /**
     * \brief MoveAllAnimal
     * \details Menggerakkan semua hewan secara acak
     */
    public void MoveAllAnimal(){

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
    public void InteractCage(pair<int, int> pos, int cage_number){

    }
}
