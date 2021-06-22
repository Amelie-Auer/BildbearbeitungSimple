import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

/**
 * Algorithmen zur Änderung der Pixelpositionen eines Pictures
 * z.B. drehen, spiegeln usw.
 *
 * @author Simon Gebert
 * @version 06.2021
 */
public class GeometrischeBildoperationen  extends Bildoperationen
{
    // ID der aktuell aktiven geometrischen Operation.
    private int op;

    // IDs der geometrischen Operationen
    // Jede geometrische Operation erhält eine eindeutige Zahl,
    // um sich diese besser merken zu können, wird die Zahl einer Konstanten 'static final'
    // mit leserlichem Namen 'OP_<NameDerOperation>' zugeordnet.
    public static final int OP_SpiegelHorizontal = 1;
    public static final int OP_SpiegelVertikal = 2;
    public static final int OP_DreheLinks = 3;
    public static final int OP_DreheRechts = 4;
    public static final int OP_Drehe180 = 5;


    /**
     * Erstellt eine mit der aktuell aktiven geometrische Operation veränderte Kopie eines Bildes.
     *
     * @param originalbild Das zu verändernde Bild
     * @return Das geänderte Bild
     */
    @Override
    public PImage apply(PImage originalbild)
    {
        // Pro geometrische Operation wird hier eine Zeile benötigt, die die entprechende (private) Methode aufruft
        switch( this.op ){
            case OP_SpiegelHorizontal: return spiegelHorizontal(originalbild);
            case OP_SpiegelVertikal: return spiegelVertikal(originalbild);
            case OP_DreheLinks: return dreheLinks(originalbild);
            default: return originalbild.copy();
        }
    }
    
    // Anleitung zur Erstellung einer weiteren geometrischen Operation.
    // 1. Erstelle eine public Methode geometrischeOperation( Picture originalBild ),
    //    die die aktuell gewählte Operation festlegt und anschließend ausführt. (siehe Beispiele unten)
    // 2. Erstelle eine private Methode geometrischeOperation( PImage originalBild ),
    //    diese führt die tatsächliche Operation durch. (siehe Beispiele unten)
    //    Mit pixelsExplode( ... ) und pixelsFlatten(...) können Bilddaten 
    //    zwischen eindimensionaler und zweidimensionaler Darstellung umgewandelt werden.
    //
    
    /** 
     * spiegeleHorizontal spiegelt das Bild, so dass rechts und links getauscht werden
     * @param originalbild Ein Bild (Picture), das gespiegelt werden soll
     */
    public void spiegelHorizontal(Picture originalbild) {
        this.op = OP_SpiegelHorizontal; 
        originalbild.runOp( this );
    }

    /** 
     * spiegeleHorizontal spiegelt das Bild, so dass rechts und links getauscht werden
     * @param originalbild Ein Bild (Picture), das gespiegelt werden soll
     * @return Eine gespiegelte Kopie des Bildes
     */
    private PImage spiegelHorizontal(PImage originalbild) {
        int breite = originalbild.width;
        int hoehe  = originalbild.height;

        int[][] pixel = pixelsExplode(originalbild.pixels, breite, hoehe);
        int[][] pixelNeu = new int[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = pixel[(breite-1)-x][y];
            }
        }
        PImage neuesBild = originalbild.copy();
        neuesBild.pixels= pixelsFlatten(pixelNeu); 
        return neuesBild;
    }

    /** 
     * spiegeleVertikal spiegelt das Bild, so dass oben und unten getauscht werden
     * @param originalbild Ein Bild (Picture), das gespiegelt werden soll
     * @return Eine gespiegelte Kopie des Bildes
     */
    public void spiegelVertikal(Picture originalbild) {
        this.op = OP_SpiegelVertikal; 
        originalbild.runOp( this );
    }

    /** 
     * spiegeleVertikal spiegelt das Bild, so dass oben und unten getauscht werden
     * @param originalbild Ein Bild (Picture), das gespiegelt werden soll
     * @return Eine gespiegelte Kopie des Bildes
     */
    private PImage spiegelVertikal(PImage originalbild) {
        int breite = originalbild.width;
        int hoehe  = originalbild.height;

        int[][] pixel = pixelsExplode(originalbild.pixels, breite, hoehe);
        int[][] pixelNeu = new int[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = pixel[x][(hoehe-1)-y];
            }
        }
        PImage neuesBild = originalbild.copy();
        neuesBild.pixels= pixelsFlatten(pixelNeu); 
        return neuesBild;
    }
    
    public void dreheLinks( Picture originalbild) {
        this.op = OP_DreheLinks;
        originalbild.runOp( this );
    }
    
    private PImage dreheLinks( PImage originalbild ){
        int breite = originalbild.width;
        int hoehe  = originalbild.height;

        int[][] pixel = pixelsExplode(originalbild.pixels, breite, hoehe);
        int[][] pixelNeu = new int[hoehe][breite  ];

        for(int x=0; x < hoehe; x++) {
            for(int y=0;y < breite; y++) {
                pixelNeu[x][y] = pixel[breite-1-y][x];
            }
        }
        PImage neuesBild = originalbild.copy();
        neuesBild.pixels= pixelsFlatten(pixelNeu); 
        return neuesBild;
    }
    
}
