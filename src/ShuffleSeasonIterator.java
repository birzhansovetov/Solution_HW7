import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements Iterator<Episode> {
    private final List<Episode> shuffled;
    private int index = 0;
    public ShuffleSeasonIterator(List<Episode> shuffled,long seed) {
        this.shuffled = shuffled;
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
