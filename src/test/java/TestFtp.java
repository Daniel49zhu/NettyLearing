import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class TestFtp {
    @Test
    public void testFtp() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.1.101",21);
        ftpClient.login("demo1_user","demo1_user");
        FTPFile[] files = ftpClient.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
