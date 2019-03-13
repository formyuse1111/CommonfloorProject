package Utilities;

public class Utilities {

    public boolean isStringIsNullEmpty(String str)
    {
        if(str != null && str.length() > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
