package Iterator;

public class EpisodeView {
    private final Episode episode;
    private final int startFromSec;
    public EpisodeView(Episode episode, int startFromSec) {
        this.episode = episode;
        this.startFromSec = Math.min(startFromSec, episode.getRuntimeSec());
    }
    public void play(){
        System.out.printf("▶ Playing '%s' from %d sec (runtime: %d sec)%n",
                episode.getTitle(), startFromSec, episode.getRuntimeSec());
    }
    public Episode getEpisode() {
        return episode;
    }

    public int getStartFromSec() {
        return startFromSec;
    }
}
