package geoanalytique.util;

public interface Operation {

    public String getTitle();

    public int getArite();

    public void setArgument(int num,Object o);
    

    public Class getClassArgument(int num);

    public Object calculer();

    public String getDescriptionArgument(int num);
}

