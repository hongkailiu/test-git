package tk.hongkailiu.test.app.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MD5Util {

    public static String getMd5Hex(String filename) throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(new File(filename));
            return getMd5Hex(is);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    public static String getMd5Hex(InputStream is) throws IOException {
        return DigestUtils.md5Hex(is);
    }
}
