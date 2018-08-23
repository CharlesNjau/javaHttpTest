/*Simple Http post request using java URI
 * */

package JavaHttp;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
public class JavaHttp extends JSONArray {
	private static String USER_AGENT = "Mozilla/5.0";

	private String URL=null;
	private static String Name;
	private static String Name2;
	public static void httpget () throws Exception{
        String url = "http://slimapp/api/customers";
		
        URL obj = new URL(url);
		
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        // optional default is GET
		con.setRequestMethod("GET");
		
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		//Json stuf
		// Name=new String();
		
		
		 
		 String Tstr = "[{ \"name\": \"Alice\", \"age\": \"20\" }]";
		 String data="";

		while ((inputLine = in.readLine()) != null) {
			
			response.append(inputLine);
			 
		}
		in.close();
		
		
		// JSONArray jsonarray = new JSONArray(Tstr);
		 //for (int i = 0; i < jsonarray.length(); i++) {
		   //  JSONObject jsonobject = jsonarray.getJSONObject(i);
		     //Name = jsonobject.getString("name");
		     //String url = jsonobject.getString("url");
		 //}
		 
		// System.out.println("name is: "+ Name);
		 //System.out.println(Tstr);
		List<String> Data = new ArrayList<String>();
		 JSONArray x = new JSONArray(response.toString()); 
		 for (int i = 0; i < x.length(); i++) {
		     JSONObject jobj = x.getJSONObject(i);
		     Name2 = jobj.getString("last_name");
		     //Data.add(jobj.get("first_name").toString());
		     //Add value to list here
		     System.out.println( i+"."+jobj.get("first_name").toString());
		    
		     //String url = jsonobject.getString("url");
		 }
   
		
	
		 System.out.println("Last name: "+	Data.get(3));
		//System.out.println(response);
		
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Perform simple get in java
		
		 
		
		JavaHttp.httpget();

	}

}
