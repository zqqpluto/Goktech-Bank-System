package cn.goktech.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.goktech.utils.Result;

@ControllerAdvice
public class MyExceptionHandler {
	Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result handdlerException(Exception exp) {
		if (exp instanceof YonghException) {
			YonghException yonghException = (YonghException)exp;
			String mes = yonghException.getMessage();
			log.error("error {}",exp);
			return Result.fail(mes);
		}
		return Result.fail("默认异常");
	}
}
