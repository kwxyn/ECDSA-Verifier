import java.io.FileReader;
import java.math.BigInteger;
import java.security.spec.ECPoint;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONReader {

	// JSON READER FOR DATA
	public static ArrayList<Signature> JsonReadForData(String fileName) throws Exception {
		ArrayList<Signature> signatures = new ArrayList<Signature>();
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(fileName);
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray JSONSignatures = (JSONArray) jsonObject.get("Signatures");

		for (int i = 0; i < JSONSignatures.size(); i++) {
			JSONObject JSONSignatureAndText = (JSONObject) JSONSignatures.get(i);
			String text = (String) JSONSignatureAndText.get("text");
			JSONObject JSONSignature = (JSONObject) JSONSignatureAndText.get("signature");
			BigInteger r = new BigInteger((String) JSONSignature.get("r"));
			BigInteger s = new BigInteger((String) JSONSignature.get("s"));
			signatures.add(new Signature(text, r, s));

		}
		return signatures;
	}

	// JSON READER FOR CURVE PARAMETERS DATA
	public static CurveParameters JSONReadForParameters(String fileName) throws Exception {

		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(fileName);
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		String name = (String) jsonObject.get("name");
		BigInteger p = new BigInteger((String) jsonObject.get("p"));
		BigInteger a = new BigInteger((String) jsonObject.get("a"));
		BigInteger b = new BigInteger((String) jsonObject.get("b"));
		JSONObject g = (JSONObject) jsonObject.get("g");
		BigInteger x = new BigInteger((String) g.get("x"));
		BigInteger y = new BigInteger((String) g.get("y"));
		BigInteger n = new BigInteger((String) jsonObject.get("n"));

		JSONObject pk = (JSONObject) jsonObject.get("public key");
		BigInteger PKX = new BigInteger((String) pk.get("x"));
		BigInteger PKY = new BigInteger((String) pk.get("y"));
		ECPoint public_key = new ECPoint(PKX, PKY);

		return new CurveParameters(name, p, a, b, x, y, n, public_key);
	}
}
