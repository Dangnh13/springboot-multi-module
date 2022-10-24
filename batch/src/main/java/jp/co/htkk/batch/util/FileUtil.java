package jp.co.htkk.batch.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    public static String getFileNameFromPath(String filePath) {
        if (filePath != null && filePath.contains("/")) {
            String[] pathSplits = filePath.split("/");
            return pathSplits[pathSplits.length - 1];
        } else {
            LOG.error("This is not file path:\t" + filePath);
            return null;
        }
    }

}
