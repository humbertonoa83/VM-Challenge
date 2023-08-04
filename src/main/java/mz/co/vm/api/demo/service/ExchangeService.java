package mz.co.vm.api.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mz.co.vm.api.demo.consume.ApiCaller;

@Service
public class ExchangeService {

	@Autowired
	private ApiCaller apicaller;
	
	private String exchangerate;
	
	public ExchangeService(@Value("${exchangerates.api.key}") String exchangerate) {
		this.exchangerate = exchangerate;
	}
	
	//Quando coloco uma base, Ex: base=MZN or base=USD tenho o erro "code":"base_currency_access_restricted".
	//Acredito que no Plano Free nao tenho opcao para escolher uma base currency
	public String getExchange() {
		
		String apiUrl = "http://api.exchangeratesapi.io/v1/latest?access_key=" + exchangerate+"&symbols=USD,AUD,CAD,PLN,MXN&format=1";

        return apicaller.consumeApi(apiUrl);
	}
}
