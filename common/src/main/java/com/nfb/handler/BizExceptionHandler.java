package com.nfb.handler;

import com.nfb.exception.BizException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 *
 * @修改人：邓风森
 * @修改时间： 2015/2/26 10:41.
 */
public class BizExceptionHandler implements HandlerExceptionResolver {
    Log log = LogFactory.getLog(BizExceptionHandler.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = null;
        if (ex instanceof BizException) {
            request.setAttribute("errorType", "业务异常");
            request.setAttribute("errorMsg", ex.getMessage());
            mv = new ModelAndView("redirect:/err/biz");
            return mv;
        } else {
            log.error("发生未知错误：", ex);
            request.setAttribute("errorType", "服务器异常");
            request.setAttribute("errorMsg", "请联系管理员！");
            mv = new ModelAndView("redirect:/err/biz");
            return mv;
        }
    }
}
