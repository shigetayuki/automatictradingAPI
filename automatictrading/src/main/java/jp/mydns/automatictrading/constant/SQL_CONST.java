package jp.mydns.automatictrading.constant;

/**
 * 接頭辞　U:UPDATE,R:READ,D:DELETE
 * 接頭辞ごとに3桁の連番を付与する
 */
public class SQL_CONST {
    //ログイン認証用
    public static final String R001 = "SELECT * FROM user_t WHERE user_t.user_name = :name and user_t.password = :password";
    //Mx全データ取得用
    public static final String R002 = "SELECT  f.fk_id fk_id, f.date f_date, f.time f_time, f.price f_price, f.trend f_trend, f.mountain f_mountain, f.valley f_valley, f.send_flg f_send_flg, fk.sign fk_sign, fk.interest fk_interest, fk.prev_order_location fk_prev_order_location, fs.sign fs_sign, fs.interest fs_interest, fs.prev_order_location fs_prev_order_location, refk.sign refk_sign, refk.interest refk_interest, refk.prev_order_location refk_prev_order_location, mx.sign mx_sign, mx.interest mx_interest, mx.prev_order_location mx_prev_order_location FROM footkey_t f LEFT OUTER JOIN fk_t fk  ON f.fk_id=fk.fk_id LEFT OUTER JOIN fs_t fs  ON f.fk_id=fs.fk_id LEFT OUTER JOIN refk_t refk  ON f.fk_id=refk.fk_id LEFT OUTER JOIN mx_t mx  ON f.fk_id=mx.FK_ID WHERE f.date LIKE :yearMonth";
    //FK取引結果参照
    public static final String R003 = "SELECT substring(footkey_t.date,1,4) AS year,substring(footkey_t.date,6,2) AS month,sum(fk_t.interest) as interest FROM footkey_t INNER JOIN fk_t ON footkey_t.fk_id=fk_t.fk_id GROUP BY substring(footkey_t.date,1,4),substring(footkey_t.date,6,2)";
    //FS取引結果参照
    public static final String R004 = "SELECT substring(footkey_t.date,1,4) AS year,substring(footkey_t.date,6,2) AS month,sum(fs_t.interest) as interest FROM footkey_t INNER JOIN fs_t ON footkey_t.fk_id=fs_t.fk_id GROUP BY substring(footkey_t.date,1,4),substring(footkey_t.date,6,2)";
    //REFK取引結果参照
    public static final String R005 = "SELECT substring(footkey_t.date,1,4) AS year,substring(footkey_t.date,6,2) AS month,sum(refk_t.interest) as interest FROM footkey_t INNER JOIN refk_t ON footkey_t.fk_id=refk_t.fk_id GROUP BY substring(footkey_t.date,1,4),substring(footkey_t.date,6,2)";
    //MX取引結果参照
    public static final String R006 = "SELECT substring(footkey_t.date,1,4) AS year,substring(footkey_t.date,6,2) AS month,sum(mx_t.interest) as interest FROM footkey_t INNER JOIN mx_t ON footkey_t.fk_id=mx_t.fk_id GROUP BY substring(footkey_t.date,1,4),substring(footkey_t.date,6,2)";
    //コードID検索
    public static final String R007 = "SELECT * FROM code_mst WHERE code_id = :codeId";
    //指定した年の鍵足の価格の最大値と最小値を取得する（ネイティブ実装用）
    public static final String R008 = "SELECT MAX(footkey_t.price) as max,MIN(footkey_t.price) as min FROM footkey_t WHERE DATE LIKE ?";
    //指定した年のMXデータを取得
    public static final String R009 = "SELECT  f.fk_id fk_id, f.date f_date, f.time f_time, f.price f_price, f.trend f_trend, f.mountain f_mountain, f.valley f_valley, f.send_flg f_send_flg, fk.sign fk_sign, fk.interest fk_interest, fk.prev_order_location fk_prev_order_location, fs.sign fs_sign, fs.interest fs_interest, fs.prev_order_location fs_prev_order_location, refk.sign refk_sign, refk.interest refk_interest, refk.prev_order_location refk_prev_order_location, mx.sign mx_sign, mx.interest mx_interest, mx.prev_order_location mx_prev_order_location FROM footkey_t f LEFT OUTER JOIN fk_t fk  ON f.fk_id=fk.fk_id LEFT OUTER JOIN fs_t fs  ON f.fk_id=fs.fk_id LEFT OUTER JOIN refk_t refk  ON f.fk_id=refk.fk_id LEFT OUTER JOIN mx_t mx  ON f.fk_id=mx.FK_ID WHERE f.date LIKE :year";
}
