import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import java.util.*;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffled;
    private int index = 0;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        this.shuffled = new ArrayList<>(episodes);
        Collections.shuffle(shuffled, new Random(seed));
    }

    @Override
    public boolean hasNext() {
        return index < shuffled.size();
    }

    @Override
    public Episode next() {
        return shuffled.get(index++);
    }
}
