import java.util.Random;

/**
 * Algorithmen zur Änderung der Pixelpositionen eines Pictures
 * z.B. drehen, spiegeln usw.
 *
 * @author S. Gebert
 * @version 06.2021
 */
public class GeometrischeBildoperationen  implements Bildoperation
{
    private int opCount=5; //number of operations available
    // IDs der geometrischen Operationen
    // Jede geometrische Operation erhält eine eindeutige Zahl,
    // um sich diese besser merken zu können, wird die Zahl einer Konstanten 'static final'
    // mit leserlichem Namen 'OP_<NameDerOperation>' zugeordnet.
    public static final int OP_Nil = 0;
    public static final int OP_SpiegelHorizontal = 1;
    public static final int OP_SpiegelVertikal = 2;
    public static final int OP_DreheLinks = 3;
    public static final int OP_DreheRechts = 4;
    public static final int OP_Drehe180 = 5;

    // ID der aktuell aktiven geometrischen Operation.
    private int op = OP_Nil;

    /**
     * Erstellt eine mit der aktuell aktiven geometrische Operation veränderte Kopie eines Bildes.
     *
     * @param originalBild Das zu verändernde Bild
     * @return Das geänderte Bild
     */
    @Override
    public Picture apply(Picture originalBild)
    {
        // Pro geometrische Operation wird hier eine Zeile benötigt, die die entprechende Operation ausführt.
        switch( this.op ){
            case OP_SpiegelHorizontal: return spiegelHorizontal(originalBild);
            case OP_SpiegelVertikal: return spiegelVertikal(originalBild);
            case OP_DreheLinks: return dreheLinks(originalBild);
            case OP_DreheRechts:
            case OP_Drehe180:
            case OP_Nil:
            default: return originalBild.copy();
        }    
    }

    /**
     * Wählt eine Operation zum Ausführen via apply aus.
     *
     * @param op Nummer der auszuführenden Operation.
     */
    public void setOperation(int op)
    {
        if(op > this.opCount ) return;
        this.op = op;
    }

    // Anleitung zur Erstellung einer weiteren geometrischen Operation.
    // 1. Erstelle eine Methode mit der Signatur "public Picture meineGeometrischeOperation( Picture originalBild )",
    //    (siehe Beispiele unten)
    // 2. Passe wenn nötig die Methode apply an (siehe oben)
    //    und erstelle falls nötig eine neue Konstante "int OP_meineGeometrischeOperation".
    //

    /** 
     * Spiegelt das Bild, so dass rechts und links getauscht werden
     * @param originalBild Ein Bild (Picture), das gespiegelt werden soll
     */
    public Picture spiegelHorizontal(Picture originalBild) {
        int breite = originalBild.getWidth();
        int hoehe  = originalBild.getHeight();

        int[][] pixel = originalBild.getPixelsTable();
        int[][] pixelNeu = new int[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = pixel[(breite-1)-x][y];
            }
        }
        Picture neuesBild = originalBild.copy();
        neuesBild.setPixelsArray(pixelNeu);
        return neuesBild;
    }

    /** 
     * Spiegelt das Bild, so dass oben und unten getauscht werden
     * @param originalBild Ein Bild (Picture), das gespiegelt werden soll
     * @return Eine gespiegelte Kopie des Bildes
     */
    public Picture spiegelVertikal(Picture originalBild) {
        int breite = originalBild.getWidth();
        int hoehe  = originalBild.getHeight();

        int[][] pixel = originalBild.getPixelsTable();
        int[][] pixelNeu = new int[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = pixel[x][y]; //@TODO: Passe diese Zeile so an, dass Vertikal gespiegelt wird.
            }
        }
        Picture neuesBild = originalBild.copy();
        neuesBild.setPixelsArray(pixelNeu); 
        return neuesBild;
    }
   
    /**
     * Dreht ein Bild um 90 Grad gegen den Uhrzeigersinn
     *
     * @param originalBild Ein Bild (Picture), das gedreht werden soll
     * @return Eine um 90 Grad gegen den Uhrzeigersinn gedrehte Kopie des Bildes
     */
    public Picture dreheLinks( Picture originalBild) {
        int breite = originalBild.getWidth();
        int hoehe  = originalBild.getHeight();

        int[][] pixel = originalBild.getPixelsTable() ;
        int[][] pixelNeu = new int[hoehe][breite  ];

        for(int x=0; x < hoehe; x++) {
            for(int y=0;y < breite; y++) {
                pixelNeu[x][y] = pixel[breite-1-y][x];
            }
        }
        Picture neuesBild = originalBild.copy();
        neuesBild.setDimensions(hoehe, breite);
        neuesBild.setPixelsArray(pixelNeu);
        return neuesBild;//@TODO: Kopiere Code aus einer der bereits implementierten Operationen und passe entprechend an.
        
    }

}
