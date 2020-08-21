package com.seguradora.sistema.api.documents;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import com.seguradora.sistema.api.validation.Validacao;

@Document
public class Apolice {
	
	@Id
	private String numero;
	private String dataVigencia;
	private String dataFim;
	private String placa;
	private String valorApolice;
	@Transient
	private long diasVencidos;
	@Transient
	private long diasRestantes;
	@Transient
	private boolean vencida;
	
	public boolean isVencida() {
		return vencida;
	}

	public void setVencida(boolean vencida) {
		this.vencida = vencida;
	}

	public void setDiasVencidos(long diasVencidos) {
		this.diasVencidos = diasVencidos;
	}

	public long getDiasVencidos() {
		this.calculaDias();
		return diasVencidos;
	}

	public long getDiasRestantes() {
		
		return diasRestantes;
	}

	public void setDiasRestantes(int diasRestantes) {
		this.diasRestantes = diasRestantes;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@NotEmpty(message="Data fim de contrato é obrigatório")
	public String getDataVigencia() {
		return dataVigencia;
	}
	
	public void setDataVigencia(String dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
	
	@NotEmpty(message="Data do fim de contrato é obrigatório")
	public String getDataFim() {
		return dataFim;
	}
		
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	@NotEmpty(message ="Favor informar placa do veiculo")
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@NotEmpty(message = "Valor da apolice é obrigatório")
	public String getValorApolice() {
		return valorApolice;
	}
	

	public void setValorApolice(String valorApolice) {
		this.valorApolice = valorApolice;
	}
	
	public void validar(Validacao validar)throws Exception{
		validar.executar();
	}
	
	public void calculaDias() {
		try {
			SimpleDateFormat dataFimF = new SimpleDateFormat("dd/MM/yyyy");
			Date dataVigencia = Calendar.getInstance().getTime();
			Date dataFim = dataFimF.parse(this.dataFim);
			if(dataVigencia.compareTo(dataFim) < 0 ) {
				this.diasRestantes = 1+(dataFim.getTime() - dataVigencia.getTime()) / 86400000;
			}else {
				this.diasVencidos = 1+(dataVigencia.getTime() - dataFim.getTime()) / 86400000;
				this.vencida = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
