import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Edward Teach on 06.01.2015.
 */
public class MarkerRepository
{
    private Vector markers = new Vector();
    ArrayList<String> mak = new ArrayList<String>();

    public MarkerRepository()
    {
        initDefaultMarkerList();
    }

    private void initDefaultMarkerList()
    {
        Marker tmpMarker;
        int pos = 0;

        pos = mak.size();
        mak.add(pos, "player_pos");

        tmpMarker = new Marker("player_pos", "C:\\Users\\Edward Teach\\Pictures\\marker_test.gif");
        this.markers.add(tmpMarker);
    }

}