import java.util.Random;
import javafx.scene.paint.Color;

/**
 * Algorithmen zur Anwendung von Filtern auf ein Picture
 * z.B. drehen, spiegeln usw.
 *
 * @author S. Gebert
 * @version 06.2021
 */
public class Mehrpixeloperationen  implements Bildoperation
{
    /**
     * Erstellt eine mit der aktuell aktiven Operation veränderte Kopie eines Bildes.
     *
     * @param originalBild Das zu verändernde Bild
     * @return Das geänderte Bild
     */
    @Override
    public Picture apply(Picture originalBild)
    {
        return originalBild.copy();   
    }

    public Picture faltung(Picture originalBild, double[] [] filter)
    {
        int breite = originalBild.getWidth();
        int hoehe  = originalBild.getHeight();
        Color[] [] pixel = originalBild.getPixelsColorTable();
        Color[] [] pixelNeu = pixel.clone();
        int laenge = filter.length;
        int halb = laenge/2; 
        for( int x=halb; x<originalBild.getWidth() -halb; x++ ) {
            for (int y=halb; y<originalBild.getHeight() - halb; y++) {
                int xx = x-halb;
                int yy = y-halb;
                double rot = 0.0;
                double gruen = 0.0;
                double blau = 0.0;
                for (int i=0; i<laenge; i++) {
                    for (int j=0; j<laenge; j++) {
                        rot += filter[i][j] * pixel[xx+i][yy+i].getRed();
                        gruen += filter[i][j] * pixel[xx+i][yy+i].getGreen();
                        blau += filter[i][j] * pixel[xx+i][yy+i].getBlue();
                    }
                }
                if (rot < 0.0) rot = 0.0;
                if (rot > 1.0) rot = 1.0;
                if (gruen < 0.0) gruen = 0.0;
                if (gruen > 1.0) gruen = 1.0;
                if (blau < 0.0) blau = 0.0;
                if (blau > 1.0) blau = 1.0;
                pixelNeu[x][y] = new Color( rot, gruen, blau, 1.0);
            }
        }
        Picture neuesBild = originalBild.copy();
        neuesBild.setPixelsArray(pixelNeu);
        return neuesBild;
    }

}