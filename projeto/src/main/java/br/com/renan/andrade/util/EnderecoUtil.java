package br.com.renan.andrade.util;

import java.io.*;
import java.net.*;

import org.json.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

public class EnderecoUtil {
	
	public static Endereco preencheEnderecoJSON(String cep) {
		cep.replace("-", "");
		Endereco endereco = new Endereco();
		String url = "http://viacep.com.br/ws/" + cep + "/json/unicode";
		JSONObject meuEndereco = new JSONObject(getHttpGET(url));
		endereco.setCidEndereco(meuEndereco.getString("localidade"));
		endereco.setBairroEndereco(meuEndereco.getString("bairro"));
		endereco.setRuaEndereco(meuEndereco.getString("logradouro"));
		endereco.setCdUf(new EstadoDao().buscaPorSigla(meuEndereco.getString("uf")));
		endereco.setCepEndereco(meuEndereco.getString("cep"));
		return endereco;
	}
	
	private static String getHttpGET(String urlIn) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlIn);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
