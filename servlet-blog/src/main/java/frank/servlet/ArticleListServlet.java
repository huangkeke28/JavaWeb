package frank.servlet;


import frank.dao.ArticleDAO;
import frank.model.Article;
import frank.model.Response;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

//@WebServlet("articleList")
public class ArticleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//请求体编码
        resp.setCharacterEncoding("UTF-8");//响应体编码
        resp.setContentType("application/json; charset=UTF-8");//浏览器接收数据之后解析的方式

        String id = req.getParameter("id");//获取前端数据,用户id
        //jdbc操作,查询文章列表(根据用户id查询关联的所有文章)
        Response response = new Response();
        try {
            List<Article> articles = ArticleDAO.query(Integer.parseInt(id));
            response.setSuccess(true);
            response.setData(articles);
        } catch (Exception e) {//出现异常返回success = false, 并设置错误消息,异常堆栈信息
            response.setMessage(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            response.setStackTrace(sw.toString());

        }
        //响应数据时json数据的格式
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(response));
        pw.flush();

    }
}
