package eapli.base.server.tcp;

import eapli.base.server.etc.ProtocolConsts;

public class RespondAffirmative {

    public static byte[] getMessage()
    {
        byte[] response = new byte[ProtocolConsts.MESSAGE_SIZE];
        response[ProtocolConsts.VERSION_POS] = ProtocolConsts.PROTOCOL_VERSION;
        response[ProtocolConsts.RESPONSE_CODE_POS] = ProtocolConsts.CODE_CONFIRMATION;
        response[ProtocolConsts.RESPONSE_SIZE_POS] = 0;

        return response;
    }
}
