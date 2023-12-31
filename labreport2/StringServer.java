import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    ArrayList<String> messages = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return formatMessageList(messages);
        } else {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    messages.add(parameters[1]);
                    return formatMessageList(messages);
                }
            }
            return "404 Not Found!";
        }
    }
    public String formatMessageList (ArrayList<String> arrayList) {
        String result = "";
        for(int i = 0; i < arrayList.size(); i++) 
            result += (i+1) + "." + arrayList.get(i) + "\n";    
        return result;
    }    
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
