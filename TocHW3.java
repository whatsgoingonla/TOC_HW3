



import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;
import org.json.*;
import java.util.regex.*;


public class TocHw3
{
	public static void main(String[] args) throws IOException, JSONException
	{
		
		int d , y,year;       //交易價格+完成年份
		String s ,yy;
		Pattern city = Pattern.compile(args[1]);
		Pattern road = Pattern.compile(args[2]);
		Pattern myear = Pattern.compile(args[3]);
		yy = args[3];
		int count=0 ,d_sum=0;      //共有幾筆資料+交易額總價+比較年份
		System.out.println(yy);
		try 
		{ 
			URL url = new URL(args[0]);
			URLConnection con = url.openConnection();
			InputStreamReader isr = new InputStreamReader(con.getInputStream(),"UTF-8");
			
            JSONTokener jsontokener = new JSONTokener(isr);
            JSONArray jsonarray = new JSONArray(jsontokener);
            //JSONObject obj = jsonarray.getJSONObject(1);
            //System.out.println(obj.get("鄉鎮市區"));
            //String st  = (String)obj.get("鄉鎮市區");
        	//System.out.println(st);
        	///*
            for(int i=1;i<jsonarray.length();i++)
            {
            	JSONObject obj = jsonarray.getJSONObject(i);
            	
            	String st  = (String)obj.get("鄉鎮市區");
            	//System.out.println(st);
            	year = obj.getInt("交易年月");
            	s = obj.getString("土地區段位置或建物區門牌");
            	d = obj.getInt("總價元");
            	y= Integer.valueOf(yy);
            	Matcher city_match = city.matcher(st);
            	Matcher road_match = road.matcher(s);
            	if(city_match.find()){
            		if(road_match.find()){
            			if((year/100)== y){
            				d_sum += d;
            				count++;
            			}
            		}
            	}
            }
            if(count>=1)
        	{
        		double avg = d_sum/count;
        		System.out.println("Average:" + avg);
        	}//*/
        }          
        
        catch(ArrayIndexOutOfBoundsException e) 
        { 
            System.out.println(
            	"using: java FileDemo pathname"); 
        } 
	}
}
