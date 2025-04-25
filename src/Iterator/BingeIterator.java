package Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BingeIterator implements EpisodeIterator {
    private final Iterator<Season> seasonIterator;
    private EpisodeIterator currentEpisodeIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasonIterator = seasons.iterator();
        if (seasonIterator.hasNext()) {
            currentEpisodeIterator = seasonIterator.next().normalIterator(); // используем обычный порядок
        }
    }
    @Override
    public boolean hasNext() {
        while (currentEpisodeIterator != null) {
            if (currentEpisodeIterator.hasNext()) {
                return true;
            } else if (seasonIterator.hasNext()) {
                currentEpisodeIterator = seasonIterator.next().normalIterator();
            } else {
                return false;
            }
        }
        return false;
    }
    @Override
    public Episode next() {
        if (!hasNext()) throw new NoSuchElementException();
        return currentEpisodeIterator.next();
    }
}
