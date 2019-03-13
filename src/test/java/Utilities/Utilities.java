package Utilities;

import org.apache.log4j.Logger;

public class Utilities {
    private final Logger logger = Logger.getLogger(this.getClass());


    public boolean isStringIsNullEmpty(String str)
    {
        logger.debug("Going to check if the following string is null or empty: " + str);
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
