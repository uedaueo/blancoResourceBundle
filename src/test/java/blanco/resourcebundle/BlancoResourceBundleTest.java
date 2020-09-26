package blanco.resourcebundle;

import blanco.resourcebundle.task.BlancoResourceBundleProcessImpl;
import blanco.resourcebundle.task.valueobject.BlancoResourceBundleProcessInput;
import org.junit.Test;

import java.io.IOException;

/**
 * リソースバンドルの生成試験
 *
 * @author tueda
 */
public class BlancoResourceBundleTest {

    @Test
    public void testBlancoResourceBundle() {
        BlancoResourceBundleProcessInput input = new BlancoResourceBundleProcessInput();
        input.setMetadir("meta/resourcebundle");
        input.setCommenttimestamp(false);
        input.setLog(true);
        input.setEncoding("UTF-8");
        input.setVerbose(true);
        input.setTmpdir("tmpTest");
        input.setTargetdir("sample/blanco");
        input.setTargetStyle("maven");
        input.setLineSeparator("CRLF");

        BlancoResourceBundleProcessImpl imple = new BlancoResourceBundleProcessImpl();
        try {
            imple.execute(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
