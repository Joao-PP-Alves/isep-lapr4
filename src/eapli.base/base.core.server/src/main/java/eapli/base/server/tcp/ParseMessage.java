package eapli.base.server.tcp;

import eapli.base.server.etc.ProtocolConsts;

public class ParseMessage {

    public static int getVersion(byte message[]) {
        return Byte.toUnsignedInt(message[ProtocolConsts.VERSION_POS]);
    }

    public static int getCode(byte message[]) {
        return Byte.toUnsignedInt(message[ProtocolConsts.RESPONSE_CODE_POS]);
    }

    public static int messageSize(byte message[]) {
        return Byte.toUnsignedInt(message[ProtocolConsts.RESPONSE_SIZE_POS]);
    }
}
