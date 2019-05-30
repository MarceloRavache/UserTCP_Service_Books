package ufc.com.br;
//import java.awt.*;
import java.io.*;
import java.net.*;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientTCP {
	
	public void doOperation(Socket objectRef,int methodId,livro objeto) throws FileNotFoundException, IOException {
		JSONObject obj_json = new JSONObject();
		if(methodId == 0) {
			objeto.cadastrar();
			String nome = objeto.getNome();
			String autor = objeto.getAutor();
			String conteudo = objeto.getConteudo();
			obj_json.put("methodId", methodId);
			obj_json.put("nome", nome);
			obj_json.put("autor", autor);
			obj_json.put("conteudo", conteudo);
			try {
				DataOutputStream out = new DataOutputStream(objectRef.getOutputStream());
				DataInputStream in = new DataInputStream(objectRef.getInputStream());
				System.out.println(obj_json.toString());
				out.writeUTF(obj_json.toString());
				String resp_json = in.readUTF();
				
			}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
	        } catch(IOException e) {System.out.println("readline:"+e.getMessage());
	        } finally{ try {objectRef.close();}catch (IOException e){/*close failed*/}}
		}else if(methodId == 1) {
			objeto.baixar();
			String resp_json;
			String nome = objeto.getNome();
			obj_json.put("methodId", methodId);
			obj_json.put("nome", nome);
			try {
				DataOutputStream out = new DataOutputStream(objectRef.getOutputStream());
				DataInputStream in = new DataInputStream(objectRef.getInputStream());
				out.writeUTF(obj_json.toString());
				resp_json = in.readUTF();
				
			}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
	        } catch(IOException e) {System.out.println("readline:"+e.getMessage());
	        } finally{ try {objectRef.close();}catch (IOException e){/*close failed*/}}
			String conteudo = obj_json.getString("conteudo");
			objeto.gravar(conteudo);
		}
	}
}