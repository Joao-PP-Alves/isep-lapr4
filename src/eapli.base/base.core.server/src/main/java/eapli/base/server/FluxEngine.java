package eapli.base.server;

import eapli.base.server.etc.ProtocolConsts;
import eapli.base.server.tcp.TcpFluxSrv;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FluxEngine {

    private static final Logger LOGGER = LogManager.getLogger(FluxEngine.class);

    public static void main(String[] args) {

        LOGGER.info("Kickstarting the Server.");

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());

        TcpFluxSrv srv = new TcpFluxSrv();

        srv.run();

        LOGGER.info("Server Socket Start.");

    }
}
