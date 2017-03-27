/* File  : Cell.java */
/* Author: Gisela Supardi */

package cell;

import java.io.FileInputStream;

/**
 * \brief Class Cell.
 * \details Kelas untuk mengisi sel-sel dalam matriks pada Zoo.
 */
public class Cell {
  private char initial_symbol; /**< simbol asli untuk sel dengan jenis tertentu*/
  private char symbol; /**< simbol yang akan ditampilkan pada layar (dapat dioverwrite animal)*/
  private boolean sekat[4]; /**< state dari sekat untuk habitat; true untuk terbuka, false untuk tertutup */
  private StringBuffer plant; /**< tanaman yang ditanam di taman*/
  private StringBuffer food; /**< jenis makanan yang dijual di restoran*/
  private boolean open; /**< penanda restoran buka atau tutup; true untuk buka, false untuk tutup*/

  /**
   * \brief Constructor dengan parameter.
   * \details Menciptakan cell dengan symbol c.
   * \param c symbol input.
   */
  public Cell(char c) {}

  /**
   * \brief GetInitSymbol.
   * \details membalikan nilai initial_symbol cell.
   * \return init symbol.
   */
  public char GetInitSymbol() {
    return initial_symbol;
  }

  /**
   * \brief GetSymbol.
   * \details mengembalikan nilai simbol cell.
   * \return symbol.
   */
  public char GetSymbol() {
    return symbol;
  }

  /**
   * \brief SetSymbol.
   * \details mengubah symbol dengan s.
   * \param s symbol yang baru.
   */
  public void SetSymbol(char s) {}

  /**
   * \brief Render
   * \details Menampilkan representasi cell pada layar
   */
  public void Render() {}

  /**
   * \brief ToggleSekat
   * \details Memasang atau menghilangkan sekat antar-Cell;
   * tidak diimplementasi pada class ini
   *
   * \param direction arah yang ingin dibuka
   */
  public void ToggleSekat(int direction) {}

  /**
   * \brief GetSekat
   * \details Mengecek apakah ke arah direction terdapat sekat;
   * tidak diimplementasi pada class ini
   *
   * \param direction arah yang ingin dicek
   */
  public boolean GetSekat(int direction) {
    return sekat[direction];
  }

  /**
   * \brief Interact
   * \details Interaksi dengan Cell; tidak diimplementasi pada class ini
   */
  public void Interact() {}

  /**
   * \brief GetFood
   * \details Mengembalikan jenis makanan yang dijual restoran
   * \return string
   */
  public StringBuffer GetFood() {
    return food;
  }

  /**
   * \brief GetOpen
   * \details Mengembalikan status restoran
   * \return bool true jika buka, false jika tutup
   */
  public boolean GetOpen() {
    return open;
  }

  /**
   * \brief SetFood
   * \details Mengubah jenis makanan yang dijual restoran
   * \param f Jenis makanan yang akan dijual
   */
  public void SetFood(string f) {}

  /**
   * \brief ToggleOpen
   * \details Mengubah status restoran
   */
  public void ToggleOpen() {}

  /**
   * \brief GetPlant
   * \details Mengembalikan tanaman yang tertanam pada taman
   * \return string
   */
  public StringBuffer GetPlant() {
    return plant;
  }

  /**
   * \brief SetPlant
   * \details Mengubah tanaman yang tertanam pada taman dengan p
   * \param p Tanaman yang ingin ditanam
   */
  public void SetPlant(string p) {}
}
