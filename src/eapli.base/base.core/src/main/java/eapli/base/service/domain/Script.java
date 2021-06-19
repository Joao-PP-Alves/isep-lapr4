package eapli.base.service.domain;

import javax.persistence.Embeddable;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

@Embeddable
public class Script {

    private Blob script;

    public Script(String script) {
        try {
            this.script = new SerialBlob(script.getBytes());
        } catch (SQLException se) {
            System.out.println(se);
        }
    }

    protected Script() {
    }

    public String getScript() {
        return script.toString();
    }

    public void setScript(String script) {
        try {
            this.script = new SerialBlob(script.getBytes());
        } catch (SQLException se) {
            System.out.println(se);
        }
    }
}
