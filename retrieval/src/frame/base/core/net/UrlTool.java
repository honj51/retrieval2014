package frame.base.core.net;

import java.net.URI;

import frame.base.core.util.StringClass;
/**
 * URL、URI 操作
 * @author 
 *
 */
public class UrlTool {
	public UrlTool(){
		
	}

	/**
	 * 取得绝对路径
	 * @param base
	 * @param relative 相对路径
	 * @return URI
	 */
	public URI getResolved(String base,String relative){
		relative=StringClass.getString(relative,"");
		try{
			URI uriBase=new URI(base);
			URI uriRelative=new URI(relative);
			URI uriResolved = uriBase.resolve(uriRelative);
			return uriResolved;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取得相对路径
	 * @param base
	 * @param resolve
	 * @return URI
	 */
	public URI getRelativize(String base,String resolve){
		resolve=StringClass.getString(resolve,"");
		try{
			URI uriBase=new URI(base);
			URI uriResolve=new URI(resolve);
			URI uriRelativize = uriBase.relativize(uriResolve);
			return uriRelativize;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 取得Query
	 * @param base
	 * @return String
	 */
	public String getQuery(String base){
		try{
			URI uriBase=new URI(base);
			String query=uriBase.getQuery();
			query=StringClass.getString(query,"");
			if(!query.equals("")){
				query="?"+query;
			}
			return query;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		UrlTool snoicsUrl=new UrlTool();
		String base="http://127.0.0.1/11/";
		String page="sdfjk/fjewir/dfjk/sdfjkwer/abc.jsp?fjdkf=2434&fdjsf=435";
		//String relative="sdf.jsp?sdjf=23&ew=df4";
		
		String newuri=snoicsUrl.getResolved(base,page).toString();
		System.out.println("newuri="+newuri);
		
		String newuri1=snoicsUrl.getRelativize(base,newuri).toString();
		System.out.println("newuri1="+newuri1);
	}
}
