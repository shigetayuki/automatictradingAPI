package jp.mydns.automatictrading.constant;

public class SECURITY_CONST {
    public static final String SECRET = "nyasbasamplesecret";
    public static final long EXPIRATION_TIME = 28_800_000; // 8hours
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String LOGIN_URL = "/login";
    public static final String LOGIN_ID = "userName"; // defalut:username
    public static final String PASSWORD = "password"; // default:password
}
