package br.com.viewfx;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuscaCEP {

	public String getEndereco(String CEP) {

		try {
			Document doc = Jsoup
					.connect("http://www.qualocep.com/busca-cep/" + CEP)
					.timeout(120000).get();
			Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
			for (Element urlEndereco : urlPesquisa) {
				return urlEndereco.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		} catch (IOException ex) {
                Logger.getLogger(BuscaCEP.class.getName()).log(Level.SEVERE, null, ex);
            }

		return CEP;
	}

	public String getBairro(String CEP) {

		try {

			Document doc = Jsoup
					.connect("http://www.qualocep.com/busca-cep/" + CEP)
					.timeout(120000).get();
			Elements urlPesquisa = doc.select("td:gt(1)");
			for (Element urlBairro : urlPesquisa) {
				return urlBairro.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		} catch (IOException ex) {
                Logger.getLogger(BuscaCEP.class.getName()).log(Level.SEVERE, null, ex);
            }
		return CEP;
	}

	public String getCidade(String CEP) {

		try {

			Document doc = Jsoup
					.connect("http://www.qualocep.com/busca-cep/" + CEP)
					.timeout(120000).get();
			Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
			for (Element urlCidade : urlPesquisa) {
				return urlCidade.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		} catch (IOException ex) {
                Logger.getLogger(BuscaCEP.class.getName()).log(Level.SEVERE, null, ex);
            }
		return CEP;

	}

	public String getUF(String CEP) {

		try {

			Document doc = Jsoup
					.connect("http://www.qualocep.com/busca-cep/" + CEP)
					.timeout(120000).get();
			Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
			for (Element urlUF : urlPesquisa) {
				return urlUF.text();
			}

		} catch (SocketTimeoutException e) {

		} catch (HttpStatusException w) {

		} catch (IOException ex) {
                Logger.getLogger(BuscaCEP.class.getName()).log(Level.SEVERE, null, ex);
            }
		return CEP;
	}
}