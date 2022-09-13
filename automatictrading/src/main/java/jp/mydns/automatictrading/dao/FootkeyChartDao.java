package jp.mydns.automatictrading.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictrading.constant.SQL_CONST;

@Repository
public class FootkeyChartDao {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;
    
    @Value("${spring.datasource.password}")
    private String password;

    /**
     * 指定した年の価格の最大値と最小値を返す
     * @param year
     * @return
     * @throws SQLException
     */
    public List<Integer> getParameterList(String year) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> paramList = new ArrayList<>();

        try{
            con = DriverManager.getConnection(url, username, password);
            
            String sql = SQL_CONST.R008;
            ps=con.prepareStatement(sql);
            ps.setString(1, year + "______");
            rs=ps.executeQuery();
            rs.next();
            paramList.add(rs.getInt("max"));
            paramList.add(rs.getInt("min"));

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return paramList;
    }
}
