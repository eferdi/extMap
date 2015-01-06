/**
 * Created by Edward Teach on 06.01.2015.
 */
public class Marker
{
    private String id;
    private String path;

    public Marker(String id, String path)
    {
        setId(id);
        setPath(path);
    }
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}
