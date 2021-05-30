package eapli.base.server.etc;

public class ProtocolConsts {

    //Current protocol version
    public static final int PROTOCOL_VERSION = 1;

    //255 for message + 1 for version + 1 for response code + 1 for real message size
    public static final int MESSAGE_SIZE = 258;

    //TCP Port to which the server will listen from
    public static final int TCP_PORT = 32507;

    //Positions
    public static final int VERSION_POS = 0;
    public static final int RESPONSE_CODE_POS = 1;
    public static final int RESPONSE_SIZE_POS = 2;
    public static final int RESPONSE_CONTENT_POS = 3;

    //Response codes
    public static final int CODE_TEST = 0; //Carries no data.
    public static final int CODE_END_CONN = 1; //Respond with code 2. Close connection.
    public static final int CODE_CONFIRMATION = 2; //Carries no data.
    public static final int CODE_OVERSIZED = 255; //Oversized message

}
