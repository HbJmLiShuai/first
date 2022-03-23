package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class Filuter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request1=(HttpServletRequest) servletRequest;
        HttpServletResponse response1=(HttpServletResponse) servletResponse;
        HttpSession session = request1.getSession(false);
        String spath=request1.getServletPath();//niubi
        String[] urls={"/denglu.html","/yanzheng"};//niubi
        boolean flag =true;//niubi
        for(String str:urls)//niubi
        {
            if(spath.indexOf(str)!=-1)//niubi
            {
                flag=false;//niubi
                break;
            }//niubi
        }
        if(flag)//niubi
        { if(session==null||session.getAttribute("denglu")==null)
        {
            request1.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
            return;
        }else {  filterChain.doFilter(servletRequest,servletResponse);}//niubi
        }

        else {  filterChain.doFilter(servletRequest,servletResponse);}//niubi

    }

    @Override
    public void destroy() {

    }
}
