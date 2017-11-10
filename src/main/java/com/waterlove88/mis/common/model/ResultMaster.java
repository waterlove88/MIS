package com.waterlove88.mis.common.model;

/**
 * 응답 데이터 클래스
 * 내부 클래스로 응답코드(코드, 메시지)를 구성할 때 해당 내부 클래스에 getter가 정의되어 있어야 되는거 같음
 *  
 * @author waterlove88 
 * 2017. 11. 10
 */
public class ResultMaster {

	private ResultCode result;
	private Object body;
	
	public ResultMaster(String code, String message) {
		result = new ResultCode(code, message);
	}
	
	public ResultCode getResult() {
		return result;
	}

	public Object getBody() {
		return body;
	}
	
	public void setBody(Object body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ResultMaster [result=(" + result.toString() + "), body=" + body + "]";
	}

	public class ResultCode {
		private String code;
		private String message;
		
		public ResultCode(String code, String message) {
			this.code = code;
			this.message = message;
		}
		
		public String getCode() {
			return code;
		}
		
		public String getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return "ResultCode [code=" + code + ", message=" + message + "]";
		}
	}
}
