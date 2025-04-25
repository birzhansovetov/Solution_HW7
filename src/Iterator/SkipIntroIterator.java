package Iterator;

import java.util.Iterator;

public class SkipIntroIterator implements Iterator<EpisodeView> {
    private final EpisodeIterator baseIterator;
    private final int skipSeconds;

    public SkipIntroIterator(EpisodeIterator baseIterator, int skipSeconds) {
        this.baseIterator = baseIterator;
        this.skipSeconds = skipSeconds;
    }

    @Override
    public boolean hasNext() {
        return baseIterator.hasNext();
    }

    @Override
    public EpisodeView next() {
        Episode episode = baseIterator.next();
        return new EpisodeView(episode, skipSeconds);
    }
}
