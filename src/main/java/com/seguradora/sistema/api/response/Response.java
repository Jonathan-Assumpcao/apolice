package com.seguradora.sistema.api.response;

public class Response<T> {
	
	private T data;
	private String erro;
	
	public Response(String erro) {
		this.setErro(erro);
	}

	public Response(T data){
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
}
