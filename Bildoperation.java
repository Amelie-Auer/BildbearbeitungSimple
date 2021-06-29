/**
 * Interface für eine Bildoperation
 * 
 * 
 * @author S. Gebert
 * @version 06.2021
 */
@FunctionalInterface
public interface  Bildoperation
{

    /**
     * Wendet die Bildoperation auf ein Bild an
     *
     * @param originalbild Das ursprüngliche Bild
     * @return Eine durch die Bildoperation veränderte Kopie des ursprünglichen Bilds.
     */
    public Picture apply(Picture originalBild);
}
