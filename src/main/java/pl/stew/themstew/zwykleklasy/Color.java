package pl.stew.themstew.zwykleklasy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Component
public class Color {

    public String getWitaj() {
        return witaj;
    }

    public void setWitaj(String witaj) {
        this.witaj = witaj;
    }

    String witaj = "Hello";
    private final int FOUR = 4;
    private final int EIGHT = 8;
    static int licznik = 8;
    static int howEnter = 1;
    static public boolean end = true;
    public static String[] tabT = new String[4];
    public static String[] tab = new String[88];
    public static Map<String, String> myMap = new HashMap<>();
    private String kol;

    public String[] getTab() {
        return tab;
    }

    public String getTabString(int a) {
        return tab[a];
    }

    public void setTab(String[] tab) {
        this.tab = tab;
    }

    public Color() {
    }

    public Color(String kol) {
        this.kol = kol;
    }

    public String getKol() {
        return kol;
    }

    public void setKol(String kol) {
        this.kol = kol;
    }

    public String[] spColor() {
        int li = licznik;
            char[] chars = kol.toCharArray();
                   if (end) {
                for (int i = 0; i < FOUR; i++) {
                    switch (chars[i]) {
                        case 'o':
                            tab[li] = "/img/O.png";
                            li++;
                            break;
                        case 'r':
                            tab[li] = "/img/R.png";
                            li++;
                            break;
                        case 'v':
                            tab[li] = "/img/V.png";
                            li++;
                            break;
                        case 'y':
                            tab[li] = "/img/Y.png";
                            li++;
                            break;
                        case 'g':
                            tab[li] = "/img/G.png";
                            li++;
                            break;
                        case 'b':
                            tab[li] = "/img/B.png";
                            li++;
                            break;
                    }
                }
                setWitaj("Fine...go ");
                sprawdzam();
            }              return tab;
    }

    public String[] wypelnijTab() {
        String ramka = "/img/Rm.png";
        for (int i = 0; i < tab.length; i++) {
            tab[i] = "/img/Rd.png";
        }

        for (int i = 0; i < (tab.length / EIGHT); i++) {
            for (int j = 0; j < FOUR; j++) {
                tab[i * EIGHT + FOUR + j] = ramka;
            }
        }
        return tab;
    }

    public String zamianaL(int a) {
        switch (a) {
            case 0:
                return "/img/B.png";
            case 1:
                return "/img/G.png";
            case 2:
                return "/img/O.png";
            case 3:
                return "/img/R.png";
            case 4:
                return "/img/V.png";
            case 5:
                return "/img/Y.png";
            default:
                return "/img/mc.png";
        }
    }

    public void rand() {
        wypelnijTab();
        for (int i = 0; i < FOUR; i++) {
            Random r = new Random();
            int a = r.nextInt(6);
            tabT[i] = zamianaL(a);
            tab[i] = "/img/X.png";
        }
    }

    public Map<String, String> getMyMap() {
        for (int i = 0; i < tab.length; i++) {
            String a = "a" + i;
            String b = tab[i];
            myMap.put(a, b);
        }
        return myMap;
    }

    public void sprawdzam() {
         String[] tabS = new String[FOUR];
        for (int i = 0; i < FOUR; i++) {
            tabS[i] = tabT[i];
        }
        String[] tabI = new String[FOUR];
        for (int i = 0; i < FOUR; i++) {
            tabI[i] = tab[licznik +i];
        }
        int a = 0;
        int b = 0;
        for (int j = 0; j < FOUR; j++) {
            if (tabI[j] == tabS[j]) {
                tab[licznik + FOUR + b] = "/img/mc.png";
                tabS[j] = " tabS " + j;
                tabI[j]="fff"+b;
                b++;
            }
        }
        for (int i = 0; i < FOUR; i++) {
            for (int j = 0; j < FOUR; j++) {


                if (tabI[i] == tabS[j]) {
                    tab[licznik + FOUR + a + b] = "/img/mb.png";
                    tabS[j] = " tabSs " + i;
                    j = FOUR;
                    a++;
                }
            }
        }
        if (b == 4) {
            setWitaj("Winner");
            for (int i = 0; i < FOUR; i++) {
                tab[i] = tabT[i];
                end = false;
            }
        }
        if (tab[82] != "/img/Rd.png") {
            setWitaj(" You lost");
            for (int i = 0; i < FOUR; i++) {
                tab[i] = tabT[i];
                end = false;
            }
        }
        licznik = licznik + EIGHT;
    }

    public void resetM() {
        licznik = 8;
        howEnter = 1;
        end = true;
        rand();
    }
}
