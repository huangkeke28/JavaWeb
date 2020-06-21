package frank.dao;

import frank.model.Article;
import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDAO {
    public static List<Article> query(int id) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //获取数据库连接
        try {
            c = DBUtil.getConnection();
            String sql = "select a.id, a.id, a.title, a.content, a.user_id, a.create_time from article a join user u on u.id = a.user_id where  u.id=?";
            //创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            //执行sql
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                articles.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询文章列表sql错误,一般都是自己sql写错了", e);
        } finally {//释放资源
            DBUtil.close(c, ps, rs);
        }
        return articles;
    }
}



