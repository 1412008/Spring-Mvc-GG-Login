package web.google;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleUtils {

	@Value("${google.app.id}")
	private String client_id;

	@Value("${google.app.secret}")
	private String client_secret;

	@Value("${google.redirect.uri}")
	private String redirect_uri;

	@Value("${google.link.get.token}")
	private String token_link;

	@Value("${google.link.get.user_info}")
	private String userinfo_link;

	public String getToken(final String code) throws Exception {
		System.out.println(client_id + "-" + client_secret + "-" + redirect_uri + "-" + token_link);
		String response;

//		URL theUrl = new URL(token_link);
//		HttpsURLConnection con = (HttpsURLConnection) theUrl.openConnection() ;
//		
//		con.setRequestMethod("POST");
//		con.addRequestProperty("client_id", client_id);
//		con.addRequestProperty("client_secret", client_secret);
//		con.addRequestProperty("redirect_uri", redirect_uri);
//		con.addRequestProperty("grant_type", "authorization_code");
//		con.addRequestProperty("code", code);
//		
//		response = con.getResponseMessage();

//		SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(new TrustSelfSignedStrategy()).build();
//
//		HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
//		// SSLConnectionSocketFactory connectionFactory = new
//		// SSLConnectionSocketFactory(sslContext, allowAllHosts);
//
//		HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
//		httpClient.execute((HttpUriRequest) Request.Post(token_link)
//				.bodyForm(Form.form().add("client_id", client_id).add("client_secret", client_secret)
//						.add("redirect_uri", redirect_uri).add("code", code).add("grant_type", "authorization_code")
//						.build()));
		response = Request.Post(token_link)
				.bodyForm(Form.form().add("client_id", client_id).add("client_secret", client_secret)
						.add("redirect_uri", redirect_uri).add("code", code).add("grant_type", "authorization_code")
						.build())
				.execute().returnContent().asString();
		System.out.println(response);
		return "";
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode node = mapper.readTree(response).get("access_token");
//		return node.textValue();
	}

}
