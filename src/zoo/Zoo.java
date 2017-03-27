/* File   : Driver.java */
/* Author   : Andika Kusuma dan Reinaldo Ignatius Wijaya */

package zoo;

import java.util.ArrayList;

/**
 * Created by ASUS INDONESIA on 3/27/2017.
 */
public class Zoo {
  private int width; /**< dimensi zoo; jumlah baris*/
  private int length;  /**< dimensi zoo; jumlah kolom*/
  private Object cells; /**< matriks Cell yang dimiliki zoo*/
  private ArrayList<Object> animals;  /**< daftar Animals yang ada dalam zoo*/
  private int[][] cage_map;  /**< matriks penanda nomor cage dalam zoo*/
  private int cage_nb; /**< jumlah cage yang ada dalam zoo*/
}
