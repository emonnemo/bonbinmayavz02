package animal;
import java.util.TreeSet;
import java.util.Set;
import pair.Pair;
/**
 * Created by ASUS INDONESIA on 3/27/2017.
 */
/**
 * Created by asuspc on 3/27/2017.
 */
public class Animal{
    public Animal(String _id,
                  int _number,
                  char _legend,
                  float _eat,
                  char _type,
                  Pair _position,
                  ) {
        id = _id;
        number = _number;
        legend = _legend;
        eat = _eat;
        type = _type;
        position.first = _position.first;
        position.second = _position.second;
        if(_id == "WF") {
            wolf_nb++;
            food = 0.2;
            weight = 45;
            compatible.add("WF");
            compatible.add("ELP");
            compatible.add("HPP");
            habitat.add('L');
        } else if (_id == "LI") {
            lion_nb++;
            food = 0.5;
            weight = 158;
            compatible.add("LI");
            habitat.add('L');
        } else if (_id == "ZBR") {
            zebra_nb++;
            food = 0.3;
            weight = 226;
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            habitat.add('L');
        } else if (_id == "ELP") {
            elephant_nb++;
            food = 0.7;
            weight = 5000;
            habitat.add('L');
            compatible.add("WF");
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
        } else if (_id == "MCQ") {
            macaque_nb++;
            food=0.2;
            weight = 9;
            habitat.add('L');
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "HG") {
            hog_nb++;
            food = 0.2;
            weight = 68;
            habitat.add('L');
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("HPP");
        } else if (_id == "SHK") {
            shark_nb++;
            food = 0.2;
            weight = 771;
            habitat.add('W');
            compatible.add("SHK");
            compatible.add("WHL");
        } else if (_id == "MRE") {
            moray_eel_nb++;
            food = 0.2;
            weight = 13;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("HPP");
        } else if (_id == "DGG") {
            dugong_nb++;
            food = 0.2;
            weight = 294;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "TRL") {
            turtle_nb++;
            food = 0.05;
            weight = 453;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "DLP") {
            dolphin_nb++;
            food = 0.2;
            weight = 220;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "WHL") {
            whale_nb++;
            food = 0.1;
            weight = 40000;
            habitat.add('W');
            compatible.add("SHK");
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "EGL") {
            eagle_nb++;
            food = 0.7;
            weight = 4;
            habitat.add('A');
            compatible.add("EGL");
            compatible.add("OW");
            compatible.add("PLC");
        } else if (_id == "OW") {
            owl_nb++;
            food = 0.3;
            weight = 2;
            habitat.add('A');
            compatible.add("EGL");
            compatible.add("OW");
            compatible.add("PLC");
            compatible.add("DRL");
        } else if (_id == "HMB") {
            hummingbird_nb++;
            food = 0.3;
            weight = 0.0002;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "CKT") {
            cockatoo_nb++;
            food = 0.3;
            weight = 0.09;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("CLG");
        } else if (_id == "RBN") {
            robin_nb++;
            food = 0.3;
            weight = 0.06;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("CLG");
            compatible.add("DRL");
        } else if (_id == "BT") {
            bat_nb++;
            food = 0.4;
            weight = 0.15;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "PNG") {
            penguin_nb++;
            food = 0.25;
            weight = 22;
            habitat.add('L');
            habitat.add('W');
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "HPP") {
            hippopotamus_nb++;
            food = 0.65;
            weight = 1496;
            habitat.add('L');
            habitat.add('W');
            compatible.add("WF");
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("CLG");
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "PLC") {
            pelican_nb++;
            food = 0.3;
            weight = 7;
            habitat.add('W');
            habitat.add('A');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("EGL");
            compatible.add("OW");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "GSE") {
            goose_nb++;
            food = 0.3;
            weight = 4;
            habitat.add('W');
            habitat.add('A');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "CRN") {
            crane_nb++;
            food = 0.3;
            weight = 3;
            habitat.add('W');
            habitat.add('A');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "DRL") {
            draco_lizard_nb++;
            food = 0.2;
            weight = 0.2;
            habitat.add('L');
            habitat.add('A');
            compatible.add("ZBR");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("OW");
            compatible.add("RBN");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "CLG") {
            colugo_nb++;
            food = 0.25;
            weight = 0.035;
            habitat.add('L');
            habitat.add('A');
            compatible.add("ZBR");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "SGL") {
            sugar_glider_nb++:
            food = 0.5;
            weight = 0.12;
            habitat.add('L');
            habitat.add('A');
            compatible.add("ZBR");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("HMB");
            compatible.add("GSE");
            compatible.add("CRN");
        }
    }
    public Animal(String _id,
                  int _number,
                  char _legend,
                  float _weight,
                  float _eat,
                  char _type,
                  Pair _position) {
        id = _id;
        number = _number;
        legend = _legend;
        weight = _weight;
        eat = _eat;
        type = _type;
        position.first = _position.first;
        position.second = _position.second;
        if(_id == "WF") {
            wolf_nb++;
            food = 0.2;
            compatible.add("WF");
            compatible.add("ELP");
            compatible.add("HPP");
            habitat.add('L');
        } else if (_id == "LI") {
            lion_nb++;
            food = 0.5;
            compatible.add("LI");
            habitat.add('L');
        } else if (_id == "ZBR") {
            zebra_nb++;
            food = 0.3;
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            habitat.add('L');
        } else if (_id == "ELP") {
            elephant_nb++;
            food = 0.7;
            habitat.add('L');
            compatible.add("WF");
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
        } else if (_id == "MCQ") {
            macaque_nb++;
            food=0.2;
            habitat.add('L');
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "HG") {
            hog_nb++;
            food = 0.2;
            habitat.add('L');
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("HPP");
        } else if (_id == "SHK") {
            shark_nb++;
            food = 0.2;
            habitat.add('W');
            compatible.add("SHK");
            compatible.add("WHL");
        } else if (_id == "MRE") {
            moray_eel_nb++;
            food = 0.2;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("HPP");
        } else if (_id == "DGG") {
            dugong_nb++;
            food = 0.2;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "TRL") {
            turtle_nb++;
            food = 0.05;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "DLP") {
            dolphin_nb++;
            food = 0.2;
            habitat.add('W');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "WHL") {
            whale_nb++;
            food = 0.1;
            habitat.add('W');
            compatible.add("SHK");
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "EGL") {
            eagle_nb++;
            food = 0.7;
            habitat.add('A');
            compatible.add("EGL");
            compatible.add("OW");
            compatible.add("PLC");
        } else if (_id == "OW") {
            owl_nb++;
            food = 0.3;
            habitat.add('A');
            compatible.add("EGL");
            compatible.add("OW");
            compatible.add("PLC");
            compatible.add("DRL");
        } else if (_id == "HMB") {
            hummingbird_nb++;
            food = 0.3;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "CKT") {
            cockatoo_nb++;
            food = 0.3;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("CLG");
        } else if (_id == "RBN") {
            robin_nb++;
            food = 0.3;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("CLG");
            compatible.add("DRL");
        } else if (_id == "BT") {
            bat_nb++;
            food = 0.4;
            habitat.add('A');
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "PNG") {
            penguin_nb++;
            food = 0.25;
            habitat.add('L');
            habitat.add('W');
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "HPP") {
            hippopotamus_nb++;
            food = 0.65;
            habitat.add('L');
            habitat.add('W');
            compatible.add("WF");
            compatible.add("ZBR");
            compatible.add("ELP");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("CLG");
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "PLC") {
            pelican_nb++;
            food = 0.3;
            habitat.add('W');
            habitat.add('A');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("EGL");
            compatible.add("OW");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "GSE") {
            goose_nb++;
            food = 0.3;
            habitat.add('W');
            habitat.add('A');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "CRN") {
            crane_nb++;
            food = 0.3;
            habitat.add('W');
            habitat.add('A');
            compatible.add("MRE");
            compatible.add("DGG");
            compatible.add("TRL");
            compatible.add("DLP");
            compatible.add("WHL");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("PLC");
            compatible.add("GSE");
            compatible.add("CRN");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("BT");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
        } else if (_id == "DRL") {
            draco_lizard_nb++;
            food = 0.2;
            habitat.add('L');
            habitat.add('A');
            compatible.add("ZBR");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("OW");
            compatible.add("RBN");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "CLG") {
            colugo_nb++;
            food = 0.25;
            habitat.add('L');
            habitat.add('A');
            compatible.add("ZBR");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("HPP");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("HMB");
            compatible.add("CKT");
            compatible.add("RBN");
            compatible.add("GSE");
            compatible.add("CRN");
        } else if (_id == "SGL") {
            sugar_glider_nb++:
            food = 0.5;
            habitat.add('L');
            habitat.add('A');
            compatible.add("ZBR");
            compatible.add("MCQ");
            compatible.add("HG");
            compatible.add("PNG");
            compatible.add("DRL");
            compatible.add("CLG");
            compatible.add("SGL");
            compatible.add("HMB");
            compatible.add("GSE");
            compatible.add("CRN");
        }
    }
    public final String GetId(){
        return id;
    }
    public final int GetNumber() {
        return number;
    }
    public final float GetWeight() {
        return weight;
    }
    public final float GetEat() {
        return eat;
    }
    public final Pair GetPos() {
        return position;
    }
    public final char GetType() {
        return '';
    }
    public final char GetLegend() {
        return '';
    }
    public final Set<char> GetHabitat() {
        return habitat;
    }
    void SetWeight(float _weight){

    }
    void SetPos(Pair _position) {

    }
    void final Set<String> GetCompatible() {

    }
    public final void Act() {
        if(id == "WF") {

        } else if (id == "LI") {

        } else if (id == "ZBR") {

        } else if (id == "ELP") {

        } else if (id == "MCQ") {

        } else if (id == "HG") {

        } else if (id == "SHK") {

        } else if (id == "MRE") {

        } else if (id == "DGG") {

        } else if (id == "TRL") {

        } else if (id == "DLP") {

        } else if (id == "WHL") {

        } else if (id == "EGL") {

        } else if (id == "OW") {

        } else if (id == "HMB") {

        } else if (id == "CKT") {

        } else if (id == "RBN") {

        } else if (id == "BT") {

        } else if (id == "PNG") {

        } else if (id == "HPP") {

        } else if (id == "PLC") {

        } else if (id == "GSE") {

        } else if (id == "CRN") {

        } else if (id == "DRL") {

        } else if (id == "CLG") {

        } else if (id == "SGL") {

        }
    }
    public final void Interact() {
        if(id == "WF") {

        } else if (id == "LI") {

        } else if (id == "ZBR") {

        } else if (id == "ELP") {

        } else if (id == "MCQ") {

        } else if (id == "HG") {

        } else if (id == "SHK") {

        } else if (id == "MRE") {

        } else if (id == "DGG") {

        } else if (id == "TRL") {

        } else if (id == "DLP") {

        } else if (id == "WHL") {

        } else if (id == "EGL") {

        } else if (id == "OW") {

        } else if (id == "HMB") {

        } else if (id == "CKT") {

        } else if (id == "RBN") {

        } else if (id == "BT") {

        } else if (id == "PNG") {

        } else if (id == "HPP") {

        } else if (id == "PLC") {

        } else if (id == "GSE") {

        } else if (id == "CRN") {

        } else if (id == "DRL") {

        } else if (id == "CLG") {

        } else if (id == "SGL") {

        }
    }
    public final void Desription(String a) {

    }
    public void Move(int direction) {

    }
    //atribut
    private String id;
    private int number;
    private char legend;
    private float weight;
    private float eat;
    private char type;
    private Pair position;
    private TreeSet<String> compatible = new TreeSet<String>();
    private TreeSet<char> habitat = new TreeSet<char>();
    private final float food;
    private static int bat_nb;
    private static int cockatoo_nb;
    private static int colugo_nb;
    private static int crane_nb;
    private static int dolphin_nb;
    private static int draco_lizard_nb;
    private static int dugong_nb;
    private static int eagle_nb;
    private static int elephant_nb;
    private static int goose_nb;
    private static int hippopotamus_nb;
    private static int hog_nb;
    private static int hummingbird_nb;
    private static int lion_nb;
    private static int macaque_nb;
    private static int moray_eel_nb;
    private static int owl_nb;
    private static int pelican_nb;
    private static int penguin_nb;
    private static int robin_nb;
    private static int shark_nb;
    private static int sugar_glider_nb;
    private static int turtle_nb;
    private static int whale_nb;
    private static int wolf_nb;
    private static int zebra_nb;
}
